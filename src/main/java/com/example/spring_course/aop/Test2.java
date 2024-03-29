package com.example.spring_course.aop;

import com.example.spring_course.aop.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MyConfig.class);
        University university = context.getBean(University.class);
        university.addStudents();
        List<Student> students = null;
        try {
            students = university.getStudents();
        } catch (Exception e) {
            System.out.println("Было поймано исключение " + e);
        }
        System.out.println(
                "-----------------------------------------------------------------------------");
        System.out.println(students);
        context.close();
    }

}