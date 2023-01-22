package com.example.spring_course.spring_introduction;

import com.example.spring_course.SpringCourseApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigWithAnnotations1 {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        SpringCourseApplication.class);
    Person person = context.getBean("personBean", Person.class);
    person.callYourPet();
    System.out.println("-----------------------------------------");
    Cat myCat = context.getBean("catBean", Cat.class);
    myCat.say();
    context.close();
  }

}