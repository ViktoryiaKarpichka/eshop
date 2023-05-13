package com.teachmeskills.springbooteshop.repositories.impl;


import com.teachmeskills.springbooteshop.entities.Product;
import com.teachmeskills.springbooteshop.repositories.ProductRepository;
import com.teachmeskills.springbooteshop.utils.ProductHelper;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    public List<Product> getProducts() {
        return ProductHelper.products;
    }

    @Override
    public Product getProductById(int id) {
        return ProductHelper.products.stream()
                                     .filter(product -> product.getId() == id)
                                     .findFirst()
                                     .orElse(null);
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        return ProductHelper.products.stream()
                                     .filter(product -> product.getCategoryId() == categoryId)
                                     .toList();
    }

}
