package com.asta.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asta.app.model.CustomerReview;

public interface CustomerReviewRepository extends JpaRepository<CustomerReview, Long>{
	

}
