package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public boolean hasMatch(String userName, String password) {
		int matchCount= userDao.getMatchCount(userName, password);
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
