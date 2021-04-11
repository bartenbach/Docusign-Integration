package edu.unomaha.docusign.project.rest;

import edu.unomaha.docusign.project.ejb.ProjectServiceImpl;
import edu.unomaha.docusign.project.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects/")
public class ProjectEndpoint {

    @Autowired
    ProjectServiceImpl service;

    @RequestMapping("/{id}")
    public List<Project> byBuilder(@PathVariable long id) {
        return service.getProjectsByUser(id);
    }

}
