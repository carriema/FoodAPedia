package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.food.dao.RestaurantDao;
import com.food.dao.UserDao;

public class SearchService {
	
	@Autowired
	private RestaurantDao restaurantDao;
	
}
