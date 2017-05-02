package com.zzhj.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.Rest;
import com.zzhj.po.Users;
import com.zzhj.service.RestService;

@Controller
@RequestMapping("/rest")
public class RestAction {

	@Resource(name="restService")
	private RestService rs;
	
	@RequestMapping("/save.action")
	@ResponseBody
	public int save(Rest rest,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		rest.setUserId(user);
		rest.setState("´ýÉóÅú");
		Date today=new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time=f.format(today);
		rest.setDate(time);
		return rs.save(rest);
	}
	@RequestMapping("queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int page,int rows){
		return rs.queryAll(page, rows);
	}
	
	@RequestMapping("/deleteRest.action")
	@ResponseBody
	public int deleteRest(int id){
		return rs.deleteRest(id);
	}
	
}
