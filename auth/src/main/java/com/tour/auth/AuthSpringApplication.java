package com.tour.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableJpaAuditing
@EnableEurekaClient
@SpringBootApplication
public class AuthSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthSpringApplication.class, args);
    }
}
