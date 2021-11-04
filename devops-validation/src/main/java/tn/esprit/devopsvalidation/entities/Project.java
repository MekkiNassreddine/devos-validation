package tn.esprit.devopsvalidation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProject")
    private long idProject;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Employee> lstEmployes;

    @ManyToOne(cascade=CascadeType.ALL)
    private Departement departement;

    public long getIdProject() {
        return idProject;
    }

    public void setIdProject(long idProject) {
        this.idProject = idProject;
    }

    public Project(String name, String description, List<Employee> lstEmployes, Departement departement) {
        this.name = name;
        this.description = description;
        this.lstEmployes = lstEmployes;
        this.departement = departement;
    }

    public Project() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getLstEmployes() {
        return lstEmployes;
    }

    public void setLstEmployes(List<Employee> lstEmployes) {
        this.lstEmployes = lstEmployes;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
