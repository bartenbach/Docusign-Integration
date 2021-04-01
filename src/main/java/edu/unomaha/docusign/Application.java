package edu.unomaha.docusign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableWebSecurity
public class Application extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/login**", "/error**", "/oauth2/authorization/docusign**").permitAll()
                .anyRequest().authenticated()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
                .and().oauth2Login();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        List<ClientRegistration> registrations = new ArrayList<>();
        registrations.add(docusignClientRegistration());
        return new InMemoryClientRegistrationRepository(registrations);
    }

    private ClientRegistration docusignClientRegistration() {
        return ClientRegistration.withRegistrationId("docusign")
                .clientId("5f178629-92f1-431f-a323-3b6852e823a0")
                .clientSecret("8f02b844-499f-460f-bda9-f354f5f2ce05")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .authorizationUri("https://account-d.docusign.com/oauth/auth")
                .tokenUri("https://account-d.docusign.com/oauth/token")
                .userInfoUri("https://account-d.docusign.com/oauth/userinfo")
                .userNameAttributeName("sub")
                .clientName("Docusign").build();
    }

}
