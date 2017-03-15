package com.czd.shopping.action;

import java.util.List;

import com.czd.shopping.pojo.Account;

/**
 * 
 * @author Administrator
 *	1��������Action ͨ�� �ӿ� ����ȡ �����
 *	2,ǰ��̨���е��������ʣ���Ҫ �������ԣ���������Ϻܸߣ�����ʵ��һ���ӿڣ�������
 */
public class AccountAction extends BaseAction<Account> {

	private static final long serialVersionUID = -432862447038974328L;
	
	public String save(){
		accountService.save(model);
		return "main";
	}
	
	public String query(){
		List<Account> accounts = accountService.query();
		//�ܴ洢�� request �ͱ�洢��session��
		request.put("accounts", accounts);
		return "queryAccount";
	}
	
	public String get(){
		request.put("account", accountService.get(model.getAid()));
		return "updateAccount";
	}
	
	public String delete(){
		accountService.delete(model.getAid());
		//ɾ����ϣ���ѯʣ�������
		List<Account> accounts = accountService.query();
		request.put("accounts", accounts);
		return "queryAccount";
	}
	
	public String update(){
		accountService.update(model);
		return "main";
	}
	
}
