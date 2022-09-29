package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private DonationService donationService;

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
    public String register() {

        return "register";
    }
}
