package com.bookapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	
	@RequestMapping("/signin")
	public String showLoginPage() {
		return "loginpage";
	}
	@RequestMapping("/login")
	public String showAdminDashboard(
			@RequestParam("username")String username,
			@RequestParam("password")String password,
			Model model) {
		if(username.equals("admin")&& password.equals("admin"))
			return "admin";
		else {
			model.addAttribute("message", "wrong username or password");
		    return "loginpage";
		}
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("/addform")
	public String showAddForm() {
		return "addform"; //this is the jsp page name
	}
	
	@RequestMapping("/deleteform")
	public String showDeleteForm() {
		return "deleteform"; //this is the jsp page name
	}
	@RequestMapping("/editform")
	public String showEditForm() {
		return "editform"; //this is the jsp page name
	}
}
