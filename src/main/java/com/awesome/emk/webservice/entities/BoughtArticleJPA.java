package com.awesome.emk.webservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="bought_articles")
public class BoughtArticleJPA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="articleid")
	private Long id;

	@NotNull
	@Column(name="articlename")
	private String name;

	@NotNull
	@Column
	private String description;

	@NotNull
	@Column
	private String producer;

	@NotNull
	@Column
	private float price;

	@NotNull
	@Column
	private int quantity;

	@ManyToOne
	@JoinColumn(name="orderid", referencedColumnName="orderid")
	private OrderJPA orderJPA;

	public BoughtArticleJPA() {
	}

	public BoughtArticleJPA(String name, String description, String producer, float price, int quantity) {
		this.name = name;
		this.description = description;
		this.producer = producer;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public OrderJPA getOrderJPA() {
		return orderJPA;
	}

	public void setOrderJPA(OrderJPA orderJPA) {
		this.orderJPA = orderJPA;
	}
}
