package com.bookapp.model;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JwtUser {

	
	private String username;
	private String email;
	@Id
	@GeneratedValue
	private Integer userId;
	private String password;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="jwtuser_authorities",
	joinColumns = @JoinColumn(name="user_id"))
	private Set<String> authorities;
	
	
	
	
}
