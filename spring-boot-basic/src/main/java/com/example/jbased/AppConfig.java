package com.example.jbased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

	// add bean definitions
	@Bean
	public Student getStudent() {
		Student student = new Student();
		student.setCourse(getCourse());
		return student;
	}
	
	@Bean
	public Course getCourse() {
		return new Course();
	}
}
