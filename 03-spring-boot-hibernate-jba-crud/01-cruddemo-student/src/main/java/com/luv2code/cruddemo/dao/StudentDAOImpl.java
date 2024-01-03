package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//specialized annotation for repositories , support component scanning,Translate JDBC

public class StudentDAOImpl implements StudentDAO{
    //define field for entity manger
    private EntityManager entityManager;
    //inject entity manger using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    //implement save method
    @Override
    @Transactional
    /*since we are performing an update on the DB wa are saving or storing
    object in the DB
     */

    public void save(Student theStudent) {

        entityManager.persist(theStudent);
    }
    //as we don't make any updates to query we don't need transactional annotation
    public Student findById(Integer id){
        return entityManager.find(Student.class,id);
                            //the entity class  primary key
    }

    @Override
    public List<Student> finaAll() {
        //create query
        TypedQuery<Student>theQuery=entityManager.createQuery("FROM Student",Student.class);
                                                            //name of JPA Entity the class name
        //this is not the name of database table All JPQL syntax is based on entity name and entity field
        TypedQuery<Student>theLastNameQuery=entityManager.createQuery("FROM Student order by lastname ",Student.class);
        //lastname is field of jpa entity this field from java class not the database column but the actual JPA entity
        //by default order by is desc if I want to change will be asc->order by lastname asc
        //return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create query                                           theDta =JPQL named parameters are prefixed with a colon
        TypedQuery<Student>theQuery=entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
        //set query parameters                                              theData = think of it as a placeholder
        theQuery.setParameter("theData",theLastName);
        //return query result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
        Student theStudent=entityManager.find(Student.class,id);
        //delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowDeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowDeleted;
    }
}
