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
@Table(name = "section")
public class Section {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "child_section",
      joinColumns = @JoinColumn(name = "section_id"),
      inverseJoinColumns = @JoinColumn(name = "child_id")
  )
  private List<Child> children;

  public Section(String name) {
    this.name = name;
  }

  public void addChildToSection(Child child) {
    if (children == null) {
      children = new ArrayList<>();
    }
    children.add(child);
  }

}