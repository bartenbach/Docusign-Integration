
package edu.unomaha.docusign.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AuthenticationEndpoint {

    private static final String DOCUSIGN_OAUTH_CALLBACK_URL = "/ds/callback";

    @GetMapping(DOCUSIGN_OAUTH_CALLBACK_URL)
    @ResponseBody
    public RedirectView getToken(@RequestParam String code, @RequestParam(required = false) String state) {
        System.out.println("Received authentication token: " + code);
        return new RedirectView("/");
    }

    public static String getDocusignOauthCallbackUrl() {
        return DOCUSIGN_OAUTH_CALLBACK_URL;
    }
}
