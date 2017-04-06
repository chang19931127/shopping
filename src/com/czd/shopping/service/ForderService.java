package com.czd.shopping.service;

import com.czd.shopping.pojo.Forder;

/**
 * 
 * @author Administrator
 *	订单服务
 */

public interface ForderService extends BaseService<Forder> {
	//根据购物项，计算购物总价
	public double cluFtotal(Forder forder);
}
