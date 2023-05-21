package com.teachmeskills.springbooteshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.teachmeskills.springbooteshop.repositories")
@SpringBootApplication
public class SpringBootEshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEshopApplication.class, args);
    }

}
