package com.zzhj.po;

import java.io.Serializable;
/**
 * 
 * @author asus
 *	������Ϣpo��
 */
public class Task implements Serializable{
	

	private int id;				//id
	private String userName;	//������
	private String taskTheme;	//��������
	private String taskText;	//��������
	private String taskAddress; //��Ŀ��ַ 
	private String entrustedUnit;//ί�е�λ
	private String client;		//ί����
	private String clientPhone; //ί���˵绰
	private String taskDate;	//��������ʱ��
	private String recipient;	//���������
	private String implement;	//����ִ����
	private String implementDate;//����ʼʱ��
	private int speed;			 //�������
	private String taskPhase;   //����׶�
	private String inspection;   //�������
	private String inspectionUser;//�ʼ���
	private String successDate;	 //�������ʱ��
	private String overDate;	//ָ������ʱ��
	private String state;		//����״̬
	
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
