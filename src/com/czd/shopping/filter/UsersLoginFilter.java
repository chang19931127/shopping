package com.czd.shopping.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Administrator �û���¼������
 */
public class UsersLoginFilter implements Filter {

	public UsersLoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//��ȡsession�е��û���Ϣ��Ȼ���ж��Ƿ��¼�ɹ�
		HttpServletRequest req = (HttpServletRequest) request;
		if(req.getSession().getAttribute("users") != null){
			//��Ϊ�գ������Ѿ���¼
			chain.doFilter(request, response);
		}else{
			//�Ƿ�����
			request.setAttribute("error", "�Ƿ�����");
			//������Ҫ���ʵ�URL
			String url = req.getRequestURI();
			StringBuffer buffer = new StringBuffer();
			//url�й�����������ȥ������������ֱ�Ӵ���
			System.out.println(url);
			System.out.println(req.getContextPath());
			if(req.getContextPath() == ""){
				//û�й�����
				buffer.append(url);
			}else{
				buffer.append(url.substring(url.indexOf("/",1)));
			}
			String param = req.getQueryString();
			if(param != null){
				buffer.append("?");
				buffer.append(param);
			}
			//���浽session��
			req.getSession().setAttribute("goUrl", buffer.toString());
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
