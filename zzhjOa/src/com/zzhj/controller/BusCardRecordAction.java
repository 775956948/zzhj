package com.zzhj.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.BusCardRecord;
import com.zzhj.po.Users;
import com.zzhj.service.BusCardRecordService;

@Controller
@RequestMapping("/busCardRecord")
public class BusCardRecordAction {
	
	@Autowired
	private BusCardRecordService bcrs;
	
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int page,int rows){
		return bcrs.queryAll(page, rows);
	}
	
	@RequestMapping("/save.action")
	@ResponseBody
	public int save(BusCardRecord b,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		b.setUserId(user);
		return bcrs.save(b);
	}
	@RequestMapping("/update.action")
	@ResponseBody
	public int update(BusCardRecord b){
		return bcrs.update(b);
	}
	@RequestMapping("/delete.action")
	@ResponseBody
	public int delete(int id){
		return bcrs.delete(id);
	}
}
