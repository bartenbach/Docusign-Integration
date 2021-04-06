
package edu.unomaha.docusign.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationEndpoint {

    @GetMapping("/oauth2/authorization/docusign")
    public String getToken() {
        return "hello world";
    }

}
