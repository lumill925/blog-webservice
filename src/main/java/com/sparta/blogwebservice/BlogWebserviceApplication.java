package com.sparta.blogwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BlogWebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogWebserviceApplication.class, args);
    }

}
