package com.czd.shopping.service;

import com.czd.shopping.pojo.Forder;
import com.czd.shopping.pojo.Sorder;

/**
 * 
 * @author Administrator ������
 */
public interface SorderService extends BaseService<Sorder> {
	//��������ӵ����ﳵ�У������ж��ظ�
	public Forder addSorder(Forder forder, Sorder sorder);
	//ɾ��ָ��������
	public Forder removeSorder(Forder forder, int gid);
}
