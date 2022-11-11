package com.student.ust.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name="Student_Table2_ustbatch_mappedby")
public class Student
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int StudId;
    private String name;
    private int  age;
    private int rollno;
    private LocalDateTime dateBirth;
    private LocalDateTime modifiedDate;

      @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "student")
      private Set<Book> bookSet;
}
