package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    public Iterable<Institution> getInstitutionsList (){
        return institutionRepository.findAll();     // paginacja?
    }



}
