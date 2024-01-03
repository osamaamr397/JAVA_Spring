package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach mycoach;
    private Coach anotherCoach;


   /*
    //define a constructor for dependency injection
   @Autowired
   public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                         @Qualifier("cricketCoach")Coach theAnotehrCoach){
       System.out.println("In Constructor: "+getClass().getSimpleName());
       mycoach=theCoach;
       anotherCoach=theAnotehrCoach;
   }

    */
    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach theCoach,
                          @Qualifier("tennisCoach")Coach theAnotehrCoach){
        System.out.println("In Constructor: "+getClass().getSimpleName());
        mycoach=theCoach;
        anotherCoach=theAnotehrCoach;
    }
   @GetMapping("/check")
   public String check(){
       return "Comparing beans: mycoach == anotehrcoach, "+ (mycoach==anotherCoach);
   }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailyWorkout();
    }
}
