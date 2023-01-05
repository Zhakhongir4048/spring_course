package com.example.spring_course.hibernate_many_to_many;

import com.example.spring_course.hibernate_many_to_many.entity.Child;
import com.example.spring_course.hibernate_many_to_many.entity.Section;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Slf4j
public class Test {

  public static void main(String[] args) {
    log.info("Method main starts");
    try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Child.class)
        .addAnnotatedClass(Section.class)
        .buildSessionFactory(); sessionFactory) {
      Session currentSession = sessionFactory.getCurrentSession();
      Section section1 = new Section("Footbal");
      Child child1 = new Child("Zaur", 5);
      Child child2 = new Child("Masha", 7);
      Child child3 = new Child("Vasya", 6);
      section1.addChildToSection(child1);
      section1.addChildToSection(child2);
      section1.addChildToSection(child3);
      currentSession.beginTransaction();
      currentSession.save(section1);
      currentSession.getTransaction().commit();
      log.info("Success");
    } catch (HibernateException e) {
      e.printStackTrace();
    }
    log.info("Method main ends");
  }

}