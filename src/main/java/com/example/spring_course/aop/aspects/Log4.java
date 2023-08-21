package com.example.spring_course.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(40)
public class Log4 {

    @Before("com.example.spring_course.aop.aspects.MyPointcuts.allGetMethodsBesidesReturnMagazineUniLibrary()")
    public void beforeAddAndReturnBesidesReturnMagazineLoggingAdvice() {
        System.out.println("beforeAddAndReturnBesidesReturnMagazineLoggingAdvice: writing Log #4");
        System.out.println("--------------------------------------------------------");
    }

}