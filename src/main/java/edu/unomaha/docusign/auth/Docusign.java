package edu.unomaha.docusign.auth;

import com.docusign.esign.client.ApiException;
import edu.unomaha.docusign.docusign.DocusignEndpoint;
import edu.unomaha.docusign.docusign.EnvelopeHandler;
import edu.unomaha.docusign.docusign.EnvelopeResponse;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

public class Docusign extends ApiBinding {

    private String accessToken;

    public Docusign(String accessToken) {
        super(accessToken);
        this.accessToken = accessToken;
    }

    public EnvelopeResponse getEnvelopes() {
        return restTemplate.getForObject(DocusignEndpoint.getBasePath() + "/envelopes?from_date=2020-01-01", EnvelopeResponse.class);
    }

    public RedirectView sendEnvelope() throws IOException, ApiException {
        EnvelopeHandler envelopeHandler = new EnvelopeHandler();
        return envelopeHandler.sendEnvelope(accessToken);
    }

}
