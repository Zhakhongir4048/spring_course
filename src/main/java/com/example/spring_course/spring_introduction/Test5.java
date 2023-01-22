package com.example.spring_course.spring_introduction;

import com.example.spring_course.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test5 {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        MyConfig.class);
    Pet cat1 = context.getBean("catBean", Pet.class);
    Pet cat2 = context.getBean("catBean", Pet.class);
    cat1.say();
    cat2.say();
    Person person = context.getBean("personBean", Person.class);
    person.callYourPet();
    System.out.println(person.getAge());
    System.out.println(person.getSurname());
    context.close();
  }

}