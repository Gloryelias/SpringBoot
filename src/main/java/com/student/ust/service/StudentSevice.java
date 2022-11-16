package com.student.ust.service;

import com.student.ust.DTO.StudentDTO;
import com.student.ust.exception.InvalidEmailException;
import com.student.ust.entity.Student;
import com.student.ust.exception.InvalidPasswordException;
import com.student.ust.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.student.ust.util.USTUtill.*;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
@Service
@Slf4j
public class StudentSevice
{
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;
    private Date current;

    public Student getStudentByID(Integer id)throws NoSuchElementException
    {
        return studentRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }
        public void saveStudent(Student student){
            boolean validEmail = ValidEmail(student);
            boolean validPassword = validPassword(student);

            if(validEmail && validPassword){
                student.setDateBirth(LocalDateTime.now());
                student.setModifiedDate(student.getDateBirth());
                String password = student.getPassword();
                student.setPassword(hashPassword(password));
                studentRepository.save(student);
            }
            else if (!validEmail)
            {
                throw new InvalidEmailException();
            }
            else
            {
                throw new InvalidPasswordException();
            }




    }
    public List<Student> getAllStudent()
    {

       log.debug(studentRepository.findByAge(22).getName());
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


    public StudentDTO converttoDTO(Student student) {
        return  modelMapper.map(student,StudentDTO.class);


    }
    public  List<StudentDTO>  converttoDTO2(list<Student> studentAll){
        Object StudentDTO;
        short List;
        List<StudentDTO>  studentDTOList=modelMapper.map(studentAll,new TypeToken<List<StudentDTO>>(){}.getType());
        return  studentDTOList;
    }
}

