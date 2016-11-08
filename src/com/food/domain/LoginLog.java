package com.food.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_login_log")
public class LoginLog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="login_log_id")
	private int LoginLogId;
	@Column(name="user_id")
	private int userId;
	@Column(name="ip")
	private String ip;
	@Column(name="login_datetime")
	private Date loginDate;
	public int getLoginLogId() {
		return LoginLogId;
	}
	public void setLoginLogId(int loginLogId) {
		LoginLogId = loginLogId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
