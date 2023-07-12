package com.teachmeskills.springbooteshop.dto;

import jakarta.validation.constraints.Min;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CategoryDto {
    @Min(value = 1, message = "Min values is 1")
    private int id;
    private String name;
    private List<ProductDto> products;
    private String imageName;
}
