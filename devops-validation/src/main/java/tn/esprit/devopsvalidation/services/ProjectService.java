package tn.esprit.devopsvalidation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.devopsvalidation.entities.Project;
import tn.esprit.devopsvalidation.repositorys.ProjectRepository;


import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;

@Service
public class ProjectService implements IProjectService{

    @Autowired
    ProjectRepository projectRepository;

    //private static Logger logger = LogManager.getLogger();
    private static final Logger logger = Logger.getLogger(String.valueOf(ProjectService.class)); ;

    @Override
    public Project addProject(Project project) {
        logger.info("this is Projevct id info " + project.getIdProject() );
        logger.debug("this is Projevct description debug " + project.getDescription() );

        logger.info("this is Projevct " + project.getIdProject() );
        logger.debug("this is Projevct " + project.getDescription() );

        logger.debug("console +++++++++:  This is a debug message");
        logger.info("   file :  This is an info message");


        projectRepository.save(project);
        return project;
    }

    @Override
    public int deleteProject(long id) {
       // logger.info("in delete Project " +id );
        if(projectRepository.existsById(id)){
            //logger.info("perject to delete existe " +id );
            Project projectToDelete = projectRepository.findById(id).get();
            projectRepository.delete(projectToDelete);
            return 1;
        }
         else {
            return 0;
        }

    }
}
