package com.czd.shopping.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.czd.shopping.service.BaseService;
@SuppressWarnings("unchecked")
public  class BaseServiceImpl<T> implements BaseService<T> {

	//ʹ��hibernateTemplate
	protected HibernateTemplate hibernateTemplate = null;
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//��������
	private Class<T> clazz = null;
	
	
	@SuppressWarnings("rawtypes")
	public BaseServiceImpl() {
		//��ȡ��ǰ��ĸ���---------ʹ�÷��䣬��Ϊ�����Ƿ��ͽӿڣ������Ҫ��������ȡ��������
		//����������-----      ͨ���õ����࣬Ȼ��õ�����ķ��ͣ�Ҳ���ǲ��������ͣ�Ȼ��[0]
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
	 * ��ס�����"FORM "��Ϊ��ƴ��String���������һ��ҪԤ���ռ�
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
