package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    //create a mapping for "/hello "
    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theData",new java.util.Date());
        /*since we have Thymeleaf dependency in Maven POM spring boot will auto-configure
        to use Thymeleaf
        so when return hello world it's looks for src/main/resources/template/helloworld.html
        */
        return "helloworld";

    }
}
