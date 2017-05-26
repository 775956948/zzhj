package com.zzhj.webSocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.codehaus.jackson.map.ObjectMapper;

import com.zzhj.entityCustom.Message;
import com.zzhj.po.Users;


@ServerEndpoint(value="/serverHandler",configurator=ServerConfig.class,encoders = { ServerEncoder.class })
public class ServerHandler {
	public static Map<String,ServerHandler> users =new HashMap<String,ServerHandler>();
	private static Map<String,Message> offlineUser = new HashMap<String,Message>();
	private Session session;
	private HttpSession httpSession;
	@OnOpen
	public void buildConnect(Session session, EndpointConfig config){
		this.session=session;
		httpSession =(HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		Users user =(Users) httpSession.getAttribute("users");
		users.put(user.getName(),this);
		offlineUserSend(user.getName());
	}
	@OnClose
	public void close(){
		Users user =(Users) httpSession.getAttribute("users");
		users.remove(user.getName());
	}
	@OnMessage
	public void message(String message){
		
	}
	@OnError
	public void error(Throwable t){
		System.out.println("出现异常");
	}
	/**
	 * 
	 * @Description: 消息单发
	 * @param @param name
	 * @param @param mes   
	 * @return void  
	 * @throws
	 * @author 小白
	 * @date 2017年5月26日
	 */
	public static void send(String name,Message mes){
		ServerHandler sh =users.get(name);
		try {
			if(sh.session.isOpen()){
				sh.session.getBasicRemote().sendObject(mes);
			}else{
				offlineUser.put(name, mes);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * @Description: 多线程，消息群发
	 * @param @param mes   
	 * @return void  
	 * @throws
	 * @author 小白
	 * @date 2017年5月26日
	 */
	public static void sendAll(Message mes){
		for(Entry<String,ServerHandler> entry :users.entrySet()){
			try {
				new Thread(new Runnable() {	
					@Override
					public void run() {
						if(entry.getValue().session.isOpen()){
							try {
								try {
									entry.getValue().session.getBasicRemote().sendObject(mes);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} catch (EncodeException e) {
								e.printStackTrace();
							}
						}
					}
				}).start();	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @Description: 处理离线消息
	 * @param @param name   
	 * @return void  
	 * @throws
	 * @author 小白
	 * @date 2017年5月26日
	 */
	public static void offlineUserSend(String name){
		for (Entry<String,Message> entry : offlineUser.entrySet()) {
			if(entry.getKey().equals(name)){
				send(name,entry.getValue());
				offlineUser.remove(name);
			}
		}
	}
}
