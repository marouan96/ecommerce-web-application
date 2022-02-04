package com.asta.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.asta.app.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
		
	Page<Product> findAllByDepartment(String department,Pageable pageable);

}