package com.luv2code.springdemo.mvc.model;

import com.luv2code.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String lastName="";
    @NotNull(message = "is required")
    @Min(value = 0,message = "value must be greater than zero")
    @Max(value = 10,message = "value must be smaller or equal to ten")
    private Integer freePasses;
//Why Integer will work unlike int ?
    /*
    * Because if our field is blank or has spaces then they will actually trim it to null
    * using that string trimming editor that we have added before and this will handle the issue
    * and Integer is special wrapper of java
    * */
    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 chars/digits")
    private String postalCode;
    @CourseCode(value = "TOPS",message = "must start with TOPS")
    private String courseCode;
    public Customer(){}

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
