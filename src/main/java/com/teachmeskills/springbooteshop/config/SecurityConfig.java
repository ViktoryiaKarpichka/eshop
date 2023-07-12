package com.teachmeskills.springbooteshop.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
 //               .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(auth ->
                                auth
 //                                       .requestMatchers("/admin/**").hasRole("ADMIN")
                                        .requestMatchers("/login", "/home").permitAll()
//                                        .requestMatchers("/home", "/category").permitAll()
                                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                        .anyRequest().hasAnyRole("USER", "ADMIN")
//                                        .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin

                                .loginPage("/login")
                                .defaultSuccessUrl("/home", true)
                ).logout(logout ->
                        logout
                                .logoutUrl("/logout")
      //                          .logoutSuccessUrl("/auth/login?logout")
      //                          .deleteCookies("JSESSIONID")
                                .permitAll())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
       // return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }
}
