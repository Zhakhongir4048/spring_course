package com.example.spring_course.spring_introduction;

import com.example.spring_course.SpringCourseApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        SpringCourseApplication.class);
    Person myPerson = context.getBean("personBean", Person.class);
    myPerson.callYourPet();
    System.out.println(myPerson.getSurname());
    System.out.println(myPerson.getAge());
    context.close();
  }

}