package com.example.spring_course.hibernate_test;

import com.example.spring_course.hibernate_test.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test5 {

    private static final Logger log = LoggerFactory.getLogger(Test5.class);

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try (sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();

            Employee employee = currentSession.get(Employee.class, 2);
            currentSession.delete(employee);

            currentSession.createQuery("delete from Employee where name = 'Oleg'")
                    .executeUpdate();

            currentSession.getTransaction().commit();
            log.info("Успешно");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}