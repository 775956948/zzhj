package com.zzhj.po;

import java.io.Serializable;

public class Rest implements Serializable{
	private int id;
	private Users userId;
	private String restText;
	private String restDate;	//请假天数
	private String date;		//申请得时间
	private String approver;
	private String advice;
	private String state;
	private RestType restTypeId;
	private String currentDate;	//从何时请假得时间( 数据库（currents_date）)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	public String getRestText() {
		return restText;
	}
	public void setRestText(String restText) {
		this.restText = restText;
	}
	public String getRestDate() {
		return restDate;
	}
	public void setRestDate(String restDate) {
		this.restDate = restDate;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public RestType getRestTypeId() {
		return restTypeId;
	}
	public void setRestTypeId(RestType restTypeId) {
		this.restTypeId = restTypeId;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	
}
