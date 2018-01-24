package com.awesome.emk.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awesome.emk.webservice.entities.UserRoleJPA;

public interface UserRoleRepository extends JpaRepository<UserRoleJPA, Long>{
}
