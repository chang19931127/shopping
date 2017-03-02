package com.czd.ssh;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czd.shopping.pojo.Category;
import com.czd.shopping.service.impl.CategoryServiceImpl;

/*
 * ���Կ������
 */
public class SSHTest {
	@Test
	public void spring(){
		String configLocations = "applicationContext-*.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		System.out.println(context.getBean("date"));
	}
	
	@Test
	public void hibernate(){
		System.out.println(HibernateSessionFactory.getConfiguration());
		System.out.println(HibernateSessionFactory.getSessionFactory());
		System.out.println(HibernateSessionFactory.getSession());
	}
	
	@Test
	public void springHibernate(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		CategoryServiceImpl categoryServiceImpl = (CategoryServiceImpl) context.getBean("categoryServiceImpl");
		Category category = new Category("test", false, 1);
		System.out.println(categoryServiceImpl);
		//����������ͨ�� aop����������ģ����������Ҫ��xml����ҲҪ���� aop���õģ�����advisor
		categoryServiceImpl.save(category);
	}
}
