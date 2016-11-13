package com.food.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.food.domain.Dish;
import com.food.domain.Ingredient;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:restaurantsearch.xml"})
public class DishDaoTest {
	@Autowired
	private DishDao dishDao;
	@Test
	public void testGetDish(){
		String ingredient = "chicken";
		List<Object[]> res = dishDao.getDishByIngredient(ingredient);
		assertTrue(res.size() > 0);
		for (Object[] o : res) {
			System.out.println(((Dish)o[0]).getDishName());
			System.out.println(((Ingredient)o[1]).getName());
		}
		
	}
}
