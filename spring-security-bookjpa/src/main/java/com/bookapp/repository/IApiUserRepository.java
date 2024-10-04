package com.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.ApiUser;

@Repository
public interface IApiUserRepository extends JpaRepository<ApiUser, Integer>{

	@Query(value = "from ApiUser au inner join au.roles r where au.username=?1")
	ApiUser findByUsername(String username);
}
