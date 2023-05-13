package com.teachmeskills.springbooteshop.repositories;

import com.teachmeskills.springbooteshop.entities.User;
import java.util.List;

public interface UserRepository {

    User findById(int id);

    List<User> getUser();

    User findByEmailAndPassword(String email, String password);

}
