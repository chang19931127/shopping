package com.czd.shopping.service;

import com.czd.shopping.pojo.Forder;

/**
 * 
 * @author Administrator
 *	��������
 */

public interface ForderService extends BaseService<Forder> {
	//���ݹ�������㹺���ܼ�
	public double cluFtotal(Forder forder);
}
