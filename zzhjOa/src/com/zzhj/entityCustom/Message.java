package com.zzhj.entityCustom;

import java.io.Serializable;

/**
 * һ����Ϣ�࣬���ڴ���ͨ��֮�����Ϣ
 * @author asus
 *
 */
public class Message implements Serializable{

	//��Ϣ����
	private String theme;
	//��Ϣ����
	private String content;
	//����˭
	private String to;
	//˭����
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
