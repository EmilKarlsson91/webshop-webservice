package com.awesome.emk.webservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awesome.emk.webservice.entities.ArticleJPA;

public interface ArticleRepository extends JpaRepository<ArticleJPA, Long> {
	List<ArticleJPA> findByName(String name);
	List<ArticleJPA> findByProducer(String producer);
	List<ArticleJPA> findByPrice(float price);
	List<ArticleJPA> findByStock(int stock);
}
