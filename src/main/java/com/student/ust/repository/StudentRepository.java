package com.student.ust.repository;

import com.student.ust.entity.Student;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Student repository.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{


    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    Student findByName(String name);


    /**
     * Find by age list.
     *
     * @param age the age
     * @return the list
     */
   Student findByAge(int age);

    /**
     * Find by name starting with list.
     *
     * @param prefix the prefix
     * @return the list
     */
    List<Student> findByNameStartingWith(String prefix);

    

}
