package com.student.ust.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Book_Table2_ustbatch_mappedby")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int bookId;
    private String bookName;
    private String authorName;
    private long isbn;
    private LocalDateTime dateBirth;
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name="Stud_id")
    Student student;


}
