package edu.unomaha.docusign.project.dao;

import edu.unomaha.docusign.project.entities.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProjectDao {

    @PersistenceContext(name = "ProjectPersistenceUnit")
    private EntityManager em;

    public List<Project> findAllProjectsByUser(long userId) {
        return this.em.createNamedQuery(Project.getFindAllByUser(), Project.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public void persistProject(Project project) {
        this.em.persist(project);
    }

}
