package com.teachmeskills.springbooteshop.repositories.impl;

import static com.teachmeskills.springbooteshop.utils.Utils.USERS;

import com.teachmeskills.springbooteshop.entities.User;
import com.teachmeskills.springbooteshop.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public List<User> getUser() {
        return new ArrayList<>(USERS);
    }

    @Override
    public User findById(int id) {
        return USERS.stream().filter(user -> user.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return USERS.stream()
                    .filter(user -> user.getEmail().equalsIgnoreCase(email))
                    .filter(user -> user.getPassword().equalsIgnoreCase(password))
                    .findAny()
                    .orElse(null);
    }

}
