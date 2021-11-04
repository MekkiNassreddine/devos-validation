package tn.esprit.devopsvalidation.services;

import tn.esprit.devopsvalidation.entities.Departement;

public interface IDepartementSErvice {

    public Departement addDepartement(Departement dep);
    public Departement getDepById(long idDep);
}
