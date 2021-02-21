package edu.unomaha.docusign.interfaces;

import edu.unomaha.docusign.entities.Document;

import javax.print.Doc;
import java.util.List;

public interface DocumentService {

    public List<Document> getDocumentsByBuilder(String builderName);
    public List<Document> getAllDocuments();
    public void addNewDocument(Document document);
}
