package com.bookapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bookapp.service.JwtUserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebConfig {

	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private JwtRequestFilter jwtRequestFilter;

	/**
	 * @param jwtAuthenticationEntryPoint the jwtAuthenticationEntryPoint to set
	 */
	@Autowired
	public void setJwtAuthenticationEntryPoint(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
	}

	/**
	 * @param jwtRequestFilter the jwtRequestFilter to set
	 */
	@Autowired
	public void setJwtRequestFilter(JwtRequestFilter jwtRequestFilter) {
		this.jwtRequestFilter = jwtRequestFilter;
	}

	@Bean
	UserDetailsService userDetails() {
		return new JwtUserServiceImpl();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
				   .authorizeHttpRequests(httpRequests -> {httpRequests
						//donot authenticate these urls
					.requestMatchers("/user-api/register", "/user-api/authenticate").permitAll()
					.anyRequest()
					.authenticated();
				   })
				  // use Jwtauthenticationentry point to send errors
				 .exceptionHandling(configurer->configurer.authenticationEntryPoint(jwtAuthenticationEntryPoint))
				 // session is stateless here - do not handle session
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				// move to the filter in the flow
				// the requestfilter will be called before usernamepasswordfilter
				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	
	}

}
