package com.example.spring_course.aop;

import com.example.spring_course.aop.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MyConfig.class);
        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        uniLibrary.getBook();
        Book book = context.getBean("book", Book.class);
        uniLibrary.addBook("Zhakhongir", book);
        uniLibrary.addMagazine();
        context.close();
    }

}