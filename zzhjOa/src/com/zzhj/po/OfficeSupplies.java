package com.zzhj.po;

import java.io.Serializable;

/**
 * 办公用品po类
 * @author asus
 *
 */
public class OfficeSupplies implements Serializable{

	
	private int id;				//编号
	private String goodsName;	//物品名称
	private int goodsNumber;	//物品数量
	private float goodsMoney;	//物品价格
	private String goodsDate;	//入库日期
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public float getGoodsMoney() {
		return goodsMoney;
	}
	public void setGoodsMoney(float goodsMoney) {
		this.goodsMoney = goodsMoney;
	}
	public String getGoodsDate() {
		return goodsDate;
	}
	public void setGoodsDate(String goodsDate) {
		this.goodsDate = goodsDate;
	}
	
}
