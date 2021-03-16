package com.asta.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private User user;
	private List<Product> products;
	
	public Cart(User user,Product...products) {
		this.user=user;
		this.products=List.of(products);
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
