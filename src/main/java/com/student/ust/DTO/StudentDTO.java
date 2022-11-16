package com.student.ust.DTO;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;
@Data
public class StudentDTO {
    private  int studentId;
    private String name;
    private int age;
    private int rollno;
    private LocalDateTime dateBirth;
    private LocalDateTime modifiedDate;

}
