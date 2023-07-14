package com.teachmeskills.springbooteshop.mapper;

import com.teachmeskills.springbooteshop.dto.CategoryDto;
import com.teachmeskills.springbooteshop.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = ProductMapper.class)
public interface CategoryMapper {
    @Mapping(source = "products", target = "productList")
    Category convertToCategory(CategoryDto categoryDto);
    @Mapping(source = "productList", target = "products")
    CategoryDto convertToCategoryDto(Category category);

}
