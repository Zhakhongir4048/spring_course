package com.example.spring_course.hibernate_many_to_many.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "children")
public class Child {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "age")
  private int age;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "child_section",
      joinColumns = @JoinColumn(name = "child_id"),
      inverseJoinColumns = @JoinColumn(name = "section_id")
  )
  private List<Section> sections;

  public Child(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void addSectionToChild(Section section) {
    if (sections == null) {
      sections = new ArrayList<>();
    }
    sections.add(section);
  }

  @Override
  public String toString() {
    return "Child{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

}