package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach mycoach;

    //define a constructor for dependency injection
   @Autowired
   public DemoController(@Qualifier("cricketCoach") Coach theCoach){
       System.out.println("In Constructor: "+getClass().getSimpleName());
       mycoach=theCoach;
   }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailyWorkout();
    }
}
