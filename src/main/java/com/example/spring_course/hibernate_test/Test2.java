package com.example.spring_course.hibernate_test;

import com.example.spring_course.hibernate_test.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test2 {

    private static final Logger log = LoggerFactory.getLogger(Test2.class);

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try (sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
            Employee employee = new Employee("Oleg", "Sidorov", "HR", 700);
            currentSession.save(employee);
            int myId = employee.getId();
            Employee employee2 = currentSession.get(Employee.class, myId);
            currentSession.getTransaction().commit();
            log.info(String.valueOf(employee2));
            log.info("Успешно");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}