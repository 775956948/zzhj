package com.zzhj.po;

import java.io.Serializable;
/**
 * 
 * @author asus
 *	任务信息po类
 */
public class Task implements Serializable{
	
	private int id;				//id
	private String taskTheme;	//任务主题
	private String taskText;	//任务内容
	private String userName;		//发布人
	private int taskDay;		//任务天数
	private String taskDate;	//发布任务时间
	private String recipient;	//任务接收人
	private String implement;	//任务执行人
	private String implementDate;//任务开始时间
	private String successDate;	 //任务完成时间
	private int speed;			 //任务进度
	private String state;		//任务状态
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
