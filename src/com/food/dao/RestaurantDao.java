package com.food.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.food.domain.Restaurant;

@Repository
public class RestaurantDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int getMathCount(String account, String password){
		String sqlStr = "SELECT count(*) from Restaurant WHERE Account = ? and password = ?";
		int res = jdbcTemplate.queryForObject(sqlStr, Integer.class, new Object[]{account, password});
		return res;
	}
	public List<Restaurant> findRestaurantByName(String name){
		String sqlStr = "SELECT * FROM Restaurant WHERE name LIKE ?";
		List<Restaurant> restaurants = new LinkedList<Restaurant>();
		return restaurants;
	}
}
