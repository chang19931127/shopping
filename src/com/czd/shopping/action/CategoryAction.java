package com.czd.shopping.action;

import com.czd.shopping.pojo.Category;

/**
 * 
 * @author Administrator 1，基本的Action 通过 接口 来获取 域对象 2,前后台所有的数据名词，必要
 *         对象，属性，这样做耦合很高，我们实现一个接口，来解耦
 */
public class CategoryAction extends BaseAction<Category> {

	private static final long serialVersionUID = -432862447038974328L;

	public String save() {
		categoryService.save(model);
		return "main";
	}

}
