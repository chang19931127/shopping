package com.czd.shopping.service;

import java.util.List;

import com.czd.shopping.pojo.Category;

public interface CategoryService extends BaseService<Category> {
	
	//��ѯ�ȵ���߷��ȵ����
	public List<Category> queryByChot(boolean chot);

	//���� ctype��ѯ���
	public List<Category> queryByCtype(String ctype);		
}
