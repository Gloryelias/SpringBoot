package com.student.ust.controller;

import com.student.ust.DTO.StudentDTO;
import com.student.ust.exception.BusinessException;
import com.student.ust.exception.InvalidEmailException;
import com.student.ust.entity.Student;
import com.student.ust.exception.InvalidPasswordException;
import com.student.ust.service.StudentSevice;
import com.student.ust.service.list;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


/**
 * The type Student controller.
 */
@RestController
@Slf4j
public class StudentController
{
    /**
     * The Student sevice.
     */
    @Autowired
    StudentSevice studentSevice;

    /**
     * Get response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/student/{id}")
   public  ResponseEntity<StudentDTO>get(@PathVariable Integer id)
    {
        log.debug("student return of id >>>>>>>>>> "+ id);
        try
        {
            Student student = studentSevice.getStudentByID(id);
            //log.debug("student return of id >>>>>>>>>> "+ id + "  Name is >>>>>>" +student.getName());
            return new ResponseEntity<StudentDTO>(studentSevice.converttoDTO(student),HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Add response entity.
     *
     * @param student the student
     * @return the response entity
     */
    @PostMapping("/student")
                    public ResponseEntity<Student> add(@RequestBody Student student)
            {
                try{
                    studentSevice.saveStudent((student));
                    log.debug("student return of id >>>>>>>>>> "+ student.getName()+ "  " +student.getAge() + " " + student.getRollno() );
                    return new ResponseEntity<Student>(student,HttpStatus.OK);
                }catch(InvalidEmailException e){
                    return  new ResponseEntity<Student>(HttpStatus.PRECONDITION_FAILED);
                }
                catch (InvalidPasswordException  e)
                {
                    return  new ResponseEntity<Student>(HttpStatus.PRECONDITION_FAILED);
                }
                catch (NoSuchElementException e)

                {
                    return  new ResponseEntity<Student>(HttpStatus.PRECONDITION_FAILED);
                }
            }

    /**
     * Get response entity.
     *
     * @return the response entity
     */

    @GetMapping("/student")
    public ResponseEntity<List<StudentDTO>> getall() {
                 //log.debug("Glo");
                try {
                    List<Student> studentList = studentSevice.getAllStudent();
                    list<Student> studentAll = new list<>();
                    return new ResponseEntity<List<StudentDTO>>(studentSevice.converttoDTO2(studentAll), HttpStatus.OK);
                } catch (NoSuchElementException e) {
                    return new ResponseEntity<List<StudentDTO>>(HttpStatus.NOT_FOUND);


                }

            }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/student/{id}")
           public void delete(@PathVariable Integer id) {
                studentSevice.deleteId(id);

            }

    /**
     * Put response entity.
     *
     * @param student the student
     * @return the response entity
     */
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

