package tn.esprit.devopsvalidation.repositorys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.devopsvalidation.entities.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    @Query("SELECT employe.firstName From Employee employe")
    List<String> getNameAllEmploye();

    @Query("SELECT employe From Employee employe")
    List<Employee> getAllEmploye();

}
