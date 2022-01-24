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

	public OrderProductEM getEM() {
		return em;
	}

	public void setEM(OrderProductEM em) {
		this.em = em;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((em == null) ? 0 : em.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OrderProduct other = (OrderProduct) obj;
		if (em == null) {
			if (other.em != null) {
				return false;
			}
		} else if (!em.equals(other.em)) {
			return false;
		}

		return true;
	}

}
