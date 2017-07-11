package com.zzhj.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.mapper.RequestGoodsMapper;
import com.zzhj.po.RequestGoods;

import utils.DateFormater;

@Service
public class RequestGoodsService {
	
	@Autowired
	private RequestGoodsMapper rgm;
	
	
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
	public int saveRequestGoods(RequestGoods g){
		g.setState("待审批");
		g.setRequestDate(DateFormater.format(new Date()));
		return rgm.saveRequestGoods(g);
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
	public Map<String,Object> queryAll(int page,int rows){
		Map<String,Object> map = new HashMap<String,Object>();
		int startPage =(page-1)*rows;
		List<RequestGoods> list = rgm.queryAll(startPage, rows);
		map.put("rows", list);
		map.put("total", rgm.totalCount());
		return map;
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
	public Map<String,Object>  queryOwnAll(int userId,int page,int rows){
		Map<String,Object> map = new HashMap<String,Object>();
		int startPage =(page-1)*rows;
		List<RequestGoods> list = rgm.queryOwnAll(userId, startPage, rows);
		map.put("rows", list);
		map.put("total", rgm.totalCount());
		return map;
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
	public int approver(int id){
		String date =DateFormater.format(new Date());
		return rgm.approver(id, date);
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
	public int delete(int id){
		return rgm.delete(id);
	}


}
