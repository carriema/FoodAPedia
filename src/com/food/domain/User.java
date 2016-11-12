package com.food.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Customer")
public class User implements Serializable{
	
	//公有类
	//不带参数的构造方法
	//属性私有
	//属性setter/getter
	@Id
	@GeneratedValue
	@Column(name="Customer_Id")
	private int userId;

	@Column(name="CustomerAccount")
	private String userAccount;
	@Column(name="password")
	private String password;
	@Column(name="last_visit")
	private Date lastVisit;
	@Column(name="last_ip")
	private String lastIp;
	
	public User(){	
	}
//	public User(String userAccount, String firstName, String lastName) {
//		this.userAccount = userAccount;
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}
//	public User(String userAccount, String firstName, String lastName, String password) {
//		this(userAccount,firstName,lastName);
//		this.password = password;
//	}
//	public User(String userAccount, String firstName, String lastName, String password, String email) {
//		this(userAccount, firstName, lastName, password);
//		this.email = email;
//		
//	}
	
	public String toString() {
		return this.userAccount;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
