package com.teachmeskills.springbooteshop.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString
public class Product extends BaseEntity implements Serializable {

    private String imageName;
    private String name;
    private String description;
    private BigDecimal price;
    private int categoryId;
}
