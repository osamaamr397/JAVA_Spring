package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {
    // need a controller method to show initial form
    @GetMapping("/showForm")
    public String showForm(){

        //in background spring mvc will got to resources/template/helloworld-form.html
        return "helloworld-form";
    }
    @RequestMapping("/processForm")
    // need a controller method to process HTML form
    public String processForm(){

        return "helloworld";
    }
    @RequestMapping("/processFormVersionTwo")
        //need a controller method to read from data and add data to the model
    public String letsShoutDude(HttpServletRequest request, Model model){
        // read a request parameter form the html form
        String theName=request.getParameter("studentName");
        //convert the data to all caps
        theName=theName.toUpperCase();
        //create the message
        String result="YO! "+theName;
        //add  message to the model
        model.addAttribute("message",result);
        return "helloworld";
    }


    //using Request parameter and bind it to the variable which is parameterized
    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName")String theName,Model model){

        theName=theName.toUpperCase();
        String result="Hey my friends from version 3 "+theName;
        model.addAttribute("message",result);
        return "helloworld";
    }
}
