package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

		@Bean
		//CommandLineRunner ->executed after the spring bean have bean loaded
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{

			findInstructorWithCoursesJoinFetch(appDAO);
		};
		}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		//find instructor
		int theId=1;
		System.out.println("finding the instructor with id "+theId);
		Instructor tempInstructor=appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done");
	}


}
