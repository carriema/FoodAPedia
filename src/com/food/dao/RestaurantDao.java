package com.food.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.food.domain.Restaurant;

@Repository
public class RestaurantDao extends baseDao<Restaurant>{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String findByName = "SELECT * FROM Restaurant WHERE name LIKE ?";
	//private final String findByDishName = "SELECT"
	public int getMathCount(String account, String password){
		String sqlStr = "SELECT count(*) from Restaurant WHERE Account = ? and password = ?";
		int res = jdbcTemplate.queryForObject(sqlStr, Integer.class, new Object[]{account, password});
		return res;
	}
	public List<Restaurant> findRestaurantByResName(String name) {
		List<Restaurant> restaurants = findRestaurantByName(findByName, name);
		return restaurants;
	}
	public List<Restaurant> findRestaurantByName(String sql, String name){
		List<Restaurant> restaurants = new LinkedList<Restaurant>();
		jdbcTemplate.query(sql, new Object[]{name},
				new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException{
				while (rs.next()) {
					Restaurant restaurant = new Restaurant();
					restaurant.setRID(rs.getInt("R_Id"));
					restaurant.setAddress(rs.getString("Address"));
					restaurant.setAccount(rs.getString("Account"));
					restaurant.setPhoneNum(rs.getString("PhoneNo"));
					restaurants.add(restaurant);
				}
			}
		});
		return restaurants;
	}
//	public List<Restaurant> findRestaurantByDishName(String name) {
//		List<Restaurant> restaurants = findRestaurantByName(findByDishName, name);
//		return restaurants;
//	}
}
