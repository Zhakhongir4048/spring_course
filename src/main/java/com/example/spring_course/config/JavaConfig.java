package com.example.spring_course.config;

import com.example.spring_course.spring_introduction.Dog;
import com.example.spring_course.spring_introduction.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.example.spring_course")
public class JavaConfig {

  @Bean("myPet")
  @Scope("singleton")
  public Pet getPet() {
    return new Dog();
  }

}