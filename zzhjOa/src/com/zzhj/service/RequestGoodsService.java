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
	 * @Description: ���һ������
	 * @param @param g
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	public int saveRequestGoods(RequestGoods g){
		g.setState("������");
		g.setRequestDate(DateFormater.format(new Date()));
		return rgm.saveRequestGoods(g);
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
	 * @Description: �鿴�Լ������뵥
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<RequestGoods>  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
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
	 * @Description: ����������
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	public int approver(int id){
		String date =DateFormater.format(new Date());
		return rgm.approver(id, date);
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
	public int delete(int id){
		return rgm.delete(id);
	}


}
