package com.czd.shopping.action;

import com.czd.shopping.pojo.Category;

/**
 * 
 * @author Administrator 1��������Action ͨ�� �ӿ� ����ȡ ����� 2,ǰ��̨���е��������ʣ���Ҫ
 *         �������ԣ���������Ϻܸߣ�����ʵ��һ���ӿڣ�������
 */
public class CategoryAction extends BaseAction<Category> {

	private static final long serialVersionUID = -432862447038974328L;

	public String save() {
		categoryService.save(model);
		return "main";
	}

}
