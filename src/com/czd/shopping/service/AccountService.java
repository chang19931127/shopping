package com.czd.shopping.service;

import com.czd.shopping.pojo.Account;

//AccountService
public interface AccountService extends BaseService<Account> {
	//ҵ���߼�			��¼
	public Account login(Account account);
}
