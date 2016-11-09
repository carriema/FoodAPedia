package com.food.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.food.domain.User;

@Repository
public class UserDao extends baseDao<User>{
	public UserDao(){
		super(User.class);
	}
	public Long getMatchCount(String userName, String password){
		System.out.println("getHere");
		String sqlStr = "SELECT count(*) from User WHERE userAccount = ? and password = ?";
		Object[] params = {userName, password};
		//List res1 = jdbcTemplate.queryForObject(sqlStr, Integer.class, new Object[]{userName, password});
		 List res = getHibernateTemplate().find(sqlStr, params);
		return (Long) res.get(0);
	}
	public boolean hasUserByAccount(String userAccount) {
		String sql = "Select count(*) FROM User WHERE userAccount = ?";
		Object[] params = {userAccount};
		List res = getHibernateTemplate().find(sql, params);
		return ((Long)res.get(0) > 0);
	}
	public User findUserByserAccount(String userAccount) {
//		User user = super.get(userAccount);
		String sql = "FROM User WHERE userAccount = ?";
		Object[] params = {userAccount};
		List res = getHibernateTemplate().find(sql, params);
		return (User)res.get(0);
	}
	@Transactional
	public void updateLoginInfo(User user) {
		getHibernateTemplate().update(user);
	}

}
