package com.zzhj.webSocket;
import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;


public class ServerConfig extends ServerEndpointConfig.Configurator {
	@Override
	public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response) {
		// TODO Auto-generated method stub
		 HttpSession httpSession = (HttpSession)request.getHttpSession();
	     config.getUserProperties().put(HttpSession.class.hashCode()+"",httpSession);
	}
}
