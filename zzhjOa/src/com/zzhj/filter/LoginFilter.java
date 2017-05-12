package com.zzhj.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzhj.po.Users;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hRequest = (HttpServletRequest) request;
		HttpSession session = hRequest.getSession();
		Users user = (Users) session.getAttribute("users");
		String url=hRequest.getServletPath();
		if(url.equals("/login.jsp")||url.equals("/registered.jsp")||url.equals("/back.jsp")||url.equals("/MyJsp.jsp")){
			if(url.equals("/login.jsp")){
				if(user!=null){
					HttpServletResponse r =(HttpServletResponse) response;
					r.sendRedirect("main.jsp");
				}
			}
			chain.doFilter(request, response);
		}else if(user!=null){
			chain.doFilter(request, response);
		}else{
			HttpServletResponse r =(HttpServletResponse) response;
			r.sendRedirect("login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
