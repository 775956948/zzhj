package com.zzhj.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.mapper.RequestGoodsMapper;
import com.zzhj.po.RequestGoods;
import com.zzhj.po.Users;
import com.zzhj.service.RequestGoodsService;

import utils.DateFormater;

@Controller
@RequestMapping("/requestGoods")
public class RequestGoodsAction {

	
	@Autowired
	private RequestGoodsService rgs;
	
	
	/**
	 * 
	 * @Description: 添加一天申请
	 * @param @param g
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	@RequestMapping("/saveRequestGoods.action")
	@ResponseBody
	public int saveRequestGoods(RequestGoods g,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		g.setUserId(user);
		return rgs.saveRequestGoods(g);
	}
	
	/**
	 * 
	 * @Description: 查看所有申请单
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<RequestGoods>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int page,int rows){

		return rgs.queryAll(page, rows);
	}
	/**
	 * 
	 * @Description: 查看自己的申请单
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<RequestGoods>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	@RequestMapping("/queryOwnAll.action")
	@ResponseBody
	public Map<String,Object>  queryOwnAll(HttpSession session,int page,int rows){
		Users user = (Users) session.getAttribute("users");
		return rgs.queryOwnAll(user.getId(), page, rows);
	}
	/**
	 * 
	 * @Description: 审批报销单
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	@RequestMapping("/approver.action")
	@ResponseBody
	public int approver(int id){
		return rgs.approver(id);
	}
	
	/**
	 * 
	 * @Description: 删除一个申请单
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	@RequestMapping("/delete.action")
	@ResponseBody
	public int delete(int id){
		return rgs.delete(id);
	}
	
}
