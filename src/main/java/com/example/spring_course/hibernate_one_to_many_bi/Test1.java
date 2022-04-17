package com.example.spring_course.hibernate_one_to_many_bi;

import com.example.spring_course.hibernate_one_to_many_bi.entity.Department;
import com.example.spring_course.hibernate_one_to_many_bi.entity.Employee;
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
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        try (sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            Department dep = new Department("IT", 1200, 300);
            Employee emp1 = new Employee("Zaur", "Tregulov", 800);
            Employee emp2 = new Employee("Elena", "Smirnova", 1000);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            currentSession.beginTransaction();
            currentSession.save(dep);
            currentSession.getTransaction().commit();
            log.info("Success");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        log.info("Method main ends");
    }

}