package com.awesome.emk.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awesome.emk.webservice.entities.UserJPA;

public interface UserRepository extends JpaRepository <UserJPA, Long>{
}
