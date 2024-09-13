package com.springbootdemo.cruddemo;

import com.springbootdemo.cruddemo.dao.StudentDAO;
import com.springbootdemo.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			readStudentByLastName(studentDAO, "Masetic");
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating a student...");
		Student student = new Student("Zijad", "Masetic", "zijad@masetic.com");

		System.out.println("Saving user inside the DB...");
		studentDAO.save(student);

		System.out.println("Saved user inside the DB!");
		System.out.println("Generated ID of student: " + student.getId());
	}

	private void readStudent(StudentDAO studentDAO, Integer id) {
		System.out.println("Finding the user with the entered ID of: " + id);

		Student foundStudent = studentDAO.findByID(id);

		System.out.println(foundStudent);
	}

	private void readStudents(StudentDAO studentDAO) {
		System.out.println("Fetching all users from the DB...");

		List<Student> students = studentDAO.findAll();

		for(Student student: students) {
			System.out.println(student);
		}
	}

	private void readStudentByLastName(StudentDAO studentDAO, String lastName) {
		System.out.println("Fetching users by the last name: " + lastName);

		List<Student> students = studentDAO.findByLastName(lastName);

		for(Student student : students) {
			System.out.println(student);
		}
	}
}