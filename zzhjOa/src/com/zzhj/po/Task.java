package com.zzhj.po;

import java.io.Serializable;
/**
 * 
 * @author asus
 *	任务信息po类
 */
public class Task implements Serializable{
	

	private int id;				//id
	private String userName;	//发布人
	private String taskTheme;	//任务主题
	private String taskText;	//任务内容
	private String taskAddress; //项目地址 
	private String entrustedUnit;//委托单位
	private String client;		//委托人
	private String clientPhone; //委托人电话
	private String taskDate;	//发布任务时间
	private String recipient;	//任务接收人
	private String implement;	//任务执行人
	private String implementDate;//任务开始时间
	private int speed;			 //任务进度
	private String taskPhase;   //任务阶段
	private String inspection;   //质量检测
	private String inspectionUser;//质检人
	private String successDate;	 //任务结束时间
	private String overDate;	//指定结束时间
	private String state;		//任务状态
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getTaskAddress() {
		return taskAddress;
	}
	public void setTaskAddress(String taskAddress) {
		this.taskAddress = taskAddress;
	}
	public String getEntrustedUnit() {
		return entrustedUnit;
	}
	public void setEntrustedUnit(String entrustedUnit) {
		this.entrustedUnit = entrustedUnit;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
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
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getTaskPhase() {
		return taskPhase;
	}
	public void setTaskPhase(String taskPhase) {
		this.taskPhase = taskPhase;
	}
	public String getInspection() {
		return inspection;
	}
	public void setInspection(String inspection) {
		this.inspection = inspection;
	}
	public String getSuccessDate() {
		return successDate;
	}
	public void setSuccessDate(String successDate) {
		this.successDate = successDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getInspectionUser() {
		return inspectionUser;
	}
	public void setInspectionUser(String inspectionUser) {
		this.inspectionUser = inspectionUser;
	}
	public String getOverDate() {
		return overDate;
	}
	public void setOverDate(String overDate) {
		this.overDate = overDate;
	}
	 
	

}
