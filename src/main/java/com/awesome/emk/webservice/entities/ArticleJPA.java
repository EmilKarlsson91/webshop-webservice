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
@Table(name="articles")
public class ArticleJPA {

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
	private int stock;

	public ArticleJPA() {
	}

	public ArticleJPA(String name, String description, String producer, float price, int stock) {
		this.name = name;
		this.description = description;
		this.producer = producer;
		this.price = price;
		this.stock = stock;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}
}
