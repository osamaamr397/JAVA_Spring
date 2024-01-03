package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }
    //expose new end point for workout
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k !";
    }
    //expose new workout for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is our lucky day.";
    }
}
