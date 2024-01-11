package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			deleteInstructor(appDAO);
		};
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
