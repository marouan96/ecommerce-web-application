package com.asta.app.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerReview {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private User user;
    private Integer stars;
    private String text;
    
    public CustomerReview(User user, Integer stars, String text) {
		this.user=user;
    	this.stars=stars;
		this.text=text;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
