package com.food.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Ingredient")
public class Ingredient implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="Ingredient_Id")
	private int ingredientID;
	@Column(name="Name")
	private String name;
	@Column(name="Origins")
	private String orgins;
	@ManyToMany(mappedBy="ingredient")
	private Set<Dish> dishes;
	public int getIngredientID() {
		return ingredientID;
	}
	public void setIngredientID(int ingredientID) {
		this.ingredientID = ingredientID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrgins() {
		return orgins;
	}
	public void setOrgins(String orgins) {
		this.orgins = orgins;
	}
}
