package com.zzhj.po;

import java.io.Serializable;

public class Users implements Serializable{	
	private int id;
	private String name;			//�û���
	private String password;		//����
	private String sex;				//�Ա�
	private String birthday;		//��������
	private String positiveDate;	//ת��ʱ��
	private Roles roleId;			//������ɫ
	private Department departmentId;//��������
	private String phone;	//�ֻ���
	private int idCard;		//���֤��
	private String national;/*����*/
	private float height;	/*���*/
	private String marital;/*���*/
	private String face;	/*������ò*/
	private String address;	/*���ڵ�ַ*/
	private String graduated;/*��ҵѧУ*/
	private String education;/*�Ļ��̶�*/
	private String professional;/*רҵ*/
	private String zhuGuan;		/*��������*/
	private String manager;     /*��������*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPositiveDate() {
		return positiveDate;
	}
	public void setPositiveDate(String positiveDate) {
		this.positiveDate = positiveDate;
	}

	public Roles getRoleId() {
		return roleId;
	}
	public void setRoleId(Roles roleId) {
		this.roleId = roleId;
	}
	public Department getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getIdCard() {
		return idCard;
	}
	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}
	public String getNational() {
		return national;
	}
	public void setNational(String national) {
		this.national = national;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public String getMarital() {
		return marital;
	}
	public void setMarital(String marital) {
		this.marital = marital;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGraduated() {
		return graduated;
	}
	public void setGraduated(String graduated) {
		this.graduated = graduated;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public String getZhuGuan() {
		return zhuGuan;
	}
	public void setZhuGuan(String zhuGuan) {
		this.zhuGuan = zhuGuan;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}

	
	
}
