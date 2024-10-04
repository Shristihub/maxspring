package com.bookapp.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.bookapp.model.ApiUser;
import com.bookapp.repository.IApiUserRepository;

@Service
public class ApiUserServiceImpl implements UserDetailsManager {
	
	@Autowired
	private IApiUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		ApiUser apiUser = userRepository.findByUsername(username);
		System.out.println(apiUser);
		if(apiUser==null)
			throw new UsernameNotFoundException("username not found");
		Set<String> roles = apiUser.getRoles();
		List<SimpleGrantedAuthority> authorities = roles.stream().map(role->new SimpleGrantedAuthority(role)).toList();
		System.out.println(authorities);
		UserDetails userDetails = new User(apiUser.getUsername(), apiUser.getPassword(), authorities);
		return userDetails;
	}

	@Override
	public void createUser(UserDetails userdetails) {
	}

	public void addUser(ApiUser user) {
		userRepository.save(user);
	}
	
	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
