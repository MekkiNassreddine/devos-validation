package tn.esprit.devopsvalidation.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmployee")
    private long idEmployee;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastNmae")
    private String lastNmae;

    @Column(name="email")
    private String email;

    @Column(name="isactif")
    private boolean isactif;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal (TemporalType.DATE)
    private Date dateDebut;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal (TemporalType.DATE)
    private Date dateFin;

    @JsonIgnore
    @ManyToMany(mappedBy="lstEmployes",fetch=FetchType.EAGER)
    private List<Project> lstProject;

    @ManyToOne(cascade=CascadeType.ALL)
    private Departement departement;

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNmae() {
        return lastNmae;
    }

    public void setLastNmae(String lastNmae) {
        this.lastNmae = lastNmae;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsactif() {
        return isactif;
    }

    public void setIsactif(boolean isactif) {
        this.isactif = isactif;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Project> getLstProject() {
        return lstProject;
    }

    public void setLstProject(List<Project> lstProject) {
        this.lstProject = lstProject;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Employee(long idEmployee, String firstName, String lastNmae, String email, boolean isactif, Role role, Date dateDebut, Date dateFin) {
        this.idEmployee = idEmployee;
        this.firstName = firstName;
        this.lastNmae = lastNmae;
        this.email = email;
        this.isactif = isactif;
        this.role = role;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Employee() {

    }

    public Employee(String firstName, String lastNmae, String email) {
        this.firstName = firstName;
        this.lastNmae = lastNmae;
        this.email = email;
    }
}
