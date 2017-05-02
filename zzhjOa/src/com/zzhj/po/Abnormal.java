package com.zzhj.po;

import java.io.Serializable;

public class Abnormal implements Serializable{
	
	private int id;
	private Users userId;
	private String abnormalType;
	private String abnormalDate;
	private String abnormalText;
	private String date;
	private String approver;
	private String state;
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
	public String getAbnormalType() {
		return abnormalType;
	}
	public void setAbnormalType(String abnormalType) {
		this.abnormalType = abnormalType;
	}
	public String getAbnormalDate() {
		return abnormalDate;
	}
	public void setAbnormalDate(String abnormalDate) {
		this.abnormalDate = abnormalDate;
	}
	public String getAbnormalText() {
		return abnormalText;
	}
	public void setAbnormalText(String abnormalText) {
		this.abnormalText = abnormalText;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
