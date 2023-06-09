package com.teachmeskills.springbooteshop.services.impl;

import static com.teachmeskills.springbooteshop.utils.Constant.PRODUCT_PAGE;

import com.teachmeskills.springbooteshop.entities.Product;
import com.teachmeskills.springbooteshop.repositories.ProductRepository;
import com.teachmeskills.springbooteshop.services.ProductService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        return productRepository.findAllByCategory_Id(categoryId);
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
}
