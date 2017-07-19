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
 *	�ʼ�������
 */
public class ShopEmailUtil {
	public void sendMessage( Forder forder,Users users){
		//1�������ػ�
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getDefaultInstance(prop);
		//���� session debug ģʽ
		session.setDebug(true);
		//2,�����ʼ�����
		Message mes = new MimeMessage(session);
		try {
			mes.setSubject("֧���ɹ�ȷ���ʼ�");
			mes.setContent("����:" + users.getUlogin() + "����" + forder.getFid()
			+ "���" + forder.getFtotal() + "�Ѿ�֧���ɹ�,���ǻᾡ������", "text/html;charset=utf-8");
			//�����  url ������Ҫ��Ȩ��
			//�����˵ĵ�ַ
			mes.setFrom(new InternetAddress("541398591@qq.com"));
			//3,�����ʼ����������
			Transport transPort = session.getTransport();
			//������Ϣ����
			transPort.connect("smtp.sina.com", 25, "username", "password");
			//�����ռ��˵ĵ�ַ
			transPort.sendMessage(mes, new Address[]{new InternetAddress(users.getUemail())});
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
