package tn.esprit.devopsvalidation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.devopsvalidation.entities.Departement;
import tn.esprit.devopsvalidation.entities.Employee;
import tn.esprit.devopsvalidation.entities.Project;
import tn.esprit.devopsvalidation.repositorys.DepartementRepository;
import tn.esprit.devopsvalidation.repositorys.EmployeeRepository;
import tn.esprit.devopsvalidation.repositorys.ProjectRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployeeService implements IEmployeeSeervice{

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartementRepository departementRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Employee addEmploye(Employee employe) {
        if(emailEmployee(employe.getEmail())){
            return  employeeRepository.save(employe);
        }else{
            return null;
        }
    }


    @Override
    public void affecterEmployeADepartement(long employeId, long depId) {
         Departement departement = departementRepository.findById(depId).
                 orElseThrow(()->new EntityNotFoundException("Departement with id " + depId + "was not found"));;
        Employee employee = employeeRepository.findById(employeId)
                .orElseThrow(()->new EntityNotFoundException("Employee with id " + employeId + "was not found"));
        employee.setDepartement(departement);
         employeeRepository.save(employee);
    }

    @Override
    public void desafectEmployeFromDepartement(long employeId, long depId) {

    }



    @Override
    public void affectEmployeToProject(long projectId, long employeId) {
        Employee employee = employeeRepository.findById(employeId)
                .orElseThrow(()->new EntityNotFoundException("Employee with id " + employeId + "was not found"));

        Project project = projectRepository.findById(projectId)
                .orElseThrow(()->new EntityNotFoundException("Project with id " + projectId + "was not found"));

        List<Project> lstProject = employee.getLstProject();
        lstProject.add(project);
        employee.setLstProject(lstProject);
        List<Employee> lstEmployee = project.getLstEmployes();
        lstEmployee.add(employee);
        project.setLstEmployes(lstEmployee);
        employeeRepository.save(employee);
        projectRepository.save(project);
    }

    @Override
    public String getEmployePrenomById(long employeId) {
        return null;
    }

    @Override
    public long getNombreEmployeJPQL() {
        return 0;
    }

    @Override
    public List<String> getAllEmployeNamesJPQL() {
        return employeeRepository.getNameAllEmploye();
    }

    @Override
    public List<Employee> getEmployeByDept(long idDep) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> lstEmployee = employeeRepository.getAllEmploye();
        return  lstEmployee;
    }

    public int calcul(int a,int b){
        return a+b;
    }

    public Boolean emailEmployee(String email){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
