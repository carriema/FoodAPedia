package com.food.domain;

import javax.persistence.Embeddable;

@Embeddable
public class ResDish {
	private int R_Id;
	private int Dish_Id;
	public ResDish() {
	}
	public ResDish(int R_ID, int Dish_Id) {
		this.R_Id = R_Id;
		this.Dish_Id = Dish_Id;	
	}
}
