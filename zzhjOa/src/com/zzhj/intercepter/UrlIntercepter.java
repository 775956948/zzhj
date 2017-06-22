package com.zzhj.intercepter;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zzhj.po.Users;

public class UrlIntercepter implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		String url=request.getServletPath();
		if(url.equals("/users/login.action")||url.equals("/users/save.action")||url.equals("/department/queryAll.action")||url.equals("/users/updateUser.action")||url.equals("/securityQuestion/queryAll.action")||url.equals("/users/userExist.action")||url.equals("/users/updateUser.action")){
			return true;
		}else{
			HttpSession session = request.getSession();
			Users user = (Users) session.getAttribute("users");
			if(user!=null){
				return true;
			}
		}
		response.sendRedirect("/zzhjOa/login.jsp");
       return false; 
	}

}
