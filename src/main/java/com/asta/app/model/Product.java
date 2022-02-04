package com.asta.app.model;

import java.sql.Blob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;

	@Column(length = 10000)
	private String description;

	private Double price;
	
	@Column(name="department")
    private String department;
	
	@Column(name = "quantity_in_stock")
	private Integer quantity;

	@Column(name = "image_file")
	@Lob
	@JsonIgnore
	private Blob imageFile;

	@Column(name = "image")
	private boolean image;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<CustomerReview> comments;
	
	public Product() {
	}

	public Product(String title, Integer quantity, String description, Double price
			,String department) {
		this.title = title;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.department=department;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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
