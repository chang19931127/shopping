package com.czd.shopping.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.czd.shopping.pojo.Forder;
import com.czd.shopping.pojo.Users;

/**
 * 
 * @author Administrator
 *	邮件工具类
 */
public class ShopEmailUtil {
	public void sendMessage( Forder forder,Users users){
		//1，创建回话
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getDefaultInstance(prop);
		//设置 session debug 模式
		session.setDebug(true);
		//2,创建邮件对象
		Message mes = new MimeMessage(session);
		try {
			mes.setSubject("支付成功确认邮件");
			mes.setContent("您好:" + users.getUlogin() + "订单" + forder.getFid()
			+ "金额" + forder.getFtotal() + "已经支付成功,我们会尽快配送", "text/html;charset=utf-8");
			//这里的  url 都是需要授权的
			//发信人的地址
			mes.setFrom(new InternetAddress("541398591@qq.com"));
			//3,发送邮件，传输对象
			Transport transPort = session.getTransport();
			//发送信息配置
			transPort.connect("smtp.sina.com", 25, "username", "password");
			//配置收件人的地址
			transPort.sendMessage(mes, new Address[]{new InternetAddress(users.getUemail())});
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
