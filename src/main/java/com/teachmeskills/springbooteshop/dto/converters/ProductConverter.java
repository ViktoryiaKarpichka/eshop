package com.teachmeskills.springbooteshop.dto.converters;

import com.teachmeskills.springbooteshop.dto.ProductDto;
import com.teachmeskills.springbooteshop.entities.Product;
import com.teachmeskills.springbooteshop.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductConverter {
    private final CategoryRepository categoryRepository;

    public ProductDto toDto(Product product){
        return ProductDto.builder()
                         .id(product.getId())
                         .imageName(product.getImageName())
                         .name(product.getName())
                         .description(product.getDescription())
                         .price(product.getPrice())
                         .categoryId(product.getCategory().getId())
                         .build();
    }

    public Product fromDto(ProductDto productDto){
        return Product.builder()
                      .name(productDto.getName())
                      .imageName("/images.jpeg")
                      .description(productDto.getDescription())
                      .price(productDto.getPrice())
                      .category(categoryRepository.findById(productDto.getCategoryId()).orElse(null))
                      .build();
    }
}
