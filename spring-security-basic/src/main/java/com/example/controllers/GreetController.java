package com.example.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetController {

	@GetMapping("/greet")
	public String greet() {
		return "welcome to Spring ";
	}
	@GetMapping("/user/show-books")
	public List<String> show() {
		return Arrays.asList("Java","Angular");
	}
	@GetMapping("/user/view-cart")
	public String showCart() {
		return "Cart Details";
	}
	@GetMapping("/admin/add")
	public String add() {
		return "book added ";
	}
	@GetMapping("/admin/update")
	public String update() {
		return "book updated ";
	}
}
