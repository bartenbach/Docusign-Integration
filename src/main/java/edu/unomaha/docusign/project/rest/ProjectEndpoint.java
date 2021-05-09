package edu.unomaha.docusign.project.rest;

import edu.unomaha.docusign.project.ejb.ProjectServiceImpl;
import edu.unomaha.docusign.project.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/")
public class ProjectEndpoint {

    @Autowired
    ProjectServiceImpl service;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public List<Project> byBuilder(@PathVariable long id) {
        return service.getProjectsByUser(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Project> deleteProject(@PathVariable long id) {
        service.deleteProject(id);
        return new ResponseEntity<Project>(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public void addProject(@RequestBody Project project) {
        service.addProject(project);
    }

}
