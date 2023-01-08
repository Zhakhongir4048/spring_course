package com.example.spring_course.hibernate_one_to_one.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "details")
public class Detail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "city")
  private String city;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "email")
  private String email;

  @OneToOne(mappedBy = "empDetail", cascade = CascadeType.ALL)
  private Employee employee;

  public Detail(String city, String phoneNumber, String email) {
    this.city = city;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  @Override
  public String toString() {
    return "Detail{" +
        "id=" + id +
        ", city='" + city + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", email='" + email + '\'' +
        '}';
  }

}