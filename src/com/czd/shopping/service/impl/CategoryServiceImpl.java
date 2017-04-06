package com.czd.shopping.service.impl;

import java.util.List;


import com.czd.shopping.pojo.Category;
import com.czd.shopping.service.CategoryService;

public class CategoryServiceImpl extends BaseServiceImpl<Category>
		implements
			CategoryService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> queryByChot(boolean chot) {
		return hibernateTemplate.findByNamedParam(
				"FROM Category c WHERE c.chot=:chot", "chot", chot);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> queryByCtype(String ctype) {
		return hibernateTemplate.findByNamedParam(
				"FROM Category c WHERE c.ctype LIKE :ctype", "ctype",
				"%" + ctype + "%");
	}

}
