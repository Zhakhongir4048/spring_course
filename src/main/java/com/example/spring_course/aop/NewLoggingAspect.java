package com.example.spring_course.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(NewLoggingAspect.class);

    @Around("execution(public String com.example.spring_course.aop.SchoolLibrary.returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");
        long begin = System.currentTimeMillis();
        Object targetMethodProceed = null;
        try {
            targetMethodProceed = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            log.info("aroundReturnBookLoggingAdvice: было поймано исключение " + e);
            throw new Throwable();
        }
        long end = System.currentTimeMillis();
        log.info("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
        log.info("Метод returnBook() выполнился за " + Double.parseDouble(String.valueOf(end - begin)) / 1000 + " секунд");
        return targetMethodProceed;
    }

}