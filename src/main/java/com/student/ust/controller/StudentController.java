package com.student.ust.controller;

import com.student.ust.entity.Student;
import com.student.ust.service.StudentSevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@Slf4j
public class StudentController
{
    @Autowired
    StudentSevice studentSevice;

    @GetMapping("/student/{id}")
   public  ResponseEntity<Student>get(@PathVariable Integer id)
    {
        try
        {
            Student student = studentSevice.getStudentByID(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

            @PostMapping("/student")
                    public void add(@RequestBody Student student)
            {
                log.debug("Stuname>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+ student.getName());
                studentSevice.saveStudent(student);
            }

            @GetMapping("/student")
                    public ResponseEntity<List<Student>> get() {
                 log.debug("Glo");
                try {
                    List<Student> studentList = studentSevice.getAllStudent();
                    return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
                } catch (NoSuchElementException e) {
                    return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);


                }

            }
            @DeleteMapping("/student/{id}")
           public void delete(@PathVariable Integer id) {
                studentSevice.deleteId(id);

            }
            @PutMapping("/student")
    public ResponseEntity<Student>put(@RequestBody Student student){
        try {
            Student updateStudent = studentSevice.updateStudent(student);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }
        catch(NoSuchElementException e)
        {
            return  new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }



    }
}

