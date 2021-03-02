package edu.unomaha.docusign.dao;

import edu.unomaha.docusign.entities.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DocumentDaoTest {

    @Mock
    private EntityManager em;

    @InjectMocks
    private DocumentDao documentDao;

    @Test
    public void testFindAllDocumentsByBuilder(@Mock TypedQuery<Document> typedQuery, @Mock Document document) {
        typedQuery.setParameter(Mockito.anyString(), Mockito.anyString());
        Mockito.when(em.createNamedQuery(Document.getFindByBuilder(), Document.class)).thenReturn(typedQuery);
        Mockito.when(typedQuery.setParameter(Mockito.anyString(), Mockito.anyString())).thenReturn(typedQuery);
        List<Document> documentList = new ArrayList<>();
        Mockito.when(document.getBuilderName()).thenReturn("Edward Elric");
        documentList.add(document);
        Mockito.when(typedQuery.getResultList()).thenReturn(documentList);

        List<Document> resultList = documentDao.findAllDocumentsByBuilder("Edward Elric");
        Assertions.assertNotNull(resultList);
        Assertions.assertEquals(resultList.size(), 1);
        Assertions.assertEquals(resultList.get(0).getBuilderName(), "Edward Elric");
    }
}
