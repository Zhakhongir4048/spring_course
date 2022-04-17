package com.example.spring_course.hibernate_one_to_many_bi;

import com.example.spring_course.hibernate_one_to_many_bi.entity.Department;
import com.example.spring_course.hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test2 {

    private static final Logger log = LoggerFactory.getLogger(Test2.class);

    public static void main(String[] args) {
        log.info("Method main starts");
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        try (sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
            Department department = currentSession.get(Department.class, 1);
            log.info(String.valueOf(department));
            log.info(String.valueOf(department.getEmps()));
            currentSession.getTransaction().commit();
            log.info("Success");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        log.info("Method main ends");
    }

}