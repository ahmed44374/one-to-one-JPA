package com.example.demo;

import com.example.demo.model.Instructor;
import com.example.demo.model.InstructorDetail;
import com.example.demo.repository.AppRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppRepo appRepo) {
		return runner -> {
			createInstructor(appRepo);
		};
	}
	private void createInstructor(AppRepo appRepo) {
		Instructor instructor = new Instructor("Ahmed","ehab","ahmed@test.com");
		InstructorDetail instructorDetail = new InstructorDetail("moda/youtube","programming");
		instructor.setInstructorDetail(instructorDetail);
		appRepo.save(instructor);
	}
}
