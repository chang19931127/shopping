package com.czd.shopping.action;

import com.czd.shopping.service.impl.CategoryServiceImpl;

public class TestAction {
	private CategoryServiceImpl categoryServiceImpl = null;

	public void setCategoryServiceImpl(CategoryServiceImpl categoryServiceImpl) {
		this.categoryServiceImpl = categoryServiceImpl;
	}
	
	public String test(){
		System.out.println("Test Action ≤‚ ‘≥…π¶"+categoryServiceImpl);
		return "success";
	}
}
