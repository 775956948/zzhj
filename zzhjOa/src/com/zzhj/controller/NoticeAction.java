package com.zzhj.controller;

import java.util.List;
import java.util.Map;

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
	/**
	 * 
	 * @Description: ��ҳ��ѯ���й�����Ϣ
	 * @param @param rows
	 * @param @param page
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author С��
	 * @date 2017��6��22��
	 */
	@RequestMapping("/queryAllList.action")
	@ResponseBody
	public Map<String,Object> queryAllList(int rows,int page){
		return ns.queryAllList(page, rows);
	}
	/**
	 * 
	 * @Description: ����idɾ��һ��������Ϣ
	 * @param @param noticeId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��22��
	 */
	@RequestMapping("deleteNotice.action")
	@ResponseBody
	public int deleteNotice(int noticeId){
		return ns.deleteNotice(noticeId);
	}
}
