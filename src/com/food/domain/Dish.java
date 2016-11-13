package com.food.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Dish")
public class Dish implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="Dish_Id")
	private int dishID;
	@Column(name="Name")
	private String dishName;
	@Column(name="Genre")
	private String genre;
	@ManyToMany(mappedBy="dishes")
	private Set<Restaurant> restaurants;
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.ALL})
	@JoinTable(name="Cuisine",
			joinColumns={@JoinColumn(name="Dish_Id")},
			inverseJoinColumns={@JoinColumn(name="Ingredient_Id")})
	private Set<Ingredient> ingredient;
	public int getDishID() {
		return dishID;
	}
	public void setDishID(int dishID) {
		this.dishID = dishID;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Set<Ingredient> getIngredient() {
		return ingredient;
	}
	public void setIngredient(HashSet<Ingredient> ingredient) {
		this.ingredient = ingredient;
	}
	public void addIngredient(Ingredient ingre) {
		ingredient.add(ingre);
	}
}
