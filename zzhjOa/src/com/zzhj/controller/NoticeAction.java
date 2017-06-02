package com.zzhj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.Notice;
import com.zzhj.po.Users;
import com.zzhj.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeAction {
	@Autowired
	private NoticeService ns;
	
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public List<Notice> queryAll(){
		return ns.queryAll();
	}
	
	@RequestMapping("/save.action")
	@ResponseBody
	public int save(Notice n,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		n.setUserId(user);
		return ns.save(n);
	}
	@RequestMapping("/queryOne.action")
	public String queryOne(int id,HttpSession session){
		Notice n =ns.queryOne(id);
		session.setAttribute("notice",n);
		return"/notice/showNotice.jsp";
	}
}
