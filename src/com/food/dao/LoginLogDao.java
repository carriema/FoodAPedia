package com.food.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.food.domain.LoginLog;

@Repository
public class LoginLogDao extends baseDao<LoginLog>{
	
	public LoginLogDao() {
		super(LoginLog.class);
	}
	
}
