package edu.unomaha.docusign.auth;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Base64;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api")
public class AuthenticationEndpoint {
    private final String BASE_URL = "https://account-d.docusign.com/oauth/auth";
    private final String QUERY_PARAMS = "?response_type=code&scope=signature";
    private final String CLIENT_ID = "&client_id=5f178629-92f1-431f-a323-3b6852e823a0";
    private final String REDIRECT_URL = "&redirect_uri=http://localhost:8080/api/token";

    private final String TOKEN_BASE_URL = "https://account-d.docusign.com/oauth/token";
    private final String SECRET_KEY = "8f02b844-499f-460f-bda9-f354f5f2ce05";
    private final String AUTH_TYPE = "grant_type=authorization_code";

    @RequestMapping("/auth")
    public RedirectView getToken(RedirectAttributes attributes) {
        return new RedirectView(BASE_URL + QUERY_PARAMS + CLIENT_ID + REDIRECT_URL);
    }

    @RequestMapping("/token")
    public String getToken(@RequestParam(name = "code") String code) throws Exception {
        StringBuilder data = new StringBuilder().append(AUTH_TYPE).append("&code=").append(code);
        System.out.println(data.toString());

        HttpClient client = HttpClient.newBuilder().build();
        String key = code + ":" + SECRET_KEY;
        String base64EncodedKey = Base64.getEncoder().encodeToString(key.getBytes());
        HttpRequest request = HttpRequest.newBuilder().POST(BodyPublishers.ofString(data.toString()))
                .setHeader("Authorization", "Basic " + base64EncodedKey).setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/x-www-form-urlencoded").uri(URI.create(TOKEN_BASE_URL)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

}
