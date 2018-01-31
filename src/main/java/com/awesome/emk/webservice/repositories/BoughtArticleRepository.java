package com.awesome.emk.webservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awesome.emk.webservice.entities.BoughtArticleJPA;

public interface BoughtArticleRepository extends JpaRepository<BoughtArticleJPA, Long> {
	List<BoughtArticleJPA> findByName(String name);
	List<BoughtArticleJPA> findByProducer(String producer);
	List<BoughtArticleJPA> findByPrice(float price);
	List<BoughtArticleJPA> findByQuantity(int quantity);
}
