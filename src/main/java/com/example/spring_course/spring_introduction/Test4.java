package com.example.spring_course.spring_introduction;

import com.example.spring_course.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test4 {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        JavaConfig.class);
    Person personBean = context.getBean("personBean", Person.class);
    personBean.callYourPet();
    System.out.println(personBean.getSurname());
    System.out.println(personBean.getAge());
  }

}