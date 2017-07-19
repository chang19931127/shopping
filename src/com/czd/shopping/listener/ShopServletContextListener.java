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
 * shopServletContextListener ����һ��listener �����������Ǽ��������Ϣ���� category ��Ҫ���ǵ�����������������
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
		 * �����Ŀ���������ݳ�ʼ������ 1��������������󣬸��²�Ƶ�����Դ洢��app�����У�ȱ�㣺��Ҫ�Լ����ͬ������
		 * 2���������󣬿��Կ���hibernate�������棬hibernate�Լ��ṩ��ͬ������
		 */
		context = WebApplicationContextUtils
				.getWebApplicationContext(se.getServletContext());
		categoryService = (CategoryService) context.getBean("categoryService");
		se.getServletContext().setAttribute("categorys",
				categoryService.query());
		// ͨ��spring�����ļ���ȡ�߳�����
		shopTimerTask = (ShopTimerTask) context.getBean("shopTimerTask");
		shopTimerTask.setApplication(se.getServletContext());
		fileUploadUtil = (FileUploadUtil)context.getBean("fileUploadUtil");
		// ����ִ��ʱ��
		new Timer(true).scheduleAtFixedRate(shopTimerTask, 0, 1000 * 60 * 1000);
		//ͨ��·������ȡ����ͼ�꣬���洢��application���ö�����
		String path = se.getServletContext().getRealPath("/image/logo");
		se.getServletContext().setAttribute("bankImages",fileUploadUtil.bankImage(path));
	}

}
