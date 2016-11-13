package com.food.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.food.domain.Dish;
@Repository
public class DishDao extends baseDao<Dish>{
	public DishDao() {
		super(Dish.class);
	}
	public List getDishByIngredient(String name) {
		String hql = "From Dish d join d.ingredient i where i.name like ? ";
		name = "%" + name + "%";
		Object[] params = {name};
		List dishes = getHibernateTemplate().find(hql, name);
		return dishes;
	}
}
