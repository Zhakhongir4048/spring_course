package com.example.spring_course.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

    @Pointcut("execution(* com.example.spring_course.aop.UniLibrary.add*(..))")
    void allAddMethodsFromUniLibrary() {
    }

    @Pointcut("execution(* com.example.spring_course.aop.UniLibrary.return*())")
    void allReturnMethodsFromUniLibrary() {
    }

    @Pointcut("allAddMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    void allAddAndReturnMethodsFromUniLibrary() {
    }

    @Pointcut("execution(public void com.example.spring_course.aop.UniLibrary.returnMagazine())")
    void returnMagazineFromUniLibrary() {
    }

    @Pointcut("execution(* com.example.spring_course.aop.UniLibrary.*(..))")
    void allMethodsFromUniLibrary() {
    }

    @Pointcut("!returnMagazineFromUniLibrary() && allMethodsFromUniLibrary()")
    void allGetMethodsBesidesReturnMagazineUniLibrary() {
    }

}