package com.awesome.emk.webservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class UserRoleJPA{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="roleid")
	private Long id;

	@OneToOne
	@JoinColumn(name="username", referencedColumnName="username")
	private UserJPA userJPA;
	
	@Column
	private String role;
	
	public UserRoleJPA() {}
	public UserRoleJPA(UserJPA userJPA, String role) {
		this.userJPA = userJPA;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
