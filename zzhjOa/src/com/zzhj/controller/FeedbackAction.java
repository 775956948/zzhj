package com.zzhj.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.Feedback;
import com.zzhj.po.Users;
import com.zzhj.service.FeedbackService;

@Controller
@RequestMapping("/feedback")
public class FeedbackAction {
	
	@Autowired
	private FeedbackService fs;
	
	/**
	 * 
	 * @Description: ��ѯ��ǰ�û�������ķ�����Ϣ
	 * @param @param page
	 * @param @param rows
	 * @param @param session
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
	 */
	@RequestMapping("queryOwn.action")
	@ResponseBody
	public Map<String,Object> queryOwn(int page,int rows,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return fs.queryOwn(page, rows, user.getName());
	}
	/**
	 * 
	 * @Description: ��ѯ��ǰ�û���Ҫ��������Ϣ
	 * @param @param page
	 * @param @param rows
	 * @param @param session
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
	 */
	@RequestMapping("approverOnw.action")
	@ResponseBody
	public Map<String,Object> approverOnw(int page,int rows,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return fs.approverOnw(page, rows, user.getName());
	}
	/**
	 * 
	 * @Description: ����һ��������Ϣ
	 * @param @param f
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
	 */
	@RequestMapping("/addFeedback.action")
	@ResponseBody
	public int addFeedback(Feedback f){
		return fs.addFeedback(f);
	}
	
	/**
	 * 
	 * @Description: ��������
	 * @param @param feedbackId
	 * @param @param session
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
	 */
	@RequestMapping("approver.action")
	@ResponseBody
	public int appover(int feedbackId,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return fs.approver(feedbackId, user.getId());
	}
	/**
	 * 
	 * @Description: ���һ����Ϣ
	 * @param @param feedbackId
	 * @param @param refuseInfo
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
	 */
	@RequestMapping("/refuse.action")
	@ResponseBody
	public int refuse(int feedbackId,String refuseInfo){
		return fs.refuse(feedbackId, refuseInfo);
	}
}
