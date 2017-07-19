package com.czd.shopping.action;

import com.czd.shopping.pojo.Users;

/**
 * 用户登录action
 * @author Administrator
 *
 */
public class UsersAction extends BaseAction<Users> {

	private static final long serialVersionUID = -5762233261697857163L;
	
	//跳转的链接
	private String goUrl = null;

	public String getGoUrl() {
		System.out.println("-------get-----"+goUrl);
		return goUrl;
	}

	public void setGoUrl(String goUrl) {
		this.goUrl = goUrl;
	}
	
	public String login(){
		Users users = usersService.login(model);
		if(users == null){
			//登录失败
			request.put("error", "用户名密码错误");
			return "login";
		}else{
			//登录成功
			session.put("users", users);
			if(session.get("goUrl") != null){
				goUrl = session.get("goUrl").toString();
				return "aa";
			}else{
				return "index";
			}
		}
	}
	
	
}
