package com.asta.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.asta.app.model.Product;
import com.asta.app.model.User;

public class CartService {
	
	 @Autowired
	 UserService userService;
	 
	 @Transactional
	 public void addToCart(Product product, User user) {
		Optional<Product> exist= user.getCart().getProducts().stream().filter(
				p->p.getId().equals(product.getId())).findFirst();
		if(exist.isPresent()) {
			exist.get().setQuantity(product.getQuantity()+exist.get().getQuantity());
		}else {
			user.getCart().getProducts().add(product);
		}
		}
	 
	 @Transactional
	 public void removeFromCart(Long id, User user) {
		 Optional<Product> exist= user.getCart().getProducts().stream().filter(
					p->p.getId().equals(id)).findFirst();
		 if(exist.isPresent()) {
			 user.getCart().getProducts().remove(exist.get());
		 }
	 }
	 
	 
	 

}
