package com.luv2code.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
this will be used if i make util package
@SpringBootApplication(
		//without this when I run the code will give me application failed to start
		//as there is no coach bean in demo controller as Coach Interface and CricketCoach class
		//not exist in the same package which is springcoredemo

		scanBasePackages = {"com.luv2code.springcoredemo",
				"com.luv2code.util"})
*/
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
