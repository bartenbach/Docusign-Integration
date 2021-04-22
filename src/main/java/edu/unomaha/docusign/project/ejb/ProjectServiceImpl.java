package edu.unomaha.docusign.project.ejb;

import edu.unomaha.docusign.project.dao.ProjectDao;
import edu.unomaha.docusign.project.entities.Project;
import edu.unomaha.docusign.project.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> getProjectsByUser(long userId) {
        return projectDao.findAllProjectsByUser(userId);
    }

    @Override
    public void persistProject(Project project) {
        projectDao.persistProject(project);
    }

    @Override
    public ResponseEntity deleteProject(long projectId) {
        // TODO
        return null;
    }

    @Override
    public void addProject(Project project) {
        System.out.println("reached serviceimpl");
    }

}
