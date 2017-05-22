package com.zzhj.po;

import java.io.Serializable;

public class BusCardRecord implements Serializable{

	private int id;
	private BusCard busCardId;
	private Users userId;
	private String start;
	private String over;
	private String startDate;
	private String overDate;
	private float startMoney;
	private float overMoney;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BusCard getBusCardId() {
		return busCardId;
	}
	public void setBusCardId(BusCard busCardId) {
		this.busCardId = busCardId;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getOver() {
		return over;
	}
	public void setOver(String over) {
		this.over = over;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getOverDate() {
		return overDate;
	}
	public void setOverDate(String overDate) {
		this.overDate = overDate;
	}
	public float getStartMoney() {
		return startMoney;
	}
	public void setStartMoney(float startMoney) {
		this.startMoney = startMoney;
	}
	public float getOverMoney() {
		return overMoney;
	}
	public void setOverMoney(float overMoney) {
		this.overMoney = overMoney;
	}
	

}
