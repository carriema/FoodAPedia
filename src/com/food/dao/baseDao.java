package com.food.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class baseDao<T> {
	private Class<T> entityClass;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@SuppressWarnings("unchecked")
	public baseDao() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	public T load(Serializable id) {
		return (T)getHibernateTemplate().load(entityClass,id);
	}
	public T get(Serializable id) {
		return (T)getHibernateTemplate().get(entityClass, id);
	}
}
