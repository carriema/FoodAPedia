package com.food.domain;

import java.io.Serializable;
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
@Table(name="Restaurant")
public class Restaurant implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="R_Id")
	private int RID;
	@Column(name="Account")
	private String account;
	@Column(name="Address")
	private String address;
	@Column(name="PhoneNo")
	private String phoneNum;
	@Column(name="password")
	private String password;
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.ALL})
	@JoinTable(name="Offer",
		joinColumns={@JoinColumn(name="R_Id")},
		inverseJoinColumns={@JoinColumn(name="Dish_Id")})
	private Set<Dish> dishes;
	public int getRID() {
		return RID;
	}
	public void setRID(int rID) {
		RID = rID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Dish> getDishes() {
		return dishes;
	}
	public void setDishes(Set<Dish> dishes) {
		this.dishes = dishes;
	}
	public void addDishes(Dish dish) {
		dishes.add(dish);
	}
	
}
