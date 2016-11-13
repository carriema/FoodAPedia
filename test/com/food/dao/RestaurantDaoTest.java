package com.food.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.food.domain.Restaurant;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:restaurantsearch.xml"})
public class RestaurantDaoTest {

	@Autowired
	private RestaurantDao restaurantDao;
	
	@Test
	public void testFindRestaurantByResName() {
		String name = "Chuan";
		
		List<Restaurant> restaurants = restaurantDao.findRestaurantByResName(name);
		System.out.println(restaurants.size());
		boolean contains = false;
		for (int i = 0; i < restaurants.size(); i++) {
			System.out.println(restaurants.get(i).getName());
			if (restaurants.get(i).getName().equals("Chuan Shabu")) {
				contains = true;
			}
		}
		assertTrue(contains);
	}
	@Test
	public void testFindRestaurantByResAcc() {
		String name = "Chua";
		List<Restaurant> restaurants = restaurantDao.findRestaurantByResAcc(name);
		assertTrue(restaurants.size() > 0);
		for (int i = 0; i < restaurants.size(); i++) {
			System.out.println(restaurants.get(i).getName());
		}
	}
	@Test
	public void testGetRestaurantById()
	{
		int id = 1;
		Restaurant res = restaurantDao.get(id);
		assertEquals(res.getAccount(),"Chua");
		
	}
	

}
