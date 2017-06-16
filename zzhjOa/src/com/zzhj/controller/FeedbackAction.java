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
	 * @Description: 查询当前用户的申请的反馈信息
	 * @param @param page
	 * @param @param rows
	 * @param @param session
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	@RequestMapping("queryOwn.action")
	@ResponseBody
	public Map<String,Object> queryOwn(int page,int rows,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return fs.queryOwn(page, rows, user.getName());
	}
	/**
	 * 
	 * @Description: 查询当前用户需要审批的信息
	 * @param @param page
	 * @param @param rows
	 * @param @param session
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	@RequestMapping("approverOnw.action")
	@ResponseBody
	public Map<String,Object> approverOnw(int page,int rows,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return fs.approverOnw(page, rows, user.getName());
	}
	/**
	 * 
	 * @Description: 新增一条反馈信息
	 * @param @param f
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	@RequestMapping("/addFeedback.action")
	@ResponseBody
	public int addFeedback(Feedback f){
		return fs.addFeedback(f);
	}
	
	/**
	 * 
	 * @Description: 审批方法
	 * @param @param feedbackId
	 * @param @param session
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	@RequestMapping("approver.action")
	@ResponseBody
	public int appover(int feedbackId,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return fs.approver(feedbackId, user.getId());
	}
	/**
	 * 
	 * @Description: 打回一条消息
	 * @param @param feedbackId
	 * @param @param refuseInfo
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	@RequestMapping("/refuse.action")
	@ResponseBody
	public int refuse(int feedbackId,String refuseInfo){
		return fs.refuse(feedbackId, refuseInfo);
	}
}
