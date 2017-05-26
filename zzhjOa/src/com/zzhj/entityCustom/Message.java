package com.zzhj.entityCustom;

import java.io.Serializable;

/**
 * 一个消息类，用于传送通信之间的消息
 * @author asus
 *
 */
public class Message implements Serializable{

	//消息主题
	private String theme;
	//消息内容
	private String content;
	//发给谁
	private String to;
	//谁发的
	private String from;
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	} 
	
}
