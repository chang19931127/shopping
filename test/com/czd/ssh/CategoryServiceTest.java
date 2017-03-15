package com.czd.ssh;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czd.shopping.pojo.Category;
import com.czd.shopping.service.CategoryService;
/**
 * 
 * @author Administrator
 *	测试的使用要使用静态 static来进行
 */
public class CategoryServiceTest {

	private static CategoryService categoryService;
	private static ClassPathXmlApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() {
		context = new ClassPathXmlApplicationContext(
				"applicationContext-*.xml");
		categoryService = (CategoryService) context.getBean("categoryService");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		categoryService = null;
		context.destroy();
	}
	
	@Test
	public void testGet() {
		System.out.println(categoryService.get(1));
	}
	
	@Test
	public void testQuery() {
		for(Category temp:categoryService.query()){
			System.out.println(temp.getCtype());
			System.out.println(temp.getCid());
		}
	}
}
