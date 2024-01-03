package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student>theStudents;
    //define @Postconstruct to load the student data ...only once
    //post construct it's' been called once when it's given bean is constructed
    @PostConstruct
    public void loadData(){
        theStudents=new ArrayList<>();
        theStudents.add(new Student("amr","osama"));
        theStudents.add(new Student("mario","osama"));
        theStudents.add(new Student("taki","osama"));
    }

    //define endpoint for "/students" - returns a list of students
    @GetMapping("/students")
    public List<Student>getStudents(){

        return theStudents;
    }
    //define endpoint for "/students/{studentId}" - returns a  students
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //just index into the list keep it simple
        //check studentId again list size
        if((studentId>=theStudents.size())||(studentId<0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
       return theStudents.get(studentId);
    }


}
