package com.example.jbased;

import org.springframework.beans.factory.annotation.Value;

public class Course {

	private String courseName;

	public String getCourseName() {
		return courseName;
	}
	@Value("Spring")
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + "]";
	}
	
}
