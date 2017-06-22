package com.zzhj.po;

import java.io.Serializable;
/**
 * 消息反馈信息po类
 * @author asus
 *
 */
public class Feedback implements Serializable{

	private int id;
	//申请人
	private String requestName;
	//申请时间
	private String requestDate;
	//任务的名称
	private Task taskId;
	//反馈的信息
	private String info;
	//打回信息
	private String refuseInfo;
	//审批人
	private String approver;
	//结束时间
	private String overDate;
	//状态
	private String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRequestName() {
		return requestName;
	}
	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public Task getTaskId() {
		return taskId;
	}
	public void setTaskId(Task taskId) {
		this.taskId = taskId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getRefuseInfo() {
		return refuseInfo;
	}
	public void setRefuseInfo(String refuseInfo) {
		this.refuseInfo = refuseInfo;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
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
