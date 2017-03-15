package com.czd.shopping.service;

import java.util.List;

//��ȡ��service �ӿ�
public interface BaseService<T> {
	public void save(T t);
	public void update(T t);
	public T get(int id);
	public List<T> query();
	public void delete(int id);
}
