package com.czd.shopping.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.czd.shopping.pojo.Forder;

/**
 * Application Lifecycle Listener implementation class ShopHttpSessionListener
 *
 */
public class ShopHttpSessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ShopHttpSessionListener() {
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent hs)  { 
    	//����һ�����ﳵ�����Ұѹ��ﳵ�洢��session��
    	System.out.println("--------create----------");
    	hs.getSession().setAttribute("forder", new Forder());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    }
	
}
