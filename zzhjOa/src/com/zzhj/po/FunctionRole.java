package com.zzhj.po;

public class FunctionRole implements java.io.Serializable{
	private int id;
	private Function functionId;
	private Roles roleId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Function getFunctionId() {
		return functionId;
	}
	public void setFunctionId(Function functionId) {
		this.functionId = functionId;
	}
	public Roles getRoleId() {
		return roleId;
	}
	public void setRoleId(Roles roleId) {
		this.roleId = roleId;
	}
}
