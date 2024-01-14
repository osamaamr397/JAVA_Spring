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


		//	updateInstructor(appDAO);
		//	updateCourse(appDAO);
		//	deleteInstructor(appDAO);
			deleteCourse(appDAO);
		};
		}

	private void deleteCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("Deleting the course with id "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done");

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting the instructor with id "+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done");

	}

	private void updateCourse(AppDAO appDAO) {
		int theId=10;
		//find the Course
		System.out.println("Finding course id "+theId);
		Course tempCourse=appDAO.findCourseById(theId);
		//update the Course
		System.out.println("Updating the Course id "+theId);
		tempCourse.setTitle("Test course");
		appDAO.update(tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=1;
		//find the instructor
		System.out.println("Finding instructor id "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		//update the instructor
		System.out.println("Updating the instructor id "+theId);
		tempInstructor.setLastName("Tester");
		appDAO.update(tempInstructor);
	}


}
