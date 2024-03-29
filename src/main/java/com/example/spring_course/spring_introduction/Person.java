package com.example.spring_course.spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {

    private Pet pet;
    @Value(value = "${person.surname}")
    private String surname;
    @Value(value = "${person.age}")
    private int age;

    @Autowired
    public Person(@Qualifier("catBean") Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }

    /**
     * @Autowired Внедрение через setter
     */
    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    /**
     * Этот getter нужен для @Value
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Этот setter нужен для @Value
     */
    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    /**
     * Этот getter нужен для @Value
     */
    public int getAge() {
        return age;
    }

    /**
     * Этот setter нужен для @Value
     */
    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }

}