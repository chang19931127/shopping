package com.czd.shopping.service;

import java.util.List;

//抽取的service 接口
public interface BaseService<T> {
	public void save(T t);
	public void update(T t);
	public T get(int id);
	public List<T> query();
	public void delete(int id);
}
