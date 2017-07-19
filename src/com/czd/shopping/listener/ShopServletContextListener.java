package com.czd.shopping.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.czd.shopping.service.CategoryService;
import com.czd.shopping.util.FileUploadUtil;
import com.czd.shopping.util.ShopTimerTask;

/**
 * Application Lifecycle Listener implementation class
 * shopServletContextListener 这是一个listener 用来帮助我们加载类别信息数据 category 需要我们的容器启动后来加载
 *
 */
public class ShopServletContextListener implements ServletContextListener {

	private ApplicationContext context = null;
	private CategoryService categoryService = null;
	private ShopTimerTask shopTimerTask = null;
	private FileUploadUtil fileUploadUtil = null;
	/**
	 * Default constructor.
	 */
	public ShopServletContextListener() {
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent se) {
		/*
		 * 完成项目启动的数据初始化功能 1：如果数据量不大，更新不频繁可以存储到app缓存中，缺点：需要自己解决同步问题
		 * 2：数据量大，可以考虑hibernate二级缓存，hibernate自己提供了同步共嫩
		 */
		context = WebApplicationContextUtils
				.getWebApplicationContext(se.getServletContext());
		categoryService = (CategoryService) context.getBean("categoryService");
		se.getServletContext().setAttribute("categorys",
				categoryService.query());
		// 通过spring配置文件获取线程任务
		shopTimerTask = (ShopTimerTask) context.getBean("shopTimerTask");
		shopTimerTask.setApplication(se.getServletContext());
		fileUploadUtil = (FileUploadUtil)context.getBean("fileUploadUtil");
		// 设置执行时间
		new Timer(true).scheduleAtFixedRate(shopTimerTask, 0, 1000 * 60 * 1000);
		//通过路径来获取银行图标，并存储到application内置对象中
		String path = se.getServletContext().getRealPath("/image/logo");
		se.getServletContext().setAttribute("bankImages",fileUploadUtil.bankImage(path));
	}

}
