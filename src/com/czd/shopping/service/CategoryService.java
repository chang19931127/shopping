package com.czd.shopping.service;

import java.util.List;

import com.czd.shopping.pojo.Category;

public interface CategoryService extends BaseService<Category> {
	
	//查询热点或者非热点类别
	public List<Category> queryByChot(boolean chot);

	//根据 ctype查询类别
	public List<Category> queryByCtype(String ctype);		
}
