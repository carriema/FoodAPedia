package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.dao.LoginLogDao;
import com.food.dao.UserDao;
import com.food.domain.LoginLog;
import com.food.domain.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;
	//Find whether user name exist
	public boolean hasMatch(String userName, String password) {
		Long matchCount= userDao.getMatchCount(userName, password);
		return matchCount > 0;
	}
	public boolean hasUser(String userName) {
		return userDao.hasUserByAccount(userName);
	}
	public User findUserByName(String userName) {
		return userDao.findUserByserAccount(userName);
	}
	public LoginLog GenerateLogin(User user) {
		LoginLog loginLog = new LoginLog();
		loginLog.setLoginDate(user.getLastVisit());
		loginLog.setIp(user.getLastIp());
		loginLog.setUserId(user.getUserId());
		return loginLog;
	}
	@Transactional
	public void loginSuccess(User user) {
		userDao.updateLoginInfo(user);
		loginLogDao.save(GenerateLogin(user));
	}
	//Register
	@Transactional
	public void register(User user) {
		userDao.save(user);
		loginLogDao.save(GenerateLogin(user));
	}
	
}
