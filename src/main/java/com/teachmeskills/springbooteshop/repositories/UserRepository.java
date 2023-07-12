package com.teachmeskills.springbooteshop.repositories;

import com.teachmeskills.springbooteshop.entities.User;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(int id);

    List<User> findAll();

    Optional<User> findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

}
