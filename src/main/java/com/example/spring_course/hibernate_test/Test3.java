package com.example.spring_course.hibernate_test;

import com.example.spring_course.hibernate_test.entity.Employee;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Slf4j
public class Test3 {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Employee.class)
        .buildSessionFactory();
    try (sessionFactory) {
      Session currentSession = sessionFactory.getCurrentSession();
      currentSession.beginTransaction();
      List<Employee> emp = currentSession.createQuery("from Employee").getResultList();
      List<Employee> emp2 = currentSession.createQuery("from Employee where name = 'Oleg'")
          .getResultList();
      emp.forEach(System.out::println);
      emp2.forEach(System.out::println);
      currentSession.getTransaction().commit();
      log.info("Успешно");
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }

}