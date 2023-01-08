package com.example.spring_course.hibernate_one_to_one.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "department")
  private String department;

  @Column(name = "salary")
  private int salary;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "details_id")
  private Detail empDetail;

  public Employee(String name, String surname, String department, int salary) {
    this.name = name;
    this.surname = surname;
    this.department = department;
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", department='" + department + '\'' +
        ", salary=" + salary +
        '}';
  }

}