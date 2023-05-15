package com.teachmeskills.springbooteshop.services.impl;

import static com.teachmeskills.springbooteshop.utils.Constant.CATEGORY_PAGE;

import com.teachmeskills.springbooteshop.entities.Category;
import com.teachmeskills.springbooteshop.entities.Product;
import com.teachmeskills.springbooteshop.repositories.CategoryRepository;
import com.teachmeskills.springbooteshop.services.CategoryService;
import com.teachmeskills.springbooteshop.services.ProductService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductService productService;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.getCategories();
    }

    @Override
    public ModelAndView getCategoryData(int id) {
        ModelMap model = new ModelMap();
        Category category = categoryRepository.getCategoryById(id);
        if (category != null) {
            List<Product> products = productService.getProductsByCategoryId(category.getId());
            category.setProductList(products);
            model.addAttribute("category", category);
        }
        return new ModelAndView(CATEGORY_PAGE,model);
    }
}
