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
 * @author Administrator 用户登录过滤器
 */
public class UsersLoginFilter implements Filter {

	public UsersLoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//获取session中的用户信息，然后判断是否登录成功
		HttpServletRequest req = (HttpServletRequest) request;
		if(req.getSession().getAttribute("users") != null){
			//不为空，就是已经登录
			chain.doFilter(request, response);
		}else{
			//非法访问
			request.setAttribute("error", "非法访问");
			//保留将要访问的URL
			String url = req.getRequestURI();
			StringBuffer buffer = new StringBuffer();
			//url有工程名，纠结去工程名，否则直接存贮
			System.out.println(url);
			System.out.println(req.getContextPath());
			if(req.getContextPath() == ""){
				//没有工程名
				buffer.append(url);
			}else{
				buffer.append(url.substring(url.indexOf("/",1)));
			}
			String param = req.getQueryString();
			if(param != null){
				buffer.append("?");
				buffer.append(param);
			}
			//保存到session中
			req.getSession().setAttribute("goUrl", buffer.toString());
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
