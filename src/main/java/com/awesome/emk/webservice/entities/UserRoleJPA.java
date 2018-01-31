package com.awesome.emk.webservice.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user_roles")
public class UserRoleJPA{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="roleid")
	private Long id;

	@OneToOne
	@JoinColumn(name="userid", referencedColumnName="userid")
	private UserJPA userJPA;
	
	@NotNull
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
