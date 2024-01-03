package com.luv2code.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }
    //define our init method

    @Override
    public String getDailyWorkout() {
        return "practice your backhand volley ";
    }
}
