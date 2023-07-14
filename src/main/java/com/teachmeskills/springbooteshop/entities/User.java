package com.teachmeskills.springbooteshop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "users")
public class User extends BaseEntity implements Serializable {

    private String name;
    private String surname;
    private String password;
    private String email;
    private LocalDate birthday;
    private BigDecimal balance;
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
  /*  @OneToMany(mappedBy = "user")
    private List<Cart1> carts;*/

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
