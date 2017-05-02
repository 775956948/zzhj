package com.zzhj.po;

import java.io.Serializable;

public class CarInfo implements Serializable{
	private int id;
	private Car carId;
	private String  driver;
	private String requestName;
	private String departmentName;
	private String requestText;
	private	String startDate;
	private float startNumber;
	private String overDate;
	private float overNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Car getCarId() {
		return carId;
	}
	public void setCarId(Car carId) {
		this.carId = carId;
	}
	public String getRequestName() {
		return requestName;
	}
	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getRequestText() {
		return requestText;
	}
	public void setRequestText(String requestText) {
		this.requestText = requestText;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public float getStartNumber() {
		return startNumber;
	}
	public void setStartNumber(float startNumber) {
		this.startNumber = startNumber;
	}
	public String getOverDate() {
		return overDate;
	}
	public void setOverDate(String overDate) {
		this.overDate = overDate;
	}
	public float getOverNumber() {
		return overNumber;
	}
	public void setOverNumber(float overNumber) {
		this.overNumber = overNumber;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	
}	
