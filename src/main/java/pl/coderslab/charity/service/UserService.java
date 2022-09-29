package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void save(User user) {
        userRepository.save(user);
    }


}
