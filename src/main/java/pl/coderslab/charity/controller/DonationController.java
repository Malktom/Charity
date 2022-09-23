package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private DonationService donationService;

@GetMapping("/new")
public String newDonation(Model model) {
    List<Category> catList = (List<Category>) categoryService.getCategoriesList();
    model.addAttribute("categories", catList);
    List<Institution> list = (List<Institution>) institutionService.getInstitutionsList();
    model.addAttribute("institutions", list);
    model.addAttribute("donation", new Donation());
    return "form";
}

@PostMapping("/new")
    public String save (Donation donation) {
    donationService.save(donation);
    return "redirect:/";
}

}
