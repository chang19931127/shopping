package com.czd.shopping.action;

import com.czd.shopping.pojo.Forder;
import com.czd.shopping.pojo.Sorder;

/**
 * 
 * @author Administrator
 *	�������action
 *
 *	��һ��ִ��˳��
 *	����ת sorderAction �����ӹ����Ȼ����תForderAction ��ɼ��㣬Ȼ����shopCar��ʾ
 */
public class SorderAction extends BaseAction<Sorder>{

	private static final long serialVersionUID = 1L;
	
	//���빺�ﳵ
	public String addSorder(){
		Forder forder = (Forder) session.get("forder");
		//model�� sorder
		forder = sorderService.addSorder(forder, model);
		
		return "demo";
	}
	
	//�Ƴ�������
	public String removeSorder(){
		int gid = model.getGoods().getGid();
		Forder forder = (Forder) session.get("forder");
		forder = sorderService.removeSorder(forder, gid);
		forder.setFtotal(forderService.cluFtotal(forder));
		session.put("forder", forder);
		jsonMap.put("ftotal", forder.getFtotal());
		System.out.println("json demo");
		return "json1";
	}

}
