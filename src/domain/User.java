package domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
	//公有类
	//不带参数的构造方法
	//属性私有
	//属性setter/getter
	private int userId;
	private String userAccount;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private Date lastVisit;
	private String lastIp;
	
	public User(){
		
	}
	
	public User(String userAccount, String firstName, String lastName) {
		this.userAccount = userAccount;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public User(String userAccount, String firstName, String lastName, String password) {
		this(userAccount,firstName,lastName);
		this.password = password;
	}
	public User(String userAccount, String firstName, String lastName, String password, String email) {
		this(userAccount, firstName, lastName, password);
		this.email = email;
		
	}
	
	public String toString() {
		return this.userAccount +", " + this.firstName + " " + lastName +", " + this.email + ".";
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	
}
