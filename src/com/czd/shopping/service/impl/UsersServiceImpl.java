package com.czd.shopping.service.impl;

import java.util.List;

import com.czd.shopping.pojo.Users;
import com.czd.shopping.service.UsersService;

/**
 * UsersService µœ÷¿‡
 * 
 * @author Administrator
 *
 */
public class UsersServiceImpl extends BaseServiceImpl<Users>
		implements
			UsersService {

	@SuppressWarnings("unchecked")
	@Override
	public Users login(Users users) {
		List<Users> usersList = hibernateTemplate.findByNamedParam(
				"FROM Users WHERE ulogin=:ulogin AND upass=:upass",
				new String[]{"ulogin", "upass"},
				new Object[]{users.getUlogin(), users.getUpass()});
		System.out.println(usersList);
		return usersList.size() > 0 ? usersList.get(0) : null;
	}

}
