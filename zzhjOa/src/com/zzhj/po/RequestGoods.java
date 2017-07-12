package com.zzhj.po;

import java.io.Serializable;
/**
 * 物品申请po类
 * @author asus
 *
 */
public class RequestGoods implements Serializable{

	
	private int id;
	private Users userId;			//申请人
	private OfficeSupplies goodId;	//物品
	private int goodsNumber;
	private String approver;		//审批人
	private String state;			//状态
	private String requestDate;		//申请日期
	private String approverDate;	//出库日期
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	public OfficeSupplies getGoodId() {
		return goodId;
	}
	public void setGoodId(OfficeSupplies goodId) {
		this.goodId = goodId;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getApproverDate() {
		return approverDate;
	}
	public void setApproverDate(String approverDate) {
		this.approverDate = approverDate;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	
	
}
