package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetails;
import org.hibernate.engine.jdbc.BinaryStream;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void delete(Integer id);
    InstructorDetails findInstructorDetailsById(int theId);
    void deleteInstructorDetailsById(int theId);
    List<Course> findCoursesByInstructorId(int theId);
    Instructor findInstructorByIdJoinFetch(int theId);
    void update(Instructor tempInstructor);
    void update(Course tempCourse);
    Course findCourseById(int theId);
    void deleteInstructorById(int theId);
    void deleteCourseById(int theId);
    void save(Course theCourse);
    Course findCourseAndReviewByCourseId(int theId);

}
