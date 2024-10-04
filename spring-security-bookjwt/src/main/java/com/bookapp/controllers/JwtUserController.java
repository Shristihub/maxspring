package com.bookapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.config.JwtTokenUtil;
import com.bookapp.model.JwtUser;
import com.bookapp.service.JwtUserServiceImpl;

@RestController
@RequestMapping("/user-api")
@CrossOrigin("http://localhost:4200")
public class JwtUserController {
	private PasswordEncoder passwordEncoder;
	private JwtUserServiceImpl jwtUserServiceImpl;
	private AuthenticationManager authenticationManager;
	private JwtTokenUtil jwtTokenUtil;
	
	
	
	/**
	 * @param jwtTokenUtil the jwtTokenUtil to set
	 */
	@Autowired
	public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
		this.jwtTokenUtil = jwtTokenUtil;
	}
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	@Autowired
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	/**
	 * @param jwtUserServiceImpl the jwtUserServiceImpl to set
	 */
	@Autowired
	public void setJwtUserServiceImpl(JwtUserServiceImpl jwtUserServiceImpl) {
		this.jwtUserServiceImpl = jwtUserServiceImpl;
	}


	// this is used to authenticate the user
	// if the user is available, then  atoken is generated
	// the response here is the token
	@PostMapping("/authenticate")
	public ResponseEntity<String> loginUser(@RequestBody JwtUser jwtUser) {
		// get the username
		String username = jwtUser.getUsername();
		// call the method to check if the user is available
		UserDetails userDetails = jwtUserServiceImpl.loadUserByUsername(username);
		//generate the token by calling the jwtTokenUtil class and pass userdetails
		String token  = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(token);	
	}
	
	
	@PostMapping("/register")
	public String addUser(@RequestBody JwtUser jwtUser) {
		String password = jwtUser.getPassword();
		jwtUser.setPassword(passwordEncoder.encode(password));
		return jwtUserServiceImpl.registerUser(jwtUser);
		
	}
}
