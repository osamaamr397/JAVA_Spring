package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach mycoach;

    //define a constructor for dependency injection
    @Autowired
    //autowired tells spring to inject a dependency
    //the coach is the dependency
    public DemoController(Coach theCoach){
        mycoach=theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailyWorkout();
    }
}
