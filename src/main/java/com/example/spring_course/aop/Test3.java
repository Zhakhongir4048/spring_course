package com.example.spring_course.aop;

import com.example.spring_course.aop.config.MyConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Test3 {

    public static void main(String[] args) {
        log.info("Method main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MyConfig.class);
        SchoolLibrary schoolLibrary = context.getBean(SchoolLibrary.class);
        String bookName = schoolLibrary.returnBook();
        log.info("В библиотеку вернули книгу " + bookName);
        context.close();
        log.info("Method main ends");
    }

}