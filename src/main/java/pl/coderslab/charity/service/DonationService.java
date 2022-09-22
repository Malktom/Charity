package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;
@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    public Iterable<Donation> getDonationsList (){
        return donationRepository.findAll();     // paginacja?
    }

    public Integer donationSum () {
//        return donationRepository.countDonations();
        return donationRepository.sumDonations();
    }



}
