package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repository.CategoryRepository;

public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getCategoriesList (){
        return categoryRepository.findAll();     // paginacja?
    }



}
