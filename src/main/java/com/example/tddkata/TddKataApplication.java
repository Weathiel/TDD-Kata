package com.example.tddkata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TddKataApplication {

    public static void main(String[] args) {
        SpringApplication.run(TddKataApplication.class, args);
    }

}
