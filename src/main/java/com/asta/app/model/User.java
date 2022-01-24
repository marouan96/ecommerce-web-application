package com.asta.app.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Pattern(regexp = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$")
	@Size(min = 1, max = 50)
	@Column(name = "user_name", length = 50, nullable = false)
	private String userName;

	@Size(max = 50)
	@Column(name = "first_name", length = 50)
	private String firstName;

	@Size(max = 50)
	@Column(name = "last_name", length = 50)
	private String lastName;

	@Email(regexp = "^(.+)@(.+)$")
	@Size(min = 5, max = 200)
	@Column(name = "email", length = 200, unique = true)
	private String email;

	//@Pattern(regexp = "^\\d{10}$")
	@Column(name = "mobile_phone")
	private String MobilePhoneNumber;

	@Column(name = "adress")
	private String address;

	@Column(name = "image_file")
	@Lob
	@JsonIgnore
	private Blob imageFile;

	@Column(name = "image")
	private boolean image;

	@JsonIgnore
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Cart cart;

	@JsonIgnore
	@NotNull
	//@Size(min = 8)
	@Column(name = "password_hash",nullable = false)
	private String password;

	@OneToMany(mappedBy = "user", orphanRemoval = true)
	private List<Order> orders;

	@OneToMany(mappedBy = "user", orphanRemoval = true)
	private List<CustomerReview> reviews;

	@Column(name="user_roles")
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	public User() {
		
	}
	
	public User(String userName,String email, String MobilePhoneNumber,String address,String password,String... roles) {
		this.userName=userName;
		this.email=email;
		this.MobilePhoneNumber=MobilePhoneNumber;
		this.address=address;
		this.password=password;
		this.roles = List.of(roles);
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhoneNumber() {
		return MobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.MobilePhoneNumber = mobilePhoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String Password) {
		this.password = Password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<CustomerReview> getReviews() {
		return reviews;
	}

	public void setReviews(List<CustomerReview> reviews) {
		this.reviews = reviews;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles=roles;
	}

}
