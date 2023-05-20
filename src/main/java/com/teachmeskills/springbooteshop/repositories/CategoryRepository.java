package com.teachmeskills.springbooteshop.repositories;

import com.teachmeskills.springbooteshop.entities.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    List<Category> findAll();

    Category findCategoryById(int id);

}
