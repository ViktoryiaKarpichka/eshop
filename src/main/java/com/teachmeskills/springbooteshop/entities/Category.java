package com.teachmeskills.springbooteshop.entities;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder
public class Category extends BaseEntity implements Serializable {

    private String name;
    private String imageName;
    private List<Product> productList;

}

