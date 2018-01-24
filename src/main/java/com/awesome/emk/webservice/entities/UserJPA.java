package com.awesome.emk.webservice.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
@Embeddable
public class UserJPA{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private Long id;
	
	@Column(name="username")
	private String userName;
	
	@Column
	private String lastName;
	
	@Column
	private String password;
	
	@Column
	private boolean enabled;
	
	@OneToOne(mappedBy="userJPA")
	UserRoleJPA userRole;
	
	public UserJPA() {}
	public UserJPA(String userName, String lastName, String password, boolean enabled) {
		this.userName = userName;
		this.lastName = lastName;
		this.password = password;
		this.enabled = enabled;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}
}
