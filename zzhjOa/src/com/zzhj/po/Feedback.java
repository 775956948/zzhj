package com.zzhj.po;

import java.io.Serializable;
/**
 * ��Ϣ������Ϣpo��
 * @author asus
 *
 */
public class Feedback implements Serializable{

	private int id;
	//������
	private String requestName;
	//����ʱ��
	private String requestDate;
	//���������
	private Task taskId;
	//��������Ϣ
	private String info;
	//�����Ϣ
	private String refuseInfo;
	//������
	private String approver;
	//����ʱ��
	private String overDate;
	//״̬
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
