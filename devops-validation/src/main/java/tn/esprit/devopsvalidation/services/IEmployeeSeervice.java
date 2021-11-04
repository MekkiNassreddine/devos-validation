package tn.esprit.devopsvalidation.services;

import tn.esprit.devopsvalidation.entities.Employee;
import tn.esprit.devopsvalidation.entities.Project;

import java.util.List;

public interface IEmployeeSeervice {
    public Employee addEmploye(Employee employe);
    public void affecterEmployeADepartement(long employeId, long depId);
    public void desafectEmployeFromDepartement(long employeId, long depId);
    public void affectEmployeToProject(long projetId, long employeId);
    public String getEmployePrenomById(long employeId);
    public long getNombreEmployeJPQL();
    public List<String> getAllEmployeNamesJPQL();
    public List<Employee> getEmployeByDept(long idDep);
    public List<Employee> getAllEmployee();
}
