package tn.esprit.devopsvalidation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devopsvalidation.entities.Employee;
import tn.esprit.devopsvalidation.services.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add-employee")
    @ResponseBody
    public Employee saveEmployee(@RequestBody Employee employee) {
        employeeService.addEmploye(employee);
        return employee;
    }

    @GetMapping("/get-dep/{name}")
    @ResponseBody
    public List<String> getDepById(@PathVariable("name") String firstName) {
        return employeeService.getAllEmployeNamesJPQL();
    }

    @GetMapping("/get-all-employee")
    @ResponseBody
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PutMapping("/affect-employe-to-dep/{dep-id}/{emp-id}")
    public void affectEmployeToDepartement(@PathVariable("dep-id")long depId,@PathVariable("emp-id")long employeId){
        employeeService.affecterEmployeADepartement(employeId, depId);
    }

    @PutMapping("/deaffect-employe-to-dep/{dep-id}/{emp-id}")
    public void deaffectEmployeToDepartement(@PathVariable("dep-id")long depId,@PathVariable("emp-id")long employeId){
        employeeService.desafectEmployeFromDepartement(employeId, depId);
    }

    @PutMapping("/affect-employe-to-project/{pro-id}/{emp-id}")
    public void affectEmployeToProject(@PathVariable("pro-id")long proId,@PathVariable("emp-id")long employeId){
        employeeService.affectEmployeToProject(proId,employeId);
    }
}
