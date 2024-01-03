package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
//component annotation marks the class as a spring bean makes it available for dependency injection
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!";
    }
}
