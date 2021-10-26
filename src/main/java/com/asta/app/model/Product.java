package com.asta.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	@Column(length = 50000)
	private String description;
	
	private Double price;
	
	private String img;
	
	private List<CustomerReview> comments;
	
	public Product(String title,String description,Double price, CustomerReview... comments) {
		this.title=title;
		this.price=price;
		this.description = description;
		this.comments = List.of(comments);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	public List<CustomerReview> getComments() {
		return comments;
	}

	public void setComments(List<CustomerReview> comments) {
		this.comments = comments;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price + ", img=" + img + "]";
	}


}
