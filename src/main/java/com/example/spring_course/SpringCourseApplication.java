package com.example.spring_course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:myApp.properties")
public class SpringCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCourseApplication.class, args);
    }

}