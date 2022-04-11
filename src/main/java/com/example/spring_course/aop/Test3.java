package com.example.spring_course.aop;

import com.example.spring_course.aop.config.MyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {

    private static final Logger log = LoggerFactory.getLogger(Test3.class);

    public static void main(String[] args) {
        log.info("Method main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        SchoolLibrary schoolLibrary = context.getBean(SchoolLibrary.class);
        String bookName = schoolLibrary.returnBook();
        log.info("В библиотеку вернули книгу " + bookName);
        context.close();
        log.info("Method main ends");
    }

}