package tn.esprit.devopsvalidation.serveces;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.devopsvalidation.entities.Employee;
import tn.esprit.devopsvalidation.repositorys.EmployeeRepository;
import tn.esprit.devopsvalidation.services.EmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class EmployeeServiceTest {


    EmployeeService employeeService = new EmployeeService();

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() throws Exception {
        Employee employee = new Employee("mekki","Nassreddine","nassreddine@rit.tn");
        assertEquals("",true,employeeService.emailEmployee(employee.getEmail()));
    }

    @Test
    public void testEmployee() {
        assertEquals("",10,employeeService.calcul(5,5));
    }

}
