package edu.unomaha.docusign.project.interfaces;

import edu.unomaha.docusign.project.entities.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getProjectsByUser(long userId);
    void persistProject(Project project);

}
