package com.employeeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employeeapp.model.Employee;

@Controller
public class EmployeeController {

	@RequestMapping("add-form")
	public String home() {
		return "addempform";
	}
	@RequestMapping("add-employee")
	public String addEmployee(Employee employee, Model model) {
		model.addAttribute("employee", employee);
		return "empsuccess";
	}
}
