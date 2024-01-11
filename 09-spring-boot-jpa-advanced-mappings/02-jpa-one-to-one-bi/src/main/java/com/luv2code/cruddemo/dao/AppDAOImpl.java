package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
