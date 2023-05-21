package com.teachmeskills.springbooteshop.repositories;


import com.teachmeskills.springbooteshop.entities.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    //List<Product> getProducts();
    List<Product> findAll();

    Product findById(int id);

    List<Product> findAllByCategory_Id(int id);
}
