package com.example.spring_course.spring_introduction;

import com.example.spring_course.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Dog myDog = context.getBean("myPet", Dog.class);
        Dog yourDog = context.getBean("myPet", Dog.class);
        System.out.println("Переменные ссылаются на один и тот же объект? " + (myDog == yourDog));
        System.out.println(myDog);
        System.out.println(yourDog);
        context.close();
    }

}