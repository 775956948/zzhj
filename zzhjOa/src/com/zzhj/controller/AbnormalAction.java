package com.zzhj.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zzhj.po.Abnormal;

import com.zzhj.po.Users;
import com.zzhj.service.AbnormalService;


@Controller
@RequestMapping("/abnormal")
public class AbnormalAction {
	@Resource(name="abnormalService")
	private AbnormalService as;
	
	@RequestMapping("/save.action")
	@ResponseBody
	public int save(Abnormal abnormal,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		abnormal.setUserId(user);
		abnormal.setState("´ýÉóÅú");
		Date today = new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time=f.format(today);
		abnormal.setDate(time);
		return as.save(abnormal);
	}
	@RequestMapping("queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int page,int rows){
		return as.queryAll(page, rows);
	}
	
	@RequestMapping("/deleteAbnormal.action")
	@ResponseBody
	public int deleteRest(int id){
		return as.deleteRest(id);
	}
	
	
}
