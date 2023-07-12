package com.teachmeskills.springbooteshop.services.impl;

import static com.teachmeskills.springbooteshop.utils.Constant.CATEGORY_PAGE;

import com.teachmeskills.springbooteshop.dto.CategoryDto;
import com.teachmeskills.springbooteshop.dto.ProductDto;
import com.teachmeskills.springbooteshop.dto.converters.CategoryConverter;
import com.teachmeskills.springbooteshop.dto.converters.ProductConverter;
import com.teachmeskills.springbooteshop.entities.Category;
import com.teachmeskills.springbooteshop.entities.Product;
import com.teachmeskills.springbooteshop.mapper.CategoryMapper;
import com.teachmeskills.springbooteshop.repositories.CategoryRepository;
import com.teachmeskills.springbooteshop.services.CategoryService;
import com.teachmeskills.springbooteshop.services.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductService productService;
    private final CategoryConverter categoryConverter;
    private final ProductConverter productConverter;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getCategories() {
        return categoryRepository.findAll().stream().map(categoryConverter::toDto).toList();
    }

    @Override
    public ModelAndView getCategoryData(int id) {
        ModelMap model = new ModelMap();
        CategoryDto category = categoryConverter.toDto(categoryRepository.findCategoryById(id));
        if (category != null) {
            List<ProductDto> products = productService.getProductsByCategoryId(category.getId());
            category.setProducts(products);
            model.addAttribute("category", category);
        }
        return new ModelAndView(CATEGORY_PAGE,model);
    }
}
