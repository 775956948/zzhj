package com.zzhj.po;

import java.io.Serializable;

public class ZiZhiSeal implements Serializable{

	private int id;   			//id唯一标识
	private int number;			//编号
	private String projectName;	//项目名称
	private int pageNumber;		//页数
	private int copiesNumber;	//份数
	private String text;		//内容
	private String why;			//原由
	private Users userId;		//申请人
	private String requestDate;	//申请时间
	private String approver;	//审批人
	private String agent;		//经办人
	private String overDate;	//盖章时间
	private String state;		//状态
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;	
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public int getCopiesNumber() {
		return copiesNumber;
	}
	public void setCopiesNumber(int copiesNumber) {
		this.copiesNumber = copiesNumber;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getWhy() {
		return why;
	}
	public void setWhy(String why) {
		this.why = why;
	}
	
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getOverDate() {
		return overDate;
	}
	public void setOverDate(String overDate) {
		this.overDate = overDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
