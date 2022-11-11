package com.student.ust.service;

import com.student.ust.entity.Student;
import com.student.ust.repository.StudentRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentSevice
{
    @Autowired
    StudentRepository studentRepository;
    private Date current;

    public Student getStudentByID(Integer id)throws NoSuchElementException
    {
        return studentRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }
        public void saveStudent(Student student){

            student.setDateBirth(LocalDateTime.now());
            student.setModifiedDate(student.getDateBirth());
            studentRepository.save(student);
    }
    public List<Student> getAllStudent()
    {

        System.out.println((studentRepository.findByName("va")));
        System.out.println((studentRepository.findByAge(22)));

        System.out.println((studentRepository.findByNameStartingWith("v")));



        return studentRepository.findAll();


    }
    public  Student updateStudent(Student student)
    {
        Student updateStudent=studentRepository.findById(student.getStudId()).orElseThrow(()->new NoSuchElementException());
        updateStudent.setName(student.getName());
        updateStudent.setAge(student.getAge());
        updateStudent.setRollno(student.getRollno());
        updateStudent.setModifiedDate(LocalDateTime.now());
        studentRepository.save(updateStudent);
        return  updateStudent;
    }

    public void deleteId(Integer id)
    {
        studentRepository.deleteById(id);
    }


    }

