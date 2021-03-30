package edu.unomaha.docusign.document.interfaces;

import edu.unomaha.docusign.document.entities.Document;

import java.util.List;

public interface DocumentService {

    List<Document> getDocumentsByBuilder(String builderName);
    List<Document> getAllDocuments();
    void addNewDocument(Document document);

}
