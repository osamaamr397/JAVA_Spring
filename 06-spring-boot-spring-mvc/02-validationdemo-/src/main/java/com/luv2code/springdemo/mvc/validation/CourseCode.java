package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
//helper class that contain business rules and validation logic
@Target({ElementType.METHOD,ElementType.FIELD})
/*
where you cam apply this new annotation that we're creating so we can apply this annotation
to a method or field
 */
@Retention(RetentionPolicy.RUNTIME)
//this basically says how long will the marked annotation be stored or used
public @interface CourseCode {
  //define default course code
    public String value() default "LUV";
  //define default error message
    public String message()default  "must start with LUV";
  //define default groups
    /*
    here we simply just give the basic boilerplate here of groups
    and we will simply just give an empty collection
     */
    public Class<?>[]groups()default{};
  //define default payloads
    public Class<?extends Payload>[]payload()default {};
    //payload provide custom details about validation failure (severity level,error code etc    )
}
