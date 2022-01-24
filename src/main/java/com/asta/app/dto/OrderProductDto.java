package com.asta.app.dto;

import com.asta.app.model.Product;

public class OrderProductDto {

	private Product product;
	   
    private Integer quantity;

    @Override
	public String toString() {
		return "OrderProductDto [product=" + product + ", quantity=" + quantity + "]";
	}

	public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
