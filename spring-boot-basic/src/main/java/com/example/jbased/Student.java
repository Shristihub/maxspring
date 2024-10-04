package com.example.jbased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Student {
	private String studentName;
	private String city;
	
	private Course course;
	
	public Course getCourse() {
		return course;
	}
//	@Autowired
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getStudentName() {
		return studentName;
	}
	@Value("Ronnie")
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCity() {
		return city;
	}
	@Value("Mysore")
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", city=" + city + "]";
	}
	

}
