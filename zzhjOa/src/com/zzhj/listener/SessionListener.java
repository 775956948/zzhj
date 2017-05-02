package com.zzhj.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener ,HttpSessionAttributeListener{
	
	public static List<HttpSession> list =new ArrayList();
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session =event.getSession();
		Integer number = list.indexOf(session);
		if(number!=-1){
			list.remove(number);
		}
		
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		HttpSession session =event.getSession();
		list.add(session);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

}
