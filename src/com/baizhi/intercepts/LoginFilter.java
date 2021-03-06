package com.baizhi.intercepts;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements javax.servlet.Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest h = (HttpServletRequest)req;
		HttpSession session = h.getSession();
		String contextPath = h.getContextPath();
		Object attribute = session.getAttribute("admin");
		HttpServletResponse r = (HttpServletResponse)res;
		if(attribute==null){
			r.sendRedirect(contextPath+"/login.jsp");
		}else{
			arg2.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
