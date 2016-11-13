package com.food.dao;

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
	
	public RestaurantDao() {
		super(Restaurant.class);
	}
//	public int getMathCount(String account, String password){
//		String sqlStr = "SELECT count(*) from Restaurant WHERE Account = ? and password = ?";
//		int res = jdbcTemplate.queryForObject(sqlStr, Integer.class, new Object[]{account, password});
//		return res;
//	}
	public List findRestaurantByResName(String name) {
		String findByName = "FROM Restaurant as r WHERE r.name LIKE ?"; 
		name = "%" + name + "%";
		Object[] params = {name};
		List restaurants = getHibernateTemplate().find(findByName, params);
		return restaurants;
	}
	public List findRestaurantByResAcc(String acc) {
		String findByName = "FROM Restaurant WHERE account = ?"; 
//		acc = "%" + acc + "%";
		Object[] params = {acc};
		List restaurants = getHibernateTemplate().find(findByName, params);
		return restaurants;
	}
	@SuppressWarnings("rawtypes")
	public List findRestaurantByDishName(String name) {
		String findByDish = "from restaurant r inner join r.dishes where dishes.name like ?";
		Object[] params = {name};
		List restaurants = getHibernateTemplate().find(findByDish, params);
		return restaurants;
	}
	
}
