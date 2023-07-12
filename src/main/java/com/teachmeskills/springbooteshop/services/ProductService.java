package com.teachmeskills.springbooteshop.services;

import com.teachmeskills.springbooteshop.dto.ProductDto;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

public interface ProductService {

    List<ProductDto> getProductsByCategoryId(int categoryId);

    ModelAndView getProductData(int id);
}
