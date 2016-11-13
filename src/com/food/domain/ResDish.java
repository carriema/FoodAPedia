package com.food.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable

public class ResDish implements Serializable{
	private int R_Id;
	private int Dish_Id;
	public ResDish() {
	}
	public ResDish(int R_ID, int Dish_Id) {
		this.R_Id = R_Id;
		this.Dish_Id = Dish_Id;	
	}
}
