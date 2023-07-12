package com.teachmeskills.springbooteshop.dto.converters;

import com.teachmeskills.springbooteshop.dto.CategoryDto;
import com.teachmeskills.springbooteshop.dto.ProductDto;
import com.teachmeskills.springbooteshop.entities.Category;
import java.util.List;
import java.util.Optional;

import com.teachmeskills.springbooteshop.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CategoryConverter {
    private final ProductConverter productConverter;
    private final ProductMapper productMapper;

    public CategoryDto toDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setImageName(category.getImageName());
        List<ProductDto> productDtos = category.getProductList().stream()
                        .map(productConverter::toDto)
                                .toList();
         categoryDto.setProducts(productDtos);
        return categoryDto;

//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(category.getId());
//        categoryDto.setProducts(category.getProductList().stream()
//                                        .map(productConverter::toDto)
//                                        .collect(Collectors.toList()));

        /*return Optional.ofNullable(category)
                       .map(c -> CategoryDto.builder()
                                            .id(c.getId())
                                            .name(c.getName())
                                            .imageName(c.getImageName())
                                            .products(Optional.ofNullable(c.getProductList())
                                                              .map(products -> products.stream()
                                                                                       .map(productConverter::toDto)
                                                                                       .toList()
                                                              ).orElse(List.of())
                                            )
                                            .build())
                       .orElse(null);*/
    }

    public Category fromDto(CategoryDto categoryDto) {
        return Optional.ofNullable(categoryDto).map(cd -> Category.builder()
                                                                  .name(categoryDto.getName())
                                                                  .imageName("/image.jpeg")
                                                                  .build())
                       .orElse(null);
    }
}
