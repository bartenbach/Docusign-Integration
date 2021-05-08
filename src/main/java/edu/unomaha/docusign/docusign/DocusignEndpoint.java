package edu.unomaha.docusign.docusign;

import com.docusign.esign.client.ApiException;
import edu.unomaha.docusign.auth.Docusign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/ds")
public class DocusignEndpoint {

    private static final String AUTHENTICATION_SCOPE = "signature";
    private static final String DOCUSIGN_API_ENDPOINT = "https://account-d.docusign.com/oauth";
    private static final String BASE_URI = "https://demo.docusign.net/restapi";
    private static final String REGISTRATION_ID = "docusign";
    private static final String CLIENT_ID = "5f178629-92f1-431f-a323-3b6852e823a0";
    private static final String CLIENT_SECRET = "8f02b844-499f-460f-bda9-f354f5f2ce05";
    private static final String DOCUSIGN_API_PATH = "/2.1/accounts/";
    private static final String ACCOUNT_ID = "55788584-a2f9-4396-8858-69844d1590d5";

    @Autowired
    private Docusign docusign;

    public static String getBaseUri() {
        return BASE_URI;
    }

    public static String getBasePath() {
        return BASE_URI + DOCUSIGN_API_PATH + ACCOUNT_ID;
    }

    public static String getAccountId() {
        return ACCOUNT_ID;
    }

    public static String getClientId() {
        return CLIENT_ID;
    }

    @GetMapping("/envelopes/get")
    public String getEnvelopes() throws IOException {
        EnvelopeResponse envelopeResponse = docusign.getEnvelopes();
        if (envelopeResponse.getResultSetSize() > 0) {
            String envelope = envelopeResponse.getNextUri();
            return "You currently have an envelope:\n\t" + envelopeResponse.getNextUri();

        }
        return "You currently don't have any envelopes.";
    }

    @GetMapping("/envelopes/send")
    public EnvelopeResponse sendEnvelope() throws IOException {
        return docusign.sendEnvelope();
    }

}
