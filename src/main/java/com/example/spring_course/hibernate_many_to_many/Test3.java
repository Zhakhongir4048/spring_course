package com.example.spring_course.hibernate_many_to_many;

import com.example.spring_course.hibernate_many_to_many.entity.Child;
import com.example.spring_course.hibernate_many_to_many.entity.Section;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Slf4j
public class Test3 {

    public static void main(String[] args) {
        log.info("Method main starts");
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory(); sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
            Child child = currentSession.get(Child.class, 4);
            System.out.println("child = " + child);
            currentSession.getTransaction().commit();
            log.info("Success");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        log.info("Method main ends");
    }

}