package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String>countries;
    @Value("${progLang}")
    private List<String>languages;
    @Value("${favSystem}")
    private List<String>systems;
    @GetMapping("/showStudentForm")
    public String showForm(Model model){
        //create new student object
        Student theStudent=new Student();
        //add student object to the model
        model.addAttribute("student",theStudent);
        //add the list of countries to the model
        model.addAttribute("countries",countries);
        //add the radio button the list of proglang to the model
        model.addAttribute("languages",languages);
        //add the systems
        model.addAttribute("systems",systems);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent){
        System.out.println("the student: "+theStudent.getFirstName()+" "+theStudent.getLastName());
        return "student-confirmation";
    }
}
