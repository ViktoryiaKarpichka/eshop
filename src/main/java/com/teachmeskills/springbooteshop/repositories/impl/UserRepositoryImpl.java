package com.teachmeskills.springbooteshop.repositories.impl;

import com.teachmeskills.springbooteshop.entities.Product;
import com.teachmeskills.springbooteshop.entities.User;
import com.teachmeskills.springbooteshop.repositories.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getUser() {
        return jdbcTemplate.query("select * from users", (rs, rowNum) ->
                User.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .password(rs.getString("password"))
                        .email(rs.getString("email"))
                        .birthday(rs.getDate("birthday").toLocalDate())
                        .balance(rs.getBigDecimal("balance"))
                        .build());
    }

    @Override
    public User findById(int id) {
        return jdbcTemplate.queryForObject("select * from users WHERE id = ?", (rs, rowNum) ->
                User.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .password(rs.getString("password"))
                        .email(rs.getString("email"))
                        .birthday(rs.getDate("birthday").toLocalDate())
                        .balance(rs.getBigDecimal("balance"))
                        .build(),id);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return jdbcTemplate.queryForObject("select * from users WHERE email = ? and  password = ?", (rs, rowNum) ->
                User.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .password(rs.getString("password"))
                        .email(rs.getString("email"))
                        .birthday(rs.getDate("birthday").toLocalDate())
                        .balance(rs.getBigDecimal("balance"))
                        .build(),email,password);
    }

}
