package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    public Iterable<Donation> getDonationsList (){
        return donationRepository.findAll();     // paginacja?
    }



}
