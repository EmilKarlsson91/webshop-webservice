package com.awesome.emk.webservice.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

@Entity
@Table(name="users")
@Embeddable
public class UserJPA{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private Long id;

	@NotNull
	@Column(name="username")
	private String username;
	
	@NotNull
	@Column
	private String lastName;
	
	@NotNull
	@Column
	private String password;
	
	@NotNull
	@Column
	private boolean enabled;
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public UserRoleJPA getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRoleJPA userRole) {
		this.userRole = userRole;
	}

	@OneToOne(mappedBy="userJPA", cascade = {CascadeType.ALL})
	UserRoleJPA userRole;
	
	public List<OrderJPA> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderJPA> orders) {
		this.orders = orders;
	}

	@OneToMany(mappedBy="userJPA", cascade = {CascadeType.ALL})
	private List<OrderJPA> orders = new ArrayList<OrderJPA>();
	
	public UserJPA() {}
	public UserJPA(String userName, String lastName, String password, boolean enabled) {
		this.username = userName;
		this.lastName = lastName;
		this.password = password;
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
