package com.czd.shopping.service.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.czd.shopping.pojo.Category;

public class CategoryServiceImpl {
	private HibernateTemplate hibernateTemplate = null;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void save(Category category){
		hibernateTemplate.save(category);
	}
}
