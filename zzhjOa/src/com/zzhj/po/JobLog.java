package com.zzhj.po;

import java.util.ArrayList;
import java.util.List;

public class JobLog {
	private int id;
	private int text;
	private List<JobLog> children = new ArrayList<JobLog>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getText() {
		return text;
	}
	public void setText(int text) {
		this.text = text;
	}
	public List<JobLog> getChildren() {
		return children;
	}
	public void setChildren(List<JobLog> children) {
		this.children = children;
	}
	
}
