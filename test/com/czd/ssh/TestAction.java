package com.czd.ssh;

import com.czd.shopping.service.CategoryService;

public class TestAction {
	private CategoryService categoryService = null;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public String test(){
		System.out.println("Test Action ≤‚ ‘≥…π¶"+categoryService);
		return "success";
	}
}
