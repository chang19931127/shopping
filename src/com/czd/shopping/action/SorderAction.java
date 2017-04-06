package com.czd.shopping.action;

import com.czd.shopping.pojo.Forder;
import com.czd.shopping.pojo.Sorder;

/**
 * 
 * @author Administrator
 *	购物项的action
 *
 *	有一个执行顺序
 *	先跳转 sorderAction 完成添加购物项，然后跳转ForderAction 完成计算，然后在shopCar显示
 */
public class SorderAction extends BaseAction<Sorder>{

	private static final long serialVersionUID = 1L;
	
	//加入购物车
	public String addSorder(){
		Forder forder = (Forder) session.get("forder");
		//model是 sorder
		forder = sorderService.addSorder(forder, model);
		
		return "demo";
	}
	
	//移除购物项
	public String removeSorder(){
		int gid = model.getGoods().getGid();
		Forder forder = (Forder) session.get("forder");
		forder = sorderService.removeSorder(forder, gid);
		forder.setFtotal(forderService.cluFtotal(forder));
		session.put("forder", forder);
		jsonMap.put("ftotal", forder.getFtotal());
		System.out.println("json demo");
		return "json1";
	}

}
