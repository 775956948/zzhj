package com.zzhj.entityCustom;

import java.io.Serializable;

import com.zzhj.po.Users;
/**
 * 
 * @author С��
 * @date 2017��5��3��
 * @Description: �Զ����࣬��չ��com.zzhj.po.Users
 * @version 1.0
 */
public class UserNode implements Serializable{
	private int id;
	private String departmentName;
	private String text;
	private String state;
	private String roleName;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
