package com.example.spring_course.hibernate_test;

import com.example.spring_course.hibernate_test.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Slf4j
public class Test1 {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Employee.class)
        .buildSessionFactory();
    try (sessionFactory) {
      Session currentSession = sessionFactory.getCurrentSession();
      currentSession.beginTransaction();
      Employee employee = new Employee("Zhakhongir", "Esonov", "IT", 4);
      currentSession.save(employee);
      currentSession.getTransaction().commit();
      log.info("Успешно");
      log.info(String.valueOf(employee));
    } catch (HibernateException e) {
      e.printStackTrace();
    }
  }

}