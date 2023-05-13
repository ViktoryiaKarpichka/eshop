package com.teachmeskills.springbooteshop.services;

import com.teachmeskills.springbooteshop.entities.Product;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

public interface ProductService {

    List<Product> getProductsByCategoryId(int categoryId);

    public ModelAndView getProductData(int id);
}
