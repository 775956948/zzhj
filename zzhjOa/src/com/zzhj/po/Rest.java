package com.zzhj.po;

import java.io.Serializable;

public class Rest implements Serializable{

	private int id;					//id
	private Users userId;			//申请人
	private RestType restTypeId;	//请假类型
	private String restText;		//请假原有
	private String requestDate;		//请假开始时间
	private String overDate;		//请假结束时间
	private String restDate;		//请假天数
	private String requestStage;	//开始阶段
	private String overStage;		//结束阶段
	private String approver;		//审批人
	private String state;			//状态
	private String appendix;		//附件
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
	public RestType getRestTypeId() {
		return restTypeId;
	}
	public void setRestTypeId(RestType restTypeId) {
		this.restTypeId = restTypeId;
	}
	public String getRestText() {
		return restText;
	}
	public void setRestText(String restText) {
		this.restText = restText;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getOverDate() {
		return overDate;
	}
	public void setOverDate(String overDate) {
		this.overDate = overDate;
	}
	public String getRestDate() {
		return restDate;
	}
	public void setRestDate(String restDate) {
		this.restDate = restDate;
	}
	public String getRequestStage() {
		return requestStage;
	}
	public void setRequestStage(String requestStage) {
		this.requestStage = requestStage;
	}
	public String getOverStage() {
		return overStage;
	}
	public void setOverStage(String overStage) {
		this.overStage = overStage;
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
	public String getAppendix() {
		return appendix;
	}
	public void setAppendix(String appendix) {
		this.appendix = appendix;
	}
	
}
