package com.food.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Offer")
public class Price implements Serializable{
	@EmbeddedId
	private ResDish res_dish;
	@Column(name="Price")
	private int Price;
	public Price() {
		
	}
	public void setResDish(ResDish res_dish) {
		this.res_dish = res_dish;
	}
	public ResDish getResDish() {
		return res_dish;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	
	

}
