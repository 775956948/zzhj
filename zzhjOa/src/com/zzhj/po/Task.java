package com.zzhj.po;

import java.io.Serializable;
/**
 * 
 * @author asus
 *	������Ϣpo��
 */
public class Task implements Serializable{
	
	private int id;				//id
	private String taskTheme;	//��������
	private String taskText;	//��������
	private String userName;		//������
	private int taskDay;		//��������
	private String taskDate;	//��������ʱ��
	private String recipient;	//���������
	private String implement;	//����ִ����
	private String implementDate;//����ʼʱ��
	private String successDate;	 //�������ʱ��
	private int speed;			 //�������
	private String state;		//����״̬
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskTheme() {
		return taskTheme;
	}
	public void setTaskTheme(String taskTheme) {
		this.taskTheme = taskTheme;
	}
	public String getTaskText() {
		return taskText;
	}
	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getTaskDay() {
		return taskDay;
	}
	public void setTaskDay(int taskDay) {
		this.taskDay = taskDay;
	}
	public String getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getImplement() {
		return implement;
	}
	public void setImplement(String implement) {
		this.implement = implement;
	}
	public String getImplementDate() {
		return implementDate;
	}
	public void setImplementDate(String implementDate) {
		this.implementDate = implementDate;
	}
	public String getSuccessDate() {
		return successDate;
	}
	public void setSuccessDate(String successDate) {
		this.successDate = successDate;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
