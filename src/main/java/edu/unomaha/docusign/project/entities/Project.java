package edu.unomaha.docusign.project.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "projects")
@NamedQueries({
        @NamedQuery(name = "Project.findAllByUser",
                query = "SELECT b FROM Project b WHERE b.userId = :userId")
})
public class Project {

    private static final String FIND_BY_USER = "Project.findAllByUser";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "project_name", length = 255, nullable = false, unique = false)
    private String projectName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified")
    private Date lastModified;

    public static String getFindAllByUser() {
        return FIND_BY_USER;
    }

    public long getProjectId() {
        return this.projectId;
    }

    public void setProjectId(long id) {
        this.projectId = id;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long id) {
        this.userId = id;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String name) {
        this.projectName = name;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }


}
