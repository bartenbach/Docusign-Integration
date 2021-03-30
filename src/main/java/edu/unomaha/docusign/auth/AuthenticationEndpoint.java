package edu.unomaha.docusign.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationEndpoint {

    @RequestMapping("/oauth2/authorization/docusign")
    public void handleAuth() {
        System.out.println("Made it to handler");
    }
}
