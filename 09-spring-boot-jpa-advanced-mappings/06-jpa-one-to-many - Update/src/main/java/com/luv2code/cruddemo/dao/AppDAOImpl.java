package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{
    //define field for entity manager
    private EntityManager entityManager;
    //inject entity manager using constructor injections
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor){
        //this will also save instructor details because we have cascade type.All
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class,theId);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the instructor
        Instructor theInstructor=entityManager.find(Instructor.class,id);
        //delete the instructor
        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetails findInstructorDetailsById(int theId) {
       return entityManager.find(InstructorDetails.class,theId);
    }
    @Override
    @Transactional
    public void deleteInstructorDetailsById(int theId){
        //find the details instructor
        InstructorDetails tempInstructorDetails=entityManager.find(InstructorDetails.class,theId);
        //remove the associated object reference
        //break the bi-directional link
        //
        tempInstructorDetails.getInstructor().setInstructorDetails(null);
        //delete the tempInstructorDetails
        entityManager.remove(tempInstructorDetails);
    }
    @Override
    public List<Course>findCoursesByInstructorId(int theId){
        //create query
        TypedQuery<Course>query=entityManager.createQuery("from Course where instructor.id = :data",
                Course.class);
        query.setParameter("data",theId);
        //execute query
        List<Course>courses=query.getResultList();
        return courses;

    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        //create query

        TypedQuery<Instructor>query=entityManager.createQuery(
                "select i from Instructor i "
                +"join fetch i.courses "//should there white space
                +"join fetch i.instructorDetails "
                +"where i.id = :data",Instructor.class
                /*
        Even with instructor
        @oneToMany(fetchType.lazy)
        this code will retrieve instructor and courses
        the join fetch is similar to eager loading
         */
        );
        query.setParameter("data",theId);
        //execute the query
        Instructor instructor= query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
       entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        //retrieve the instructor
        Instructor tempInstructor=entityManager.find(Instructor.class,theId);
        //get the course
        List<Course>courses=tempInstructor.getCourses();
        //break associated of all courses for the instructor
        for(Course tempCourse:courses){
            tempCourse.setInstructor(null);
        }
        entityManager.remove(tempInstructor);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course tempCourse=entityManager.find(Course.class,theId);
        entityManager.remove(tempCourse);
    }


}
