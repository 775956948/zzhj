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
	
	//���͵���Ϣ����(ö������)
	private MessageType type;
	
	//��Ϣ��idΨһ��ʶ
	private int contentId;
	
	//Ŀ����ͼ
	private String viewTarget;
	
	//Ŀ������
	private String targetName;
	
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
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	public String getViewTarget() {
		return viewTarget;
	}
	public void setViewTarget(String viewTarget) {
		this.viewTarget = viewTarget;
	}
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	
	
	
	
}
