package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetails;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void delete(Integer id);
    InstructorDetails findInstructorDetailsById(int theId);
    void deleteInstructorDetailsById(int theId);

}
