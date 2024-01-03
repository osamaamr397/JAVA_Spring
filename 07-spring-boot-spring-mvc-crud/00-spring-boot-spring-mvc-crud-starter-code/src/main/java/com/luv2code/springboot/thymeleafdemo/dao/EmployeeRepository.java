package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!
    //add method to sort by last name

    /*
    * spring jpa will parse the method name looks for specific format and pattern
    * creates appropriate query behind scenes
    * */
    public List<Employee>findAllByOrderByLastNameAsc();

}
