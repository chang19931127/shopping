package com.czd.shopping.service;

import com.czd.shopping.pojo.Account;

//AccountService
public interface AccountService extends BaseService<Account> {
	//ÒµÎñÂß¼­			µÇÂ¼
	public Account login(Account account);
}
