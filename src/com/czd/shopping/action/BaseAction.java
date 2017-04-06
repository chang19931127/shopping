package com.czd.shopping.action;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.struts.ActionSupport;

import com.czd.shopping.service.AccountService;
import com.czd.shopping.service.CategoryService;
import com.czd.shopping.service.ForderService;
import com.czd.shopping.service.GoodsService;
import com.czd.shopping.service.SorderService;
import com.czd.shopping.util.FileUploadUtil;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author Administrator Action存储公共代码
 *         ModelDriver，RequestAware，SessionAware，ApplicationAware 一些业务逻辑类
 *         同样这里是泛型父类,struts2也提供 aop ioc 的控制 注入
 */
public class BaseAction<T> extends ActionSupport
		implements
			ModelDriven<T>,
			RequestAware,
			SessionAware,
			ApplicationAware,
			Serializable {

	private static final long serialVersionUID = -5845622352307995224L;

	protected Map<String, Object> jsonMap = new HashMap<>();
	protected T model = null;
	protected Map<String, Object> request = null;
	protected Map<String, Object> session = null;
	protected Map<String, Object> application = null;
	protected AccountService accountService = null;
	protected CategoryService categoryService = null;
	protected GoodsService goodsService = null;
	protected ForderService forderService = null;
	protected SorderService sorderService = null;
	protected FileUploadUtil fileUploadUtil = null;

	//动态获取子类类型
	public BaseAction() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
		try {
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// 用于注入
		
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	

	public void setForderService(ForderService forderService) {
		this.forderService = forderService;
	}

	public void setSorderService(SorderService sorderService) {
		this.sorderService = sorderService;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	public void setFileUploadUtil(FileUploadUtil fileUploadUtil) {
		this.fileUploadUtil = fileUploadUtil;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public T getModel() {
		return model;
	}

}
