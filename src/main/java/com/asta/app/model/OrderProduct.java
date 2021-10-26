package com.asta.app.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderProduct {

	@EmbeddedId
    @JsonIgnore
    private OrderProductEM em;
	
	 @Column(nullable = false) 
	 private Integer quantity;
	 
	 public OrderProduct(Order order, Product product, Integer quantity) {
		 em = new OrderProductEM();
		 em.setOrder(order);
		 em.setProduct(product);
	     this.quantity = quantity;
	    }
	 
	   @Transient
	    public Product getProduct() {
	        return this.em.getProduct();
	    }

	    @Transient
	    public Double getTotalPrice() {
	        return getProduct().getPrice() * getQuantity();
	    }

	    public OrderProductEM getPk() {
	        return em;
	    }

	    public void setPk(OrderProductEM em) {
	        this.em = em;
	    }

	    public Integer getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }


}
