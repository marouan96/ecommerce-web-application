package com.asta.app.model;

import java.sql.Blob;
import java.util.List;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	@Column(length = 50000)
	private String description;
	
	private Double price;
	
	
    @Column(name = "quantity_in_stock")
    private Integer quantity;
	
	@Column(name = "image_file")
	@Lob
	@JsonIgnore
	private Blob imageFile;

	@Column(name = "image")
	private boolean image;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
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
	
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Blob getImageFile() {
		return imageFile;
	}

	public void setImageFile(Blob image) {
		this.imageFile = image;
	}

	public boolean getImage() {
		return this.image;
	}

	public void setImage(boolean image) {
		this.image = image;
	}
	
	public List<CustomerReview> getComments() {
		return comments;
	}

	public void setComments(List<CustomerReview> comments) {
		this.comments = comments;
	}
	
	


}
