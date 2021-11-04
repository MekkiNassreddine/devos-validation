package tn.esprit.devopsvalidation.serveces;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.devopsvalidation.entities.Employee;
import tn.esprit.devopsvalidation.repositorys.EmployeeRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeJpaTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testEmployeeSave() throws Exception {
        //this.entityManager.persist(new Employee("Tut#1", "Desc#1", "nassreddine@mekki.tn"));
         ;
        Employee employee = employeeRepository.save(
                new Employee("mekki",
                             "Nassreddine",
                             "nassreddine@rit.tn"));
        Assertions.assertThat(Integer.valueOf((int) employee.getIdEmployee())).isGreaterThan(0);
    }

    @Test
    public void deleteEmployee() throws Exception {
        long a = 13;

    }

    @Test
    public void RetriveAllEmployee() throws Exception {

        Employee employee = employeeRepository.save(
                new Employee("mekki",
                        "Nassreddine",
                        "nassreddine@rit.tn"));
        List<Employee> lstEmployees = employeeRepository.getAllEmploye();
        Assertions.assertThat(lstEmployees).hasSize(lstEmployees.size()).contains(employee);
    }
}
