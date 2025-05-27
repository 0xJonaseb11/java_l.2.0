package com.binarysupermarket.sebera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.binarysupermarket.sebera.repository")
@EntityScan("com.binarysupermarket.sebera.model")
public class BinarySupermarketApplication {
    public static void main(String[] args) {
        SpringApplication.run(BinarySupermarketApplication.class, args);
    }
}