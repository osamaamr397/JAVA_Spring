package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //                                                entity type  primary key
    //that's it .... no need to write any code

    //request will be http://localhost:8080/magic-api/members
    //instead of
    //http://localhost:8080/magic-api/employees
}
