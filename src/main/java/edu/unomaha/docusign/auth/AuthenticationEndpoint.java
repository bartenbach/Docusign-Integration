
package edu.unomaha.docusign.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthenticationEndpoint {

    @GetMapping("/oauth2/authorization/docusign")
    public String getToken() {
        return "hello world";
    }

}

