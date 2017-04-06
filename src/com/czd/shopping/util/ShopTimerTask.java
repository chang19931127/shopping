package com.czd.shopping.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.czd.shopping.pojo.Category;
import com.czd.shopping.pojo.Goods;
import com.czd.shopping.service.CategoryService;
import com.czd.shopping.service.GoodsService;



/**
 * 
 * @author Administrator
 *	一个工具类，一个         购物 任务    用来同步 
 */
public class ShopTimerTask extends TimerTask {

	private CategoryService categoryService = null;
	private GoodsService goodsService = null;
	private ServletContext application = null;
	
	//提供注入 
	

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public void setApplication(ServletContext application) {
		this.application = application;
	}

	@Override
	public void run() {
		System.out.println("------run----------");
		//这里实现首页数据同步
		//根据热点类别，查询出类别的推荐商品
		//通过list 嵌套list  来实现一个   多维
		List<List<Goods>> bigList = new ArrayList<>();
		for (Category temp : categoryService.queryByChot(true)) {
			bigList.add(goodsService.queryGoodsByCid(temp.getCid()));
		}
		application.setAttribute("bigList", bigList);
	}
}
