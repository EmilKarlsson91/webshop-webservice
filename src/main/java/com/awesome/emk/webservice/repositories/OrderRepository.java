package com.awesome.emk.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awesome.emk.webservice.entities.OrderJPA;

public interface OrderRepository extends JpaRepository<OrderJPA, Long> {
}
