package com.zzhj.po;

import java.io.Serializable;
/**
 * 消息反馈信息po类
 * @author asus
 *
 */
public class Feedback implements Serializable{

	private int id;
	//任务的名称
	private String taskName;
	//反馈的信息
	private String info;
	//审批人
	private Users approver;
	//状态
	private String state;
}
