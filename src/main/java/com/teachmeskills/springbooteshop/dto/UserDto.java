package com.teachmeskills.springbooteshop.dto;

import com.teachmeskills.springbooteshop.entities.Order;
import com.teachmeskills.springbooteshop.entities.Role;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Builder
@Getter
@EqualsAndHashCode
public class UserDto {
    private String name;
    private String surname;
    @Size(min = 6, max = 30, message = "Password must be between 6 and 30 characters")
    @Pattern(regexp = "\\S+", message = "Spaces are not allowed")
    @NotEmpty(message = "Password must not be empty")
    private String password;
    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be valid")
    private String email;
    private LocalDate birthday;
    private BigDecimal balance;
    private List<Order> orders;

    private RoleDto roleDto;
}
