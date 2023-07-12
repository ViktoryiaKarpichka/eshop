package com.teachmeskills.springbooteshop.services.impl;

import static com.teachmeskills.springbooteshop.utils.Constant.PRODUCT_PAGE;

import com.teachmeskills.springbooteshop.dto.ProductDto;
import com.teachmeskills.springbooteshop.dto.converters.ProductConverter;
import com.teachmeskills.springbooteshop.entities.Product;
import com.teachmeskills.springbooteshop.repositories.CategoryRepository;
import com.teachmeskills.springbooteshop.repositories.ProductRepository;
import com.teachmeskills.springbooteshop.services.ProductService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    private final ProductConverter productConverter;

    @Override
    public List<ProductDto> getProductsByCategoryId(int categoryId) {
        return productRepository.findAllByCategoryId(categoryId).stream().map(productConverter::toDto).toList();
    }

    @Override
    public ModelAndView getProductData(int id) {
        ModelMap modelMap = new ModelMap();
        Product product = productRepository.findById(id);
        if (Optional.ofNullable(product).isPresent()) {
            modelMap.addAttribute("product", product);
        }
        return new ModelAndView(PRODUCT_PAGE, modelMap);
    }
   /* public ModelAndView getProductDataTwo(int id) {
        ModelMap model = new ModelMap();
        productRepository.findById(id).ifPresent(p -> {
            model.addAttribute("product", p);
        });
        return new ModelAndView(PRODUCT_PAGE, model);
    }*/
}
