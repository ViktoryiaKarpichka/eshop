package com.teachmeskills.springbooteshop.repositories;

import com.teachmeskills.springbooteshop.entities.Category;
import java.util.List;

public interface CategoryRepository {

    List<Category> getCategories();

    Category getCategoryById(int id);

}
