package com.zzhj.po;

import java.io.Serializable;

/**
 * 公告实体类
 * @author asus
 *
 */
public class Notice implements Serializable{
	
	private int id; 			//id
	private String theme;		//公告主题
	private String text;		//公告内容
	private Users userId;		//用户
	private String releaseDate; //发布日期
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}
