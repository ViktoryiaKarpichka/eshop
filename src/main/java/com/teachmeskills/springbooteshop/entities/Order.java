package com.teachmeskills.springbooteshop.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Order  extends BaseEntity implements Serializable {

    private int price;
    private LocalDate date;
    private int userId;
    private List<Product> products;
}
