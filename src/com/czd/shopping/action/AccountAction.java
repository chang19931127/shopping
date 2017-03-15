package com.czd.shopping.action;

import java.util.List;

import com.czd.shopping.pojo.Account;

/**
 * 
 * @author Administrator
 *	1，基本的Action 通过 接口 来获取 域对象
 *	2,前后台所有的数据名词，必要 对象，属性，这样做耦合很高，我们实现一个接口，来解耦
 */
public class AccountAction extends BaseAction<Account> {

	private static final long serialVersionUID = -432862447038974328L;
	
	public String save(){
		accountService.save(model);
		return "main";
	}
	
	public String query(){
		List<Account> accounts = accountService.query();
		//能存储到 request 就别存储到session中
		request.put("accounts", accounts);
		return "queryAccount";
	}
	
	public String get(){
		request.put("account", accountService.get(model.getAid()));
		return "updateAccount";
	}
	
	public String delete(){
		accountService.delete(model.getAid());
		//删除完毕，查询剩余的数据
		List<Account> accounts = accountService.query();
		request.put("accounts", accounts);
		return "queryAccount";
	}
	
	public String update(){
		accountService.update(model);
		return "main";
	}
	
}
