package com.example.spring_course.hibernate_one_to_one;

import com.example.spring_course.hibernate_one_to_one.entity.Detail;
import com.example.spring_course.hibernate_one_to_one.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Slf4j
public class Test4 {

    public static void main(String[] args) {
        log.info("Method main starts");
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        try (sessionFactory; Session currentSession = sessionFactory.getCurrentSession()) {
            Employee employee = new Employee("Nikolay", "Ivanov", "HR", 850);
            Detail detail = new Detail("New-York", "654123789", "nikolay@gmail.com");
            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            currentSession.beginTransaction();
            currentSession.save(detail);
            currentSession.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        log.info("Method main ends");
    }

}