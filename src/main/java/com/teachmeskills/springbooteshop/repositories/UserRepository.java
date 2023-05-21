package com.teachmeskills.springbooteshop.repositories;

import com.teachmeskills.springbooteshop.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(int id);

    List<User> findAll();

    User findByEmailAndPassword(String email, String password);

}
