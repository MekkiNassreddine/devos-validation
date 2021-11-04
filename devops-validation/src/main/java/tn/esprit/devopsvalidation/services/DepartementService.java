package tn.esprit.devopsvalidation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.devopsvalidation.entities.Departement;
import tn.esprit.devopsvalidation.repositorys.DepartementRepository;

@Service
public class DepartementService implements IDepartementSErvice{

    @Autowired
    DepartementRepository departementRepository;

    @Override
    public Departement addDepartement(Departement departement) {
        departementRepository.save(departement);
        return departement;
    }

    @Override
    public Departement getDepById(long idDep) {
        return null;
    }
}
