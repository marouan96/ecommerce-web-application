package com.asta.app.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CustomerReview {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="user_id")
	private User user;
	
	@JsonIgnore
	@JoinColumn(name ="product_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	
	@Column(name = "stars")
    private Integer stars;
    
	@Column(name = "descitption")
    private String description;
    
	 @JsonFormat(pattern = "dd/MM/yyyy") 
	 private LocalDate dateCreated;
	 
    public CustomerReview(User user, Integer stars, String description) {
		this.user=user;
    	this.stars=stars;
		this.description=description;
	}
    
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String text) {
		this.description = text;
	}
	
	
	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
