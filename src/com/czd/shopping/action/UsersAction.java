package com.czd.shopping.action;

import com.czd.shopping.pojo.Users;

/**
 * �û���¼action
 * @author Administrator
 *
 */
public class UsersAction extends BaseAction<Users> {

	private static final long serialVersionUID = -5762233261697857163L;
	
	//��ת������
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
			//��¼ʧ��
			request.put("error", "�û����������");
			return "login";
		}else{
			//��¼�ɹ�
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
