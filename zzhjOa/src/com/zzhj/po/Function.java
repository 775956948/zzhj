package com.zzhj.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Function implements Serializable {
	private int id;
	private String text;
	private String state;
	private String url;
	private String icon;
	private Set<Function> children =new HashSet<Function>();
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Set<Function> getChildren() {
		return children;
	}
	public void setChildren(Set<Function> children) {
		this.children = children;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
