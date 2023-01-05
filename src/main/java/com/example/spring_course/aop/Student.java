package com.example.spring_course.aop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Student {

  private String nameSurname;
  private int course;
  private double avgGrade;

}