package edu.unomaha.docusign;

import java.util.ArrayList;
import java.util.List;

import edu.unomaha.docusign.auth.AuthenticationEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.AuthenticatedPrincipalOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.web.context.annotation.RequestScope;

@SpringBootApplication
@EnableWebSecurity
public class Application extends WebSecurityConfigurerAdapter {

    private static final String AUTHENTICATION_SCOPE = "signature";
    private static final String DOCUSIGN_API_ENDPOINT = "https://account-d.docusign.com/oauth";
    private static final String REGISTRATION_ID = "docusign";
    private static final String CLIENT_ID = "5f178629-92f1-431f-a323-3b6852e823a0";
    private static final String CLIENT_SECRET = "8f02b844-499f-460f-bda9-f354f5f2ce05";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/*",
                        "/static/**",
                        "/login**",
                        "/error**",
                        AuthenticationEndpoint.getDocusignOauthCallbackUrl() + "**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
                .and()
                    .oauth2Login()
                    .defaultSuccessUrl("/")
                    .failureUrl("/login")
                    .clientRegistrationRepository(this.clientRegistrationRepository())
                    .authorizedClientRepository(this.authorizedClientRepository(
                            this.authorizedClientService(
                                    this.clientRegistrationRepository())))
                    .authorizedClientService(this.authorizedClientService(this.clientRegistrationRepository()))
                .and()
                    .csrf()
                    .disable();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.docusignClientRegistration());
    }

    @Bean
    public OAuth2AuthorizedClientService authorizedClientService(
            ClientRegistrationRepository clientRegistrationRepository) {
        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository);
    }

    @Bean
    public OAuth2AuthorizedClientRepository authorizedClientRepository(
            OAuth2AuthorizedClientService authorizedClientService) {
        return new AuthenticatedPrincipalOAuth2AuthorizedClientRepository(authorizedClientService);
    }


    private ClientRegistration docusignClientRegistration() {
        return ClientRegistration.withRegistrationId(REGISTRATION_ID)
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .clientAuthenticationMethod(ClientAuthenticationMethod.POST)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/" + AuthenticationEndpoint.getDocusignOauthCallbackUrl())
                .scope(AUTHENTICATION_SCOPE)
                .authorizationUri(DOCUSIGN_API_ENDPOINT + "/auth")
                .tokenUri(DOCUSIGN_API_ENDPOINT + "/token")
                .userInfoUri(DOCUSIGN_API_ENDPOINT + "/userinfo")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .clientName(REGISTRATION_ID)
                .build();
    }

    @Bean
    @RequestScope
    public Docusign docusign(OAuth2AuthorizedClientService clientService) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String accessToken = null;
        if (authentication.getClass().isAssignableFrom(OAuth2AuthenticationToken.class)) {
            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
            System.out.println("OAUTH TOKEN: " + oauthToken);
            String clientRegistrationId = oauthToken.getAuthorizedClientRegistrationId();
            if (clientRegistrationId.equals(REGISTRATION_ID)) {
                OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(clientRegistrationId, oauthToken.getName());
                accessToken = client.getAccessToken().getTokenValue();
                System.out.println("ACCESS TOKEN: " + accessToken);
            }
        }
        return new Docusign(accessToken);
    }

    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager(
            ClientRegistrationRepository clientRegistrationRepository,
            OAuth2AuthorizedClientRepository authorizedClientRepository) {
        OAuth2AuthorizedClientProvider authorizedClientProvider =
                OAuth2AuthorizedClientProviderBuilder.builder()
                        .refreshToken()
                        .build();
        DefaultOAuth2AuthorizedClientManager authorizedClientManager =
                new DefaultOAuth2AuthorizedClientManager(
                        this.clientRegistrationRepository(),
                        this.authorizedClientRepository(this.authorizedClientService(this.clientRegistrationRepository())));
        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
        return authorizedClientManager;
    }

    public String getDocusignApiEndpoint() {
        return DOCUSIGN_API_ENDPOINT;
    }

}
