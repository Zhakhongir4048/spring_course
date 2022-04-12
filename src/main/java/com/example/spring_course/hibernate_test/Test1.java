package com.example.spring_course.hibernate_test;

import com.example.spring_course.hibernate_test.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test1 {

    private static final Logger log = LoggerFactory.getLogger(Test1.class);

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try (sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
            Employee employee = new Employee("Aleksandr", "Smirnov", "Sales", 700);
            currentSession.save(employee);
            currentSession.getTransaction().commit();
            log.info("Успешно");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}