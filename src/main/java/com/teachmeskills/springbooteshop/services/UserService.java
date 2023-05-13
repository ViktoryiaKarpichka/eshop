package com.teachmeskills.springbooteshop.services;


import com.teachmeskills.springbooteshop.entities.User;
import com.teachmeskills.springbooteshop.exceptions.AuthorizationException;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

public interface UserService {

    ModelAndView authenticate(User user) throws AuthorizationException;

    List<User> read();
}
