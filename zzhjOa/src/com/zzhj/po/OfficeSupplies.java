package com.zzhj.po;

import java.io.Serializable;

/**
 * �칫��Ʒpo��
 * @author asus
 *
 */
public class OfficeSupplies implements Serializable{

	
	private int id;				//���
	private String goodsName;	//��Ʒ����
	private int goodsNumber;	//��Ʒ����
	private float goodsMoney;	//��Ʒ�۸�
	private String goodsDate;	//�������
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
