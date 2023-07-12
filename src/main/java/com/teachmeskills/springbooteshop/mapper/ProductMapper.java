package com.teachmeskills.springbooteshop.mapper;

import com.teachmeskills.springbooteshop.dto.ProductDto;
import com.teachmeskills.springbooteshop.entities.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    @Mapping(source = "product.category.id", target = "categoryId")
    ProductDto convertToProductDto(Product product);

    @InheritInverseConfiguration
    @Mapping(target = "category", expression = "java(new Category(dto.getCategoryId()))")
    Product convertToProduct(ProductDto productDto);

    List<ProductDto> convertToProductDto(List<Product> products);

}
