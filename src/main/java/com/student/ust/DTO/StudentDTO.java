package com.student.ust.DTO;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;
@Data
public class StudentDTO {
    private String name;
    private int age;
    private int rollno;

}
