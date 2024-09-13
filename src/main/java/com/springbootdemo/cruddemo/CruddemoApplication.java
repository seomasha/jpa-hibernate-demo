package com.springbootdemo.cruddemo;

import com.springbootdemo.cruddemo.dao.StudentDAO;
import com.springbootdemo.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating a student...");
		Student student = new Student("Sead", "Masetic", "sead@masetic.com");

		System.out.println("Saving user inside the DB...");
		studentDAO.save(student);

		System.out.println("Saved user inside the DB!");
		System.out.println("Generated ID of student: " + student.getId());
	}
}