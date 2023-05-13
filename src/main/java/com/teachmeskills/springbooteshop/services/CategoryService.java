package com.teachmeskills.springbooteshop.services;

import com.teachmeskills.springbooteshop.entities.Category;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

public interface CategoryService {

    List<Category> getCategories();

    ModelAndView getCategoryData(int id);
}
