package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

//@Entity which represents the data of a student, and we would like to store it in the database:
@Entity
@Table(name = "student")
public class Student {
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

    //define Constructor
    public Student(){
    //no argument constructor required by JPA
    }
    public Student(String fitstName, String lastName, String email){
        this.firstName=fitstName;
        this.lastName=lastName;
        this.email=email;
    }
    //define setters and getters

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

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //define toString() method
    @Override
    public String toString() {
        return "Studnet{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
