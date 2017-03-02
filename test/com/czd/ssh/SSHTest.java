package com.czd.ssh;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czd.shopping.pojo.Category;
import com.czd.shopping.service.impl.CategoryServiceImpl;

/*
 * 测试框架整合
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
		//这里我们是通过 aop来管理事务的，因此我们需要的xml必须也要包含 aop配置的，事务advisor
		categoryServiceImpl.save(category);
	}
}
