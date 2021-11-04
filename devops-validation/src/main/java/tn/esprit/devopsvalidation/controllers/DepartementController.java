package tn.esprit.devopsvalidation.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.devopsvalidation.entities.Departement;
import tn.esprit.devopsvalidation.services.DepartementService;

@RestController
public class DepartementController {
     @Autowired
    DepartementService departementService;

    @PostMapping("/add-departement")
    @ResponseBody
    public Departement saveDepartemet(@RequestBody Departement departement) {
        departementService.addDepartement(departement);
        return departement;
    }
}
