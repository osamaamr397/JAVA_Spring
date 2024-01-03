package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
	//command line is from spring boot framework
	// CommandLineRunner executed after the spring Beans have been loaded
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//QueryForStudents(studentDAO);
			//QueryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};

	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count "+numRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		System.out.println("Deleting student with id "+studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId=1;
		System.out.println("Getting student with id: "+studentId);
		Student tempStudent=studentDAO.findById(studentId);
		//change first name to anything
		System.out.println("Updating student...");
		tempStudent.setFirstName("brooza");
		//update the student
		studentDAO.update(tempStudent);
		//display the updated student
		System.out.println("updated student "+tempStudent);
	}

	private void QueryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student>theStudents=studentDAO.findByLastName("osama");
		//display that list of students
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void QueryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student>theStudents=studentDAO.finaAll();
		//display a list of students
		for (Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	public void createStudent(StudentDAO studentDAO){
		//create the student object
		System.out.println("creating new student object ");
		Student tempStudent=new Student("amr","osama","osamaamr397@gmial.com");
		//save the student object
		System.out.println("saving the student ...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("save student with id: "+tempStudent.getId());
	}
	public void createMultipleStudent(StudentDAO studentDAO){
		//create 3 students objects
		System.out.println("creating 3 students objects ");
		Student tempStudent1=new Student("mohamed","osama","mohamed397@gmial.com");
		Student tempStudent2=new Student("Bassem","osama","bassem397@gmial.com");
		Student tempStudent3=new Student("otaka","osama","otaka397@gmial.com");

		//saving the students objects
		System.out.println("saving the students ....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		//display ids of the saved students
		System.out.println("save student with id: "+tempStudent1.getId());
		System.out.println("save student with id: "+tempStudent2.getId());
		System.out.println("save student with id: "+tempStudent3.getId());
	}
	private void readStudent(StudentDAO studentDAO){
		//create student object
		System.out.println("creating new student object ...");
		Student tempStudent = new Student("elslsti","ahmed","anything@gmail.com");
		//save student
		System.out.println("saving the student...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		int theId=tempStudent.getId();
		System.out.println("saved student Id is: "+theId);

		//retrieve student based on the id : primary key
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent=studentDAO.findById(theId);
		//display student
		System.out.println("Found the student: "+myStudent);
	}

}
