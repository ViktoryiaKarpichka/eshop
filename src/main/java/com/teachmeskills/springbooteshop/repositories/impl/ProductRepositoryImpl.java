package com.teachmeskills.springbooteshop.repositories.impl;


import com.teachmeskills.springbooteshop.entities.Category;
import com.teachmeskills.springbooteshop.entities.Product;
import com.teachmeskills.springbooteshop.repositories.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getProducts() {
        return jdbcTemplate.query("select * from products", (rs, rowNum) ->
                Product.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .imageName(rs.getString("image_name"))
                        .description(rs.getString("description"))
                        .price(rs.getBigDecimal("price"))
                        .categoryId(rs.getInt("category_id"))
                        .build());
    }

    @Override
    public Product getProductById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = ?", (rs, rowNum) -> Product.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .imageName(rs.getString("image_name"))
                .description(rs.getString("description"))
                .price(rs.getBigDecimal("price"))
                .categoryId(rs.getInt("category_id"))
                .build(), id);
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        return jdbcTemplate.query("SELECT * FROM products WHERE category_id= ?", (rs, rowNum) -> Product.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .imageName(rs.getString("image_name"))
                .description(rs.getString("description"))
                .price(rs.getBigDecimal("price"))
                .categoryId(rs.getInt("category_id"))
                .build(), categoryId);
    }
}
