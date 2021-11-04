package tn.esprit.devopsvalidation.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepartement")
    private long idDepartement;

    @Column(name="name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="departement")
    private List<Project> lstProject;

    @JsonIgnore
    @OneToMany(mappedBy="departement")
    private List<Employee> lstEmployees;

    public long getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(long idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getLstProject() {
        return lstProject;
    }

    public void setLstProject(List<Project> lstProject) {
        this.lstProject = lstProject;
    }

    public List<Employee> getLstEmployees() {
        return lstEmployees;
    }

    public void setLstEmployees(List<Employee> lstEmployees) {
        this.lstEmployees = lstEmployees;
    }
}
