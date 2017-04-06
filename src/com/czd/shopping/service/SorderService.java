package com.czd.shopping.service;

import com.czd.shopping.pojo.Forder;
import com.czd.shopping.pojo.Sorder;

/**
 * 
 * @author Administrator 购物项
 */
public interface SorderService extends BaseService<Sorder> {
	//购物项添加到购物车中，并且判断重复
	public Forder addSorder(Forder forder, Sorder sorder);
	//删除指定购物项
	public Forder removeSorder(Forder forder, int gid);
}
