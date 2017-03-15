package com.czd.ssh;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czd.shopping.pojo.Account;
import com.czd.shopping.service.AccountService;
/**
 * 
 * @author Administrator
 *	测试的使用要使用静态 static来进行
 */
public class AccountServiceTest {

	private static AccountService accountService;
	private static ClassPathXmlApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() {
		context = new ClassPathXmlApplicationContext(
				"applicationContext-*.xml");
		accountService = (AccountService) context.getBean("accountService");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		accountService = null;
		context.destroy();
	}
	
	@Test
	public void testGet() {
		System.out.println(accountService.get(1));
	}
	@Test
	public void testLogin() {
		Account account=new Account();
		account.setAlogin("admin");
		account.setApass("admin");
		Account temp= (Account) accountService.login(account);
		System.out.println(temp.getAname());
	}
}
