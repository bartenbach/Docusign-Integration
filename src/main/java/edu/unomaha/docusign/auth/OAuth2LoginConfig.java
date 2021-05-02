package edu.unomaha.docusign.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class OAuth2LoginConfig {

    private static final String AUTHENTICATION_SCOPE = "signature";
    private static final String DOCUSIGN_API_ENDPOINT = "https://account-d.docusign.com/oauth";
    private static final String REGISTRATION_ID = "docusign";
    private static final String CLIENT_ID = "5f178629-92f1-431f-a323-3b6852e823a0";
    private static final String CLIENT_SECRET = "8f02b844-499f-460f-bda9-f354f5f2ce05";

    private ClientRegistration docusignClientRegistration() {
        return ClientRegistration.withRegistrationId(REGISTRATION_ID)
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .scope(AUTHENTICATION_SCOPE)
                .authorizationUri(DOCUSIGN_API_ENDPOINT + "/auth")
                .tokenUri(DOCUSIGN_API_ENDPOINT + "/token")
                .userInfoUri(DOCUSIGN_API_ENDPOINT + "/userinfo")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .clientName(REGISTRATION_ID)
                .build();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.docusignClientRegistration());
    }

    @Bean
    @RequestScope
    public Docusign docusign(OAuth2AuthorizedClientService clientService) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String accessToken = null;
        if (authentication.getClass().isAssignableFrom(OAuth2AuthenticationToken.class)) {
            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
            String clientRegistrationId = oauthToken.getAuthorizedClientRegistrationId();
            if (clientRegistrationId.equals(REGISTRATION_ID)) {
                OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(clientRegistrationId, oauthToken.getName());
                accessToken = client.getAccessToken().getTokenValue();
            }
        }
        return new Docusign(accessToken);
    }

    @EnableWebSecurity
    public static class OAuth2LoginSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/login/**", "/oauth2/**").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .oauth2Login()
                    .and();
        }
    }
}
