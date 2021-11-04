package tn.esprit.devopsvalidation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devopsvalidation.entities.Project;
import tn.esprit.devopsvalidation.services.ProjectService;

@RestController
public class ProjectController {

     @Autowired
    ProjectService projectService;

    @PostMapping("/add-project")
    @ResponseBody
    public Project addProject(@RequestBody Project project) {

         projectService.addProject(project);
        return project;
    }

    @DeleteMapping("/delete_project/{id}")
    public int deleteProject(@PathVariable("id") long id){
        return projectService.deleteProject(id);
    }

}
