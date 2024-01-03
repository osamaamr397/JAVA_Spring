package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Scope;


@Entity
@Table(name="employee")
public class Employee {
    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //GenerationType.IDENTITY to let mysql handle the auto-increment on that given id
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;




    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    public Employee(){}
    public Employee(String firstName,String lastName,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public int getId() {
        return id;
    }



    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
