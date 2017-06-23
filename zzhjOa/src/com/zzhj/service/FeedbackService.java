package com.zzhj.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.entityCustom.Message;
import com.zzhj.entityCustom.MessageType;
import com.zzhj.mapper.FeedbackMapper;
import com.zzhj.mapper.TaskMapper;
import com.zzhj.mapper.UsersMapper;
import com.zzhj.po.Feedback;
import com.zzhj.po.Users;
import com.zzhj.webSocket.ServerHandler;

import utils.DateFormater;

@Service
public class FeedbackService {
 
	@Autowired
	private FeedbackMapper fm;
	@Autowired
	private UsersMapper um;
	@Autowired
	private TaskMapper tm;
	
	/**
	 * 
	 * @Description: ��ѯ��ǰ�û��ķ���������Ϣ
	 * @param @param page
	 * @param @param rows
	 * @param @param requestName
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
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
	 * @Description: ��ѯ�õ�ǰ�û���������Ϣ
	 * @param @param page
	 * @param @param rows
	 * @param @param approverName
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
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
	 * @Description: ���һ��������Ϣ
	 * @param @param f
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
	 */
	public int addFeedback(Feedback f){
		Date d = new Date();
		String nextApprover =tm.queryRecipient(f.getTaskId().getId());
		String requestDate= DateFormater.format(d);
		f.setRequestDate(requestDate);
		f.setApprover(nextApprover);
		f.setState("������");
		int result =fm.addFeedback(f);
		if(result>0){
			Message mes = new Message();
			mes.setFrom(f.getRequestName());
			mes.setTargetName("����������Ϣ");
			mes.setViewTarget("task/feedbackApproval.html");
			mes.setType(MessageType.feedback);
			mes.setContentId(f.getId());
			mes.setTheme("����δ�������������Ϣ");
			send(mes,nextApprover);
		}
		return result;
	}
	/**
	 * 
	 * @Description: ��������
	 * @param @param id
	 * @param @param nextApprover
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
	 */
	public int approver(int id,Users user){
		String nextApprover ="";
		if(user.getRoleId().getName().equals("����")||user.getRoleId().getName().equals("���ž���")){
			Users f =um.userId(user.getDepartmentId().getName());
			nextApprover=f.getName();
			Message mes = new Message();
			mes.setFrom(user.getName());
			mes.setTargetName("����������Ϣ");
			mes.setViewTarget("task/feedbackApproval.html");
			mes.setType(MessageType.feedback);
			mes.setContentId(id);
			mes.setTheme("����δ�������������Ϣ");
			send(mes,nextApprover);
		}
		return fm.approver(id,nextApprover );
	}
	/**
	 * 
	 * @Description: ���һ��������Ϣ
	 * @param @param feedbackId
	 * @param @param refuseInfo
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
	 */
	public int refuse(int feedbackId,String refuseInfo){
		Date d = new Date();
		String overDate = DateFormater.format(d);
		return fm.refuse(feedbackId, refuseInfo, overDate);
		
	}
	/**
	 * 
	 * @Description: ɾ��һ����Ϣ
	 * @param @param feedbackId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��21��
	 */
	public int deleteFeedback(int feedbackId){
		return fm.deleteFeedback(feedbackId);
	}
	/**
	 * 
	 * @Description: ��Ϣ���ͷ���
	 * @param @param mes
	 * @param @param userName   
	 * @return void  
	 * @throws
	 * @author С��
	 * @date 2017��6��23��
	 */
	private void send(Message mes,String userName){
		ServerHandler.send(userName, mes);
	}
	
}
