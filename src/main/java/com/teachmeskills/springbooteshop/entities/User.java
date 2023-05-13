package com.teachmeskills.springbooteshop.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class User implements Serializable {

    private Long id;
    private String name;
    private String surname;
    @Size(min = 6, max = 30, message = "Password must be between 6 and 30 characters")
    @Pattern(regexp = "\\S+", message = "Spaces are not allowed")
    @NotEmpty(message = "Password must not be empty")
    private String password;
    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be valid")
    private String email;
    private String birthday;
    private int balance;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
