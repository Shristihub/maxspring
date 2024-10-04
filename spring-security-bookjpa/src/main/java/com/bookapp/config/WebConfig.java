package com.bookapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.bookapp.service.ApiUserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebConfig {

	// authentication
	@Bean
	public UserDetailsManager userdetails() {
		return new ApiUserServiceImpl();
	}
	
	// passwordEncoder
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	// authentication Provider
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setUserDetailsService(userdetails());
		return authenticationProvider;
	}
	
	
	
	// authorization
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		return http
		.csrf((csrf)->csrf.disable())
		.authorizeHttpRequests((httpRequests)->httpRequests
			.requestMatchers("/book-api/v1/user/**").hasAnyAuthority("ADMIN","USER")
			.requestMatchers("/book-api/v1/admin/**").hasAuthority("ADMIN")
			.requestMatchers("/user-api/v1/users/register").permitAll()
			.anyRequest().authenticated()
		)
		.httpBasic(Customizer.withDefaults())
		.authenticationProvider(authenticationProvider())
		.build();
		
	}
	
}
