package com.asta.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asta.app.model.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{
	

}
