package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LoginLogDao;
import dao.UserDao;
import domain.LoginLog;
import domain.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;
	
	public boolean hasMatch(String userName, String password) {
		int matchCount= userDao.getMathCount(userName, password);
		return matchCount > 0;
	}
	public User findUserByName(String userName) {
		return userDao.findUserByserAccount(userName);
	}
	public void loginSuccess(User user) {
		LoginLog loginLog = new LoginLog();
		loginLog.setLoginDate(user.getLastVisit());
		loginLog.setIp(user.getLastIp());
		loginLog.setUserId(user.getUserId());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoging(loginLog);
	}
}
