package com.awesome.emk.webservice.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class OrderJPA {
	
	public OrderJPA() {}
	public OrderJPA(UserJPA userJPA, List<BoughtArticleJPA> articles, int price) {
		this.userJPA = userJPA;
		this.articles = articles;
		this.price = price;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderid")
	private Long id;

	@Column
	private int price;
	
	public Long getId() {
		return id;
	}

	@OneToMany(mappedBy="orderJPA", cascade = {CascadeType.ALL})
	@Column
	private List<BoughtArticleJPA> articles = new ArrayList<BoughtArticleJPA>();
	
	@ManyToOne
	@JoinColumn(name="userid", referencedColumnName="userid")
	private UserJPA userJPA;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int quantity) {
		this.price = quantity;
	}

	public List<BoughtArticleJPA> getArticles() {
		return articles;
	}

	public void setArticles(List<BoughtArticleJPA> articles) {
		this.articles = articles;
	}

	public UserJPA getUserJPA() {
		return userJPA;
	}

	public void setUserJPA(UserJPA userJPA) {
		this.userJPA = userJPA;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
