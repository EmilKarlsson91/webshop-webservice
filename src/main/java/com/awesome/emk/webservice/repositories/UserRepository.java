package com.awesome.emk.webservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awesome.emk.webservice.entities.UserJPA;

public interface UserRepository extends JpaRepository <UserJPA, Long>{
	List<UserJPA> findByUsername(String username);
}
