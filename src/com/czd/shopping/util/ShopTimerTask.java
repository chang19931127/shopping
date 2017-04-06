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
 *	һ�������࣬һ��         ���� ����    ����ͬ�� 
 */
public class ShopTimerTask extends TimerTask {

	private CategoryService categoryService = null;
	private GoodsService goodsService = null;
	private ServletContext application = null;
	
	//�ṩע�� 
	

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
		//����ʵ����ҳ����ͬ��
		//�����ȵ���𣬲�ѯ�������Ƽ���Ʒ
		//ͨ��list Ƕ��list  ��ʵ��һ��   ��ά
		List<List<Goods>> bigList = new ArrayList<>();
		for (Category temp : categoryService.queryByChot(true)) {
			bigList.add(goodsService.queryGoodsByCid(temp.getCid()));
		}
		application.setAttribute("bigList", bigList);
	}
}
