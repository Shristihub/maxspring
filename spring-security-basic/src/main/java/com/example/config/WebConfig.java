package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebConfig {
	
	// password encoder
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//authentication
	@Bean
	public UserDetailsManager  userDetails() {
		// creating user objects
		UserDetails user1 =  User.withUsername("Priya")
		   .password(passwordEncoder().encode("priya"))
		   .roles("USER")
		   .build();
		UserDetails user2 = User.withUsername("John")
				.password(passwordEncoder().encode("john"))
				.roles("USER","ADMIN").build();
		
		return new InMemoryUserDetailsManager(user1,user2);
		
	}
	
    // authorization
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		return http
		.csrf((csrf)->csrf.disable())
		.authorizeHttpRequests((httpRequests)->{httpRequests
			.requestMatchers("/api/user/**").hasAnyRole("ADMIN","USER")
			.requestMatchers("/api/admin/**").hasRole("ADMIN")
			.requestMatchers("/api/").permitAll()
			.anyRequest()
			.authenticated();
		})
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.httpBasic(Customizer.withDefaults())
		.build();
		
	}
	
	
}
