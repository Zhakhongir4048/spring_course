package com.example.spring_course.spring_introduction;

import com.example.spring_course.SpringCourseApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringCourseApplication.class);
        context.getBean("myPet", Pet.class).say();
        context.close();
    }

}