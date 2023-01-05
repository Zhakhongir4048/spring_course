package com.example.spring_course.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(30)
public class Log3 {

  @Before("com.example.spring_course.aop.aspects.MyPointcuts.allAddAndReturnMethodsFromUniLibrary()")
  public void beforeAddAndReturnLoggingAdvice() {
    System.out.println("beforeAddAndReturnLoggingAdvice: writing Log #3");
    System.out.println("--------------------------------------------------------");
  }

}