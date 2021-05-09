package edu.unomaha.docusign.auth;

import com.docusign.esign.model.EnvelopeDefinition;
import edu.unomaha.docusign.docusign.DocusignEndpoint;
import edu.unomaha.docusign.docusign.EnvelopeHandler;
import edu.unomaha.docusign.docusign.CreateEnvelopeResponse;
import edu.unomaha.docusign.docusign.GetEnvelopeResponse;

import java.io.IOException;

public class Docusign extends ApiBinding {

    private String accessToken;

    public Docusign(String accessToken) {
        super(accessToken);
        this.accessToken = accessToken;
    }

    public GetEnvelopeResponse getEnvelopes() {
        return restTemplate.getForObject(DocusignEndpoint.getBasePath() + "/envelopes?from_date=2020-01-01", GetEnvelopeResponse.class);
    }

    public CreateEnvelopeResponse sendEnvelope() throws IOException {
        EnvelopeHandler envelopeHandler = new EnvelopeHandler();
        // TODO these shouldn't be hardcoded
        EnvelopeDefinition envelope = envelopeHandler.makeEnvelope("blakebartenbach@gmail.com", "Blake Bartenbach");
        return restTemplate.postForObject(DocusignEndpoint.getBasePath() + "/envelopes", envelope, CreateEnvelopeResponse.class);
    }

}
