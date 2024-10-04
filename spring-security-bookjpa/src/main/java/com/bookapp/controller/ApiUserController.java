package com.bookapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.ApiUser;
import com.bookapp.service.ApiUserServiceImpl;

@RestController
@RequestMapping("/user-api/v1")
public class ApiUserController {

	@Autowired
	private ApiUserServiceImpl userServiceImpl;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/users/register")
	public ResponseEntity<String> addUser(@RequestBody ApiUser apiuser) {
		String password = passwordEncoder.encode(apiuser.getPassword());
		apiuser.setPassword(password);
		userServiceImpl.addUser(apiuser);
		return ResponseEntity.status(HttpStatus.CREATED).body("added");
		
	}
	
	
}
