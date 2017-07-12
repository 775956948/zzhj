package com.zzhj.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.mapper.OfficeSuppliesMapper;
import com.zzhj.po.OfficeSupplies;

import utils.DateFormater;
@Service
public class OfficeSuppliesService {
	
	@Autowired
	private OfficeSuppliesMapper osm;
	
	/**
	 * 
	 * @Description: 添加一个物品
	 * @param @param o
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	public int saveOfficeSupplies(OfficeSupplies o){
		o.setGoodsDate(DateFormater.format(new Date()));
		return osm.saveOfficeSupplies(o);
	}
	/**
	 * 
	 * @Description: 修改物品信息
	 * @param @param o
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	public int updateOfficeSupplies(OfficeSupplies o){
		return osm.updateOfficeSupplies(o);
	}
	/**
	 * 
	 * @Description: 查询所有物品信息
	 * @param @param rows
	 * @param @param startPage
	 * @param @return   
	 * @return List<OfficeSupplies>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	public Map<String,Object> queryAll(int rows,int page){
		int startPage =(page-1)*rows;
		Map<String,Object> map = new HashMap<>();
		List<OfficeSupplies> list =osm.queryAll(rows, startPage);
		int totalCount =osm.totalCount();
		map.put("rows", list);
		map.put("total", totalCount);
		return map;
	}
	/**
	 * 
	 * @Description: 物品出库
	 * @param @param number
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	public int reduce(int number,int id){
		int goodsNumber = osm.balance(id);
		int newGoodsNumber =goodsNumber-number;
		return osm.reduce(newGoodsNumber, id);
	}
	/**
	 * 
	 * @Description: 模糊查询物品
	 * @param @param goodsName
	 * @param @return   
	 * @return List<OfficeSupplies>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	public  Map<String,Object> likeQuey(String goodsName){
		Map<String,Object> map = new HashMap<String,Object>();
		List<OfficeSupplies> list = osm.likeQuey(goodsName);
		map.put("rows",list);
		return map;
	}
	/**
	 * 
	 * @Description: 删除一个物品，级联删除所有子数据
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月12日
	 */
	public int deleteCascade(int id){
		return osm.deleteCascade(id);
	}
}
