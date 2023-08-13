package com.example.spring_course.hibernate_one_to_many_uni;

import com.example.spring_course.hibernate_one_to_many_uni.entity.Department;
import com.example.spring_course.hibernate_one_to_many_uni.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Slf4j
public class Test1 {

    public static void main(String[] args) {
        log.info("Method main starts");
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        try (sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            Department department = new Department("Flowers", 100000, 30000);
            Employee emp1 = new Employee("Jasur", "Esonov", 120000);
            Employee emp2 = new Employee("Uktam", "Esonov", 30000);
            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);
            currentSession.beginTransaction();
            currentSession.save(department);
            currentSession.getTransaction().commit();
            log.info("Success");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        log.info("Method main ends");
    }

}