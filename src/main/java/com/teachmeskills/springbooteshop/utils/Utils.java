package com.teachmeskills.springbooteshop.utils;

import com.teachmeskills.springbooteshop.entities.User;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {

    public static final String ADMIN_LOGIN = "admin@mail.ru";
    public static final String ADMIN_PASSWORD = "admin1";
    public static final List<User> USERS = List.of(new User(ADMIN_LOGIN, ADMIN_PASSWORD),
                                                   new User("viki@gmail.com", "1234567"));
}
