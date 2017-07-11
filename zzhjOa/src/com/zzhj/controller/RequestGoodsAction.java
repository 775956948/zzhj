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
	 * @Description: ���һ������
	 * @param @param g
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
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
	 * @Description: �鿴�������뵥
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<RequestGoods>  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int page,int rows){

		return rgs.queryAll(page, rows);
	}
	/**
	 * 
	 * @Description: �鿴�Լ������뵥
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<RequestGoods>  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	@RequestMapping("/queryOwnAll.action")
	@ResponseBody
	public Map<String,Object>  queryOwnAll(HttpSession session,int page,int rows){
		Users user = (Users) session.getAttribute("users");
		return rgs.queryOwnAll(user.getId(), page, rows);
	}
	/**
	 * 
	 * @Description: ����������
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	@RequestMapping("/approver.action")
	@ResponseBody
	public int approver(int id){
		return rgs.approver(id);
	}
	
	/**
	 * 
	 * @Description: ɾ��һ�����뵥
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	@RequestMapping("/delete.action")
	@ResponseBody
	public int delete(int id){
		return rgs.delete(id);
	}
	
}
