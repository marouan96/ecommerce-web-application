package com.asta.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asta.app.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
	

}