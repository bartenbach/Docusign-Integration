package edu.unomaha.docusign.document.ejb;

import edu.unomaha.docusign.document.dao.DocumentDao;
import edu.unomaha.docusign.document.entities.Document;
import edu.unomaha.docusign.document.interfaces.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDao documentDao;

    @Override
    public List<Document> getDocumentsByBuilder(String builderName) {
        return documentDao.findAllDocumentsByBuilder(builderName);
    }

    @Override
    public void addNewDocument(Document document) {
        documentDao.persistDocument(document);
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentDao.findAllDocuments();
    }

}
