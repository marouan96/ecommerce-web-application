package com.asta.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asta.app.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
