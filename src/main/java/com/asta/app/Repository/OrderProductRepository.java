package com.asta.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asta.app.model.OrderProduct;
import com.asta.app.model.OrderProductEM;

public interface OrderProductRepository extends JpaRepository<OrderProduct,OrderProductEM> {

}
