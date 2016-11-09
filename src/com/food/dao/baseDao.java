package com.food.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@SuppressWarnings("unchecked")

@Repository
public class baseDao<T>{
	private Class<T> entityClass;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public baseDao() {
		
	}
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	public baseDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	public T load(Serializable id) {
		return (T)getHibernateTemplate().load(entityClass,id);
	}
	
	public T get(Serializable id) {
		return (T)getHibernateTemplate().get(entityClass, id);
	}
	public List<T> loadAll(Serializable id) {
		return (List<T>) getHibernateTemplate().loadAll(entityClass);
	}
	@Transactional
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}
	@Transactional
	public void remove(T entity) {
		getHibernateTemplate().delete(entity);
	}
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}
	public List find(String hql) {
		return this.getHibernateTemplate().find(hql);
	}
	public List find(String hql, Object... values) {
		return this.getHibernateTemplate().find(hql, values);
	}
	public void initialize(Object entity) {
		this.getHibernateTemplate().initialize(entity);
	}
}
