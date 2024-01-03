package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//this is mean call me when you need me this bean will not be created until you call it
public class TrackCoach implements Coach{
    public TrackCoach(){
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }
    public String getDailyWorkout(){

        return "Run a Hard 5k ! ";
    }
}
