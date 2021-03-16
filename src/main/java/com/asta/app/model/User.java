package com.asta.app.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private Integer MobilePhoneNumber;
	@JsonIgnore
	private String password;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	public User(String name,String email ,Integer number,String Password, String... roles) {
		this.name = name;
		this.email=email;
		this.MobilePhoneNumber=number;
		this.password = Password;
		this.roles = List.of(roles);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMobilePhoneNumber() {
		return MobilePhoneNumber;
	}
	public void setMobilePhoneNumber(Integer mobilePhoneNumber) {
		this.MobilePhoneNumber = mobilePhoneNumber;
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
	
}
