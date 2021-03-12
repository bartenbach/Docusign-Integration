package edu.unomaha.docusign.dao;

import edu.unomaha.docusign.entities.Document;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DocumentDao {

    @PersistenceContext(name = "DocumentPersistenceUnit")
    private EntityManager em;

    public List<Document> findAllDocumentsByBuilder(String builderName) {
        return this.em.createNamedQuery(Document.getFindByBuilder(), Document.class)
                .setParameter("builder_name", builderName)
                .getResultList();
    }

    public List<Document> findAllDocuments() {
        return this.em.createNamedQuery(Document.getFindAllDocuments(), Document.class)
                .getResultList();
    }

    public void persistDocument(Document document) {
        this.em.persist(document);
    }

}
