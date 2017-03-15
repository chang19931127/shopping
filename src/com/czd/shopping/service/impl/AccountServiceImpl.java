package com.czd.shopping.service.impl;

import java.util.List;
import com.czd.shopping.pojo.Account;
import com.czd.shopping.service.AccountService;

@SuppressWarnings("unchecked")
public class AccountServiceImpl extends BaseServiceImpl<Account>
		implements
			AccountService {

	@Override
	public Account login(Account account) {
		List<Account> accounts = hibernateTemplate.findByNamedParam(
				"FROM Account a WHERE a.alogin=:alogin AND a.apass=:apass ",
				new String[]{"alogin", "apass"},
				new Object[]{account.getAlogin(), account.getApass()});
		return accounts != null ? accounts.get(0) : null;
	}

}
