package edu.unomaha.docusign.interfaces;

import edu.unomaha.docusign.entities.Document;

import java.util.List;

public interface DocumentService {

    List<Document> getDocumentsByBuilder(String builderName);
    List<Document> getAllDocuments();
    void addNewDocument(Document document);

}
