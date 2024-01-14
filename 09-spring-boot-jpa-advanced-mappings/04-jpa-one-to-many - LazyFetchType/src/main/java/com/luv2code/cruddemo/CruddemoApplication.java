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
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetails(appDAO);
			//deleteInstructorDetails(appDAO);
			//createInstructorWithCourses(appDAO);//this using fetch type EAGER
			//findInstructorWithCourses(appDAO);
			findCoursesForInstructor(appDAO);
		};
		}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);

		//find courses for instructor
		System.out.println("Finding Courses for instructor id without EAGER : ");
		List<Course>courses=appDAO.findCoursesByInstructorId(theId);
		//associate the objects
		tempInstructor.setCourses(courses);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		//System.out.println("course is "+courses);
		System.out.println("Done!");

	}



	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId=1;
		//find instructor
		System.out.println("Finding instructor id: "+theId);
		//only loads the instructor does not load the courses
		//they are lazy loaded
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		//create the instructor
		Instructor instructor=new Instructor("taki","mohamed","taki@gmail.com");
		//create the instructor details
		InstructorDetails tempInstructorDetails=
				new InstructorDetails("https://www.youtube.com/","Video Games");
		instructor.setInstructorDetails(tempInstructorDetails);
		//create the objects
		Course tempCourse1=new Course("Spring Boot 3, Spring 6 & Hibernate for Beginners");
		Course tempCourse2=new Course("Docker and Kubernetes: The Complete Guide");
		instructor.add(tempCourse1);
		instructor.add(tempCourse2);

		//saving the instructor
		//
		//NOTE:this will Also save the courses
		//because of cascadeType.persist
		//
		System.out.println("saving instructor: "+instructor);
		System.out.println("The Courses: "+instructor.getCourses());
		appDAO.save(instructor);
		System.out.println("DONE !");
	}

	private void deleteInstructorDetails(AppDAO appDAO) {
		int theId=3;
		System.out.println("Deleting instructor details id : "+theId);
		appDAO.deleteInstructorDetailsById(theId);
		System.out.println("Done");
	}

	private void findInstructorDetails(AppDAO appDAO) {
		//get the instructor detail object
		int theId=2;
		InstructorDetails tempInstructorDetails=appDAO.findInstructorDetailsById(theId);
		//print the instructor details
		System.out.println("tempInstructorDetails: "+tempInstructorDetails);
		//print the associated instructor
		System.out.println("the associated instructor: "+tempInstructorDetails.getInstructor());
		System.out.println("Done !");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting instructor id : "+theId);
		appDAO.delete(theId);
		System.out.println("Done !");



	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associate instructorDetail only: "+tempInstructor.getInstructorDetails());
	}

	private void createInstructor(AppDAO appDAO) {
		//create the instructor
		Instructor instructor=new Instructor("Mohamed","osmaa","thelord@gmail.com");
		//create the instructor details
		InstructorDetails tempInstructorDetails=
		   new InstructorDetails("https://www.youtube.com/@BingeCircle","luv");

		//associate the objects
		instructor.setInstructorDetails(tempInstructorDetails);
		//save the instructor
		//NOTE:this will also save the details object
		//because of CascadeType ALL
		//
		System.out.println("saving instructor: "+instructor);
		appDAO.save(instructor);
	}
}
