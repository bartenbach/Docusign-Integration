package edu.unomaha.docusign.project.interfaces;

import edu.unomaha.docusign.project.entities.Project;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {

    List<Project> getProjectsByUser(long userId);
    void persistProject(Project project);
    ResponseEntity deleteProject(long projectId);
    void addProject(Project project);
}
