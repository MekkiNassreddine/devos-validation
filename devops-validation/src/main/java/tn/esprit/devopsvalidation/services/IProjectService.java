package tn.esprit.devopsvalidation.services;

import tn.esprit.devopsvalidation.entities.Project;

public interface IProjectService {
    public Project addProject(Project project);
    public int deleteProject(long id);
}
