package com.teachmeskills.springbooteshop.repositories;


import com.teachmeskills.springbooteshop.entities.Product;
import java.util.List;

public interface ProductRepository {

    List<Product> getProducts();

    Product getProductById(int id);

    List<Product> getProductsByCategoryId(int categoryId);
}
