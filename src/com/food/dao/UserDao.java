package com.food.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.food.domain.User;

@Repository
public class UserDao extends baseDao<User>{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int getMatchCount(String userName, String password){
		String sqlStr = "SELECT count(*) from Customer WHERE CustomerAccount = ? and password = ?";
		int res = jdbcTemplate.queryForObject(sqlStr, Integer.class, new Object[]{userName, password});
		return res;
	}
	public User findUserByserAccount(String userAccount) {
		String sql = "Select Customer_Id, CustomerAccount, FirstName, LastName, password FROM Customer WHERE CustomerAccount = ?";
		final User user = new User();
		jdbcTemplate.query(sql, new Object[]{userAccount},
				new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException{
				user.setUserAccount(userAccount);
				user.setUserId(rs.getInt("Customer_Id"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
			}
		});
		return user;
	}
	public void updateLoginInfo(User user) {
		String sql = "UPDATE Customer SET last_visit = ?, last_ip = ? where Customer_Id = ?";
		jdbcTemplate.update(sql, new Object[]{user.getLastVisit(), user.getLastIp(),user.getUserId()});
	}

}
