package com.czd.shopping.service;

import com.czd.shopping.pojo.Users;

/**
 * User Service
 * @author Administrator
 *
 */
public interface UsersService extends BaseService<Users> {
	
	public Users login(Users users);

}
