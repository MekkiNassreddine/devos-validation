package tn.esprit.devopsvalidation.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.devopsvalidation.entities.Departement;

@Repository
public interface DepartementRepository extends CrudRepository<Departement,Long> {

}
