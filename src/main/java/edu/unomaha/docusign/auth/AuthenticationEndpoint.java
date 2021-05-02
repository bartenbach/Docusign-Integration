package edu.unomaha.docusign.auth;

import com.docusign.esign.model.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.unomaha.docusign.docusign.UserInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationEndpoint {

    @GetMapping("/user")
    public String info(@AuthenticationPrincipal OAuth2User principal) {
        return principal.getName();
    }

    @GetMapping("/ds/test")
    ResponseEntity<OAuth2AuthenticationToken> hello(OAuth2AuthenticationToken currentUser) {
        return ResponseEntity.ok(currentUser);
    }

}
