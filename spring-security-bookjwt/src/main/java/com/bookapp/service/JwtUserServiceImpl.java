package com.bookapp.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bookapp.model.JwtUser;
import com.bookapp.repository.IJwtUserRepository;

@Service
public class JwtUserServiceImpl implements UserDetailsService {
	
	private IJwtUserRepository iJwtUserRepository; 
	@Autowired
	public void setiJwtUserRepository(IJwtUserRepository iJwtUserRepository) {
		this.iJwtUserRepository = iJwtUserRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtUser jwtUser =  iJwtUserRepository.findByUsername(username);
		if(jwtUser==null)
			throw new UsernameNotFoundException("invalid username ");
		String uname = jwtUser.getUsername();
		String password = jwtUser.getPassword();
		Set<String> authorities = jwtUser.getAuthorities();
		List<GrantedAuthority> grantedAutorities= authorities.stream()
					.map(authority->new SimpleGrantedAuthority(authority)) // convert string into grantedauthority
					.collect(Collectors.toList());
		UserDetails user = new User(uname, password, grantedAutorities);
		return user;
	}
	
	public String registerUser(JwtUser jwtUser) {
		iJwtUserRepository.save(jwtUser);
		return "added";
	}

}
