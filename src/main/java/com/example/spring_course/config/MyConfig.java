package com.example.spring_course.config;

import com.example.spring_course.spring_introduction.Cat;
import com.example.spring_course.spring_introduction.Person;
import com.example.spring_course.spring_introduction.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:myApp.properties")
public class MyConfig {

    @Bean
    public Pet catBean() {
        return new Cat();
    }

    @Bean
    public Person personBean() {
        return new Person(catBean());
    }

}