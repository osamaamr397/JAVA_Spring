package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public String getDailyWorkout(){

        return "spend 30 minutes in batting practice";
    }
}
