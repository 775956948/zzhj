package com.zzhj.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.mapper.FeedbackMapper;
import com.zzhj.mapper.UsersMapper;
import com.zzhj.po.Feedback;
import com.zzhj.po.Users;

import utils.DateFormater;

@Service
public class FeedbackService {
 
	@Autowired
	private FeedbackMapper fm;
	@Autowired
	private UsersMapper um;
	
	/**
	 * 
	 * @Description: 查询申请人是当前用户的信息
	 * @param @param page
	 * @param @param rows
	 * @param @param requestName
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	public Map<String,Object> queryOwn(int page, int rows, String requestName){
		int startPage =(page-1)*rows;
		List<Feedback> list =fm.queryOwn(startPage, rows, requestName);
		int total =fm.totalCount(requestName);
		Map<String,Object> map = new HashMap();
		map.put("rows", list);
		map.put("total",total);
		return map;
	}
	/**
	 * 
	 * @Description: 查询该当前用户审批的信息
	 * @param @param page
	 * @param @param rows
	 * @param @param approverName
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	public Map<String,Object> approverOnw(int page, int rows,String approverName){
		int startPage =(page-1)*rows;
		List<Feedback> list =fm.approverOnw(startPage, rows, approverName);
		int total =fm.totalCount(approverName);
		Map<String,Object> map = new HashMap();
		map.put("rows", list);
		map.put("total",total);
		return map;
	}
	/**
	 * 
	 * @Description: 添加一条反馈信息
	 * @param @param f
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	public int addFeedback(Feedback f,int currentId){
		Date d = new Date();
		Users userId= um.parentId(currentId);
		Users nextApprover =um.query(userId.getParentId());
		String requestDate= DateFormater.format(d);
		f.setRequestDate(requestDate);
		f.setApprover(nextApprover.getName());
		f.setState("待审批");
		return fm.addFeedback(f);
	}
	/**
	 * 
	 * @Description: 审批方法
	 * @param @param id
	 * @param @param nextApprover
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	public int approver(int id,Users user){
		String nextApprover ="";
		if(user.getRoleId().getName().equals("主管")){
			Users f =um.userId(user.getDepartmentId().getName());
			nextApprover=f.getName();
		}
		return fm.approver(id,nextApprover );
	}
	/**
	 * 
	 * @Description: 打回一条反馈信息
	 * @param @param feedbackId
	 * @param @param refuseInfo
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	public int refuse(int feedbackId,String refuseInfo){
		Date d = new Date();
		String overDate = DateFormater.format(d);
		return fm.refuse(feedbackId, refuseInfo, overDate);
		
	}
	/**
	 * 
	 * @Description: 删除一条信息
	 * @param @param feedbackId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月21日
	 */
	public int deleteFeedback(int feedbackId){
		return fm.deleteFeedback(feedbackId);
	}
}
