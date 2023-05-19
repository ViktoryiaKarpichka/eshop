package com.teachmeskills.springbooteshop.repositories.impl;

import com.teachmeskills.springbooteshop.entities.Category;
import com.teachmeskills.springbooteshop.repositories.CategoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class JdbcCategoryRepository implements CategoryRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getCategories() {
        return jdbcTemplate.query("select * from categories", (rs, rowNum) ->
                Category.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .imageName(rs.getString("imagename"))
                        .build());
            }

    @Override
    public Category getCategoryById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM categories WHERE id = ?", (rs, rowNum) -> Category.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .imageName(rs.getString("imagename"))
                .build(), id);
    }
}
