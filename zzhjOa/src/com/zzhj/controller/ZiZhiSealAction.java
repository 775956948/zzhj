package com.zzhj.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.Users;
import com.zzhj.po.ZiZhiSeal;
import com.zzhj.service.ZiZhiSealService;

@Controller
@RequestMapping("/ziZhiSeal")
public class ZiZhiSealAction {

	@Resource(name="ziZhiSealService")
	ZiZhiSealService zs;
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int page,int rows){
		return zs.queryAll(page,rows);
	}
	
	@RequestMapping("/save.action")
	@ResponseBody
	public int save(ZiZhiSeal z,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		z.setUserId(user);
		return zs.save(z);
	}
	@RequestMapping("/delete.action")
	@ResponseBody
	public int delete(int id){
		return zs.delete(id);
	}
	
	@RequestMapping("/queryOneself.action")
	@ResponseBody
	public Map<String,Object> queryOneself(int userId,int page,int rows){
		return zs.queryOneself(userId, page, rows);
	}
}
