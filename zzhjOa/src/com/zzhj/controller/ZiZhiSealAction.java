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
	/**
	 * 
	 * @Description: 查看所有信息
	 * @param @param page
	 * @param @param rows
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author 小白
	 * @date 2017年8月21日
	 */
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
	public Map<String,Object> queryOneself(int page,int rows,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return zs.queryOneself(user.getName(), page, rows);
	}
	
	@RequestMapping("/queryOneOneself.action")
	@ResponseBody
	public ZiZhiSeal queryOneOneself(int id){
		return zs.queryOneOneself(id);
	}
	@RequestMapping("/approver.action")
	@ResponseBody
	public int approver(int sealId,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return zs.approver(sealId, user.getId());
	}
	
	@RequestMapping("/approverZiZhiSeal.action")
	@ResponseBody
	public Map<String,Object> approverZiZhiSeal(int page,int rows){
		return zs.approverZiZhiSeal(page, rows);
	}
	
	@RequestMapping("/handLing.action")
	@ResponseBody
	public int handLing(ZiZhiSeal z,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		z.setAgent(user.getName());
		return zs.handLing(z);
	}
	/**
	 * 
	 * @Description: 修改章内容
	 * @param @param z
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年8月7日
	 */
	@RequestMapping("/updateZiZhiSeal.action")
	@ResponseBody
	public int updateZiZhiSeal(ZiZhiSeal z){
		return zs.updateZiZhiSeal(z);
	}
	
}
