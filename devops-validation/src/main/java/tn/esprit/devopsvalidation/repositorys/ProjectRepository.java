package tn.esprit.devopsvalidation.repositorys;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.devopsvalidation.entities.Employee;
import tn.esprit.devopsvalidation.entities.Project;

import javax.transaction.Transactional;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
}

