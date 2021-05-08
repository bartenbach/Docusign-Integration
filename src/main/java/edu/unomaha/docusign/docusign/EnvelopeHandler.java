package edu.unomaha.docusign.docusign;

import com.docusign.esign.api.EnvelopesApi;
import com.docusign.esign.client.ApiException;
import com.docusign.esign.model.*;
import edu.unomaha.docusign.auth.Docusign;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Base64;

public class EnvelopeHandler {

    public RedirectView sendEnvelope() throws IOException, ApiException {
        //TODO accept real arguments
        String signerName = "Blake Bartenbach";
        String signerEmail = "blakebartenbach@gmail.com";
        EnvelopeDefinition envelope = makeEnvelope(signerEmail, signerName);

        EnvelopesApi envelopesApi = new EnvelopesApi();
        EnvelopeSummary envelopeSummary = envelopesApi.createEnvelope(DocusignEndpoint.getAccountId(), envelope);
        String envelopeId = envelopeSummary.getEnvelopeId();
        System.out.println("envelope ID: " + envelopeId);

        RecipientViewRequest recipientViewRequest = makeRecipientViewRequest(signerEmail, signerName);
        ViewUrl viewUrl = envelopesApi.createRecipientView(DocusignEndpoint.getAccountId(), envelopeId, recipientViewRequest);
        return new RedirectView(viewUrl.getUrl());
    }

    public EnvelopeDefinition makeEnvelope(String signerEmail, String signerName) throws IOException {
        String docPdf = "files/Lien Waiver Final.pdf";
        byte[] buffer = this.getFileFromResourceAsStream(docPdf).readAllBytes();
        EnvelopeDefinition envelopeDefinition = new EnvelopeDefinition();
        envelopeDefinition.setEmailSubject("Please sign this document");
        Document doc1 = new Document();
        String doc1b64 = new String(Base64.getEncoder().encode(buffer));
        doc1.setDocumentBase64(doc1b64);
        doc1.setName("Docusign Team Testing");
        doc1.setFileExtension("pdf");
        doc1.setDocumentId("3");
        envelopeDefinition.setDocuments(Arrays.asList(doc1));

        Signer signer1 = new Signer();
        signer1.setEmail(signerEmail);
        signer1.setName(signerName);
        signer1.clientUserId(DocusignEndpoint.getClientId());
        signer1.recipientId("1");

        SignHere signHere1 = new SignHere();
        signHere1.setAnchorString("/sn1/");
        signHere1.setAnchorUnits("pixels");
        signHere1.setAnchorYOffset("20");
        signHere1.setAnchorXOffset("10");

        Tabs signer1Tabs = new Tabs();
        signer1Tabs.setSignHereTabs(Arrays.asList(signHere1));
        signer1.setTabs(signer1Tabs);

        Recipients recipients = new Recipients();
        recipients.setSigners(Arrays.asList(signer1));
        envelopeDefinition.setRecipients(recipients);

        envelopeDefinition.setStatus("sent");

        return envelopeDefinition;
    }

    private RecipientViewRequest makeRecipientViewRequest(String signerEmail, String signerName) {
        RecipientViewRequest viewRequest = new RecipientViewRequest();
        viewRequest.setReturnUrl("/" + "?state=123");
        viewRequest.setAuthenticationMethod("none");
        viewRequest.setEmail(signerEmail);
        viewRequest.setUserName(signerName);
        viewRequest.setClientUserId(DocusignEndpoint.getClientId());
        viewRequest.setPingFrequency("600"); // seconds
        return viewRequest;
    }

    private InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }


}
