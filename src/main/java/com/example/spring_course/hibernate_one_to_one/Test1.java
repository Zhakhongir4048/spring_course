package com.example.spring_course.hibernate_one_to_one;

import com.example.spring_course.hibernate_one_to_one.entity.Detail;
import com.example.spring_course.hibernate_one_to_one.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test1 {

    private static final Logger log = LoggerFactory.getLogger(Test1.class);

    public static void main(String[] args) {
        log.info("Method main starts");
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        try (sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);
            Detail detail = new Detail( "Moscow", "987654321", "olejka@gmail.com");
            employee.setEmpDetail(detail);
            currentSession.beginTransaction();

            currentSession.save(employee);

            currentSession.getTransaction().commit();
         } catch (HibernateException e) {
            e.printStackTrace();
        }
        log.info("Method main ends");
    }

}