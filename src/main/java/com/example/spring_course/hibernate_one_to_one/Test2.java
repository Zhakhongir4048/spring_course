package com.example.spring_course.hibernate_one_to_one;

import com.example.spring_course.hibernate_one_to_one.entity.Detail;
import com.example.spring_course.hibernate_one_to_one.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Slf4j
public class Test2 {

  public static void main(String[] args) {
    log.info("Method main starts");
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Employee.class)
        .addAnnotatedClass(Detail.class)
        .buildSessionFactory();
    try (sessionFactory; Session currentSession = sessionFactory.getCurrentSession()) {
      currentSession.beginTransaction();
      Employee employee = currentSession.get(Employee.class, 1);
      currentSession.getTransaction().commit();
      log.info(String.valueOf(employee));
      log.info(String.valueOf(employee.getEmpDetail()));
    } catch (HibernateException e) {
      e.printStackTrace();
    }
    log.info("Method main ends");
  }

}