package com.czd.shopping.action;

import org.apache.struts2.ServletActionContext;

import com.czd.shopping.pojo.Forder;

/**
 * 
 * @author Administrator
 *	¶©µ¥action
 */
public class ForderAction extends BaseAction<Forder> {

	private static final long serialVersionUID = 1L;

	public String cluFtotal(){
		System.out.println("--------culFtotal");
		Forder forder = (Forder) session.get("forder");
		forder.setFtotal(forderService.cluFtotal(forder));
		session.put("forder", forder);
		System.out.println(ServletActionContext.getRequest().getCharacterEncoding());
		System.out.println(ServletActionContext.getResponse().getCharacterEncoding());
		return "showCar";
	}
}
