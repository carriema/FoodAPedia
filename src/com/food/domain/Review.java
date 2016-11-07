package com.food.domain;

import java.io.Serializable;

public class Review implements Serializable{
	private User user;
	private ResDish res_dish;
	private String review;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public ResDish getRes_dish() {
		return res_dish;
	}
	public void setRes_dish(ResDish res_dish) {
		this.res_dish = res_dish;
	}
	
}
