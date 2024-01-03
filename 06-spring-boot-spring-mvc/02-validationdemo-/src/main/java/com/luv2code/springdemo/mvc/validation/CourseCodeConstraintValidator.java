package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {
    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        //assign the value passed in from our annotation
        coursePrefix=theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
       // theCode Html from data entered by the user
       //constraintValidatorContext -> the actual parameter that we can use to give additional error message
       //constraintValidatorContext i can add additional error message here
        boolean result;
        if (theCode!=null) {
           result= theCode.startsWith(coursePrefix);
            // does it start with LUV -> test if the form data starts with our coursePrefix
        }else {
            result=true;
        }
        return result;
    }
}
