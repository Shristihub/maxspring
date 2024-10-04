package com.greetapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

//	http://localhost:8080/greet
	@GetMapping("/greet")
	public String greet() {
		return "hello"; // this is not jsp page now, but data send to client
	}
	// retrieving the data from the url
//	http://localhost:8080/welcome/Priya
	
	@GetMapping("/welcome/{username}")
	public String welcomeUser(@PathVariable("username") String user) {
		return "welcome to REST API "+user; // this is not jsp page now, but data send to client
	}
	
	// retrieving the data from the url
//		http://localhost:8080/details?username=priya&city=hassan
	
	@GetMapping("/details")
	public String getDetails(@RequestParam("username") String username,@RequestParam("city")String city) {
		return "welcome "+username + "from "+city; // this is not jsp page now, but data send to client
	}
	
	@GetMapping("/courses")
	public List<String> showCourses(){
		return List.of("Java","ANgular","Micro");
	}
	
//	http://localhost:8080/courses/testing
//	http://localhost:8080/courses/web
	
	@GetMapping("/courses/{type}")
	public List<String> showCoursesByType(@PathVariable("type") String type){
		// check if type is web, return list of courses
		// check if type is  return list of courses
		// check if type is web, return list of courses
		return List.of("Java","Angular","Micro");
	}
}
