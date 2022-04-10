package com.example.spring_course.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration("configAOP")
@ComponentScan("com.example.spring_course.aop")
@EnableAspectJAutoProxy
public class MyConfig {
}