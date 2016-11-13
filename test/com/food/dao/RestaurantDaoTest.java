package com.food.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.food.domain.Dish;
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
	@Test
	public void testFindRestaurantByDishName() {
		String name = "pizza";
		List<Object[]> restaurants = restaurantDao.findRestaurantByDishName(name);
		assertTrue(restaurants.size() > 0);
		System.out.println(restaurants.size());
		System.out.println(restaurants.get(0)[0]);
		
		for (int i = 0; i < restaurants.size(); i++) {
			Restaurant res = (Restaurant)restaurants.get(i)[0];
			Dish dis = (Dish) restaurants.get(i)[1];
			System.out.println(res.getName());
			System.out.println(dis.getDishName());
		}
	}
	@Test
	public void testFindRestaurantByGenre() {
		String name = "chuan";
		List<Object[]> restaurants = restaurantDao.findRestaurantByGenre(name);
		assertTrue(restaurants.size() > 0);
		System.out.println(restaurants.size());		
		for (int i = 0; i < restaurants.size(); i++) {
			Restaurant res = (Restaurant)restaurants.get(i)[0];
			Dish dis = (Dish) restaurants.get(i)[1];
			System.out.println(res.getName());
			System.out.println(dis.getGenre());
		}
	}
	@Test
	public void testGetMatch(){
		String acc = "Chua";
		String password = "0000";
		assertTrue(restaurantDao.getMatchCount(acc, password)> 0);
	}
	@Test
	public void testGetDishes() {
		
	}
	

}
