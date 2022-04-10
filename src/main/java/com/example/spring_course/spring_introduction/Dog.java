package com.example.spring_course.spring_introduction;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Primary
public class Dog implements Pet {

    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }

    @PostConstruct
    public void init() {
        System.out.println("Class Dog: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Dog: destroy method");
    }

}