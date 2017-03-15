package com.czd.shopping.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.czd.shopping.service.BaseService;
@SuppressWarnings("unchecked")
public  class BaseServiceImpl<T> implements BaseService<T> {

	//使用hibernateTemplate
	protected HibernateTemplate hibernateTemplate = null;
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//父类事例
	private Class<T> clazz = null;
	
	
	@SuppressWarnings("rawtypes")
	public BaseServiceImpl() {
		//获取当前类的父类---------使用反射，因为我们是泛型接口，因此需要反射来获取父类事例
		//参数化类型-----      通过得到父类，然后得到父类的泛型，也就是参数化类型，然后[0]
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
		System.out.println("-----------------------------"+clazz);
	}

	@Override
	public void save(T t) {
		hibernateTemplate.save(t);
	}

	@Override
	public void update(T t) {
		hibernateTemplate.update(t);
	}

	@Override
	public T get(int id) {
		return    (T) hibernateTemplate.get(clazz, id);
	}

	/*
	 * (non-Javadoc)
	 * 记住这里的"FORM "因为是拼接String，因此我们一定要预留空间
	 */
	@Override
	public List<T> query() {
		return hibernateTemplate.find("FROM "+clazz.getSimpleName());
	}

	@Override
	public void delete(int id) {
		Object o = hibernateTemplate.get(clazz, id);
		if(o != null){
			hibernateTemplate.delete(o);
		}
	}

	
}
