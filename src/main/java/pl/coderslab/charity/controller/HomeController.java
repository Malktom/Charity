package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private DonationService donationService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> list = (List<Institution>) institutionService.getInstitutionsList();
        model.addAttribute("institutions", list);
        Integer bagDonationSum = donationService.bagDonationSum();
        model.addAttribute("bagDonationSum", bagDonationSum);
        Integer donationSum = donationService.donationSum();
        model.addAttribute("donations", donationSum);
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.save(user);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String afterLogin() {
        return "index";
    }


}
