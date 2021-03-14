package edu.unomaha.docusign.document.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "documents")
@NamedQueries({
        @NamedQuery(name = "Document.findAllByBuilder",
                query = "SELECT b FROM Document b WHERE b.builder_name = :builder_name"),
        @NamedQuery(name = "Document.findAll",
                query = "SELECT b FROM Document b")
})
public class Document {

    private static final String FIND_BY_BUILDER = "Document.findAllByBuilder";
    private static final String FIND_ALL_DOCUMENTS = "Document.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "builder_name", length = 255, nullable = false, unique = false)
    private String builder_name;

    @Lob
    @Column(name = "document", length = 10000, nullable = false, unique = false)
    private byte[] document;

    @Column(name = "filename", length = 255, nullable = false, unique = false)
    private String filename;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified")
    private Date lastModified;

    public static String getFindAllDocuments() {
        return FIND_ALL_DOCUMENTS;
    }

    public static String getFindByBuilder() {
        return FIND_BY_BUILDER;
    }

    public byte[] getDocument() {
        return this.document;
    }

    public String getBuilderName() {
        return this.builder_name;
    }

}
