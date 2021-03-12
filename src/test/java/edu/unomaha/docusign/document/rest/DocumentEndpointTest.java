package edu.unomaha.docusign.rest;

import edu.unomaha.docusign.document.ejb.DocumentServiceImpl;
import edu.unomaha.docusign.document.entities.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DocumentEndpointTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    DocumentServiceImpl documentServiceImpl;

    @InjectMocks
    DocumentEndpoint documentEndpoint;

    private static final String BUILDER_NAME = "Alphonse Elric";

    @Test
    public void testGetDocumentsByBuilder(@Mock Document document) {
        Mockito.when(document.getBuilderName()).thenReturn(BUILDER_NAME);
        List<Document> documentList = new ArrayList<>();
        documentList.add(document);

        Mockito.when(documentServiceImpl.getDocumentsByBuilder(BUILDER_NAME)).thenReturn(documentList);

        List<Document> documents = documentEndpoint.byBuilder(BUILDER_NAME);

        Assertions.assertNotNull(documents);
        Assertions.assertEquals(documents.size(), 1);
        Assertions.assertEquals(documentList.get(0).getBuilderName(), BUILDER_NAME);
    }
}
