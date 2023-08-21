package com.example.spring_course.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class NewLoggingAspect {

    @Around("execution(public String com.example.spring_course.aop.SchoolLibrary.returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        log.info("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");
        long begin = System.currentTimeMillis();
        Object targetMethodProceed;
        try {
            targetMethodProceed = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            log.info("aroundReturnBookLoggingAdvice: было поймано исключение " + e);
            throw new Throwable();
        }
        long end = System.currentTimeMillis();
        log.info("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
        log.info(
                "Метод returnBook() выполнился за " + Double.parseDouble(String.valueOf(end - begin)) / 1000
                        + " секунд");
        return targetMethodProceed;
    }

}