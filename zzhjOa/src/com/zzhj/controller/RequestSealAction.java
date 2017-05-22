package com.zzhj.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.RequestSeal;
import com.zzhj.po.Users;
import com.zzhj.po.ZiZhiSeal;
import com.zzhj.service.RequestSealService;
@Controller
@RequestMapping("/requestSeal")
public class RequestSealAction {
	@Resource(name="requestSealService")
	private RequestSealService rss;
	
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int page,int rows){
		return rss.queryAll(page,rows);
	}
	
	@RequestMapping("/save.action")
	@ResponseBody
	public int save(RequestSeal r,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		r.setUserId(user);
		return rss.save(r);
	}
	
	@RequestMapping("/approver.action")
	@ResponseBody
	public int approver(int requestSealId,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return rss.approver(requestSealId, user.getId());
	}
	
	@RequestMapping("/queryOneself.action")
	@ResponseBody
	public Map<String,Object> queryOneself(int page,int rows,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return rss.queryOneself(user.getName(), page, rows);
	}
	
	@RequestMapping("/approverRequestSeal.action")
	@ResponseBody
	public Map<String,Object> approverRequestSeal(int page,int rows){
		return rss.approverRequestSeal(page, rows);
	}
	
	@RequestMapping("/handLing.action")
	@ResponseBody
	public int handLing(RequestSeal r,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		r.setAgent(user.getName());
		return rss.handLing(r);
	}
}
