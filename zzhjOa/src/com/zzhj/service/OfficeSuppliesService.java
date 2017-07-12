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
	 * @Description: ���һ����Ʒ
	 * @param @param o
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	public int saveOfficeSupplies(OfficeSupplies o){
		o.setGoodsDate(DateFormater.format(new Date()));
		return osm.saveOfficeSupplies(o);
	}
	/**
	 * 
	 * @Description: �޸���Ʒ��Ϣ
	 * @param @param o
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	public int updateOfficeSupplies(OfficeSupplies o){
		return osm.updateOfficeSupplies(o);
	}
	/**
	 * 
	 * @Description: ��ѯ������Ʒ��Ϣ
	 * @param @param rows
	 * @param @param startPage
	 * @param @return   
	 * @return List<OfficeSupplies>  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
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
	 * @Description: ��Ʒ����
	 * @param @param number
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	public int reduce(int number,int id){
		int goodsNumber = osm.balance(id);
		int newGoodsNumber =goodsNumber-number;
		return osm.reduce(newGoodsNumber, id);
	}
	/**
	 * 
	 * @Description: ģ����ѯ��Ʒ
	 * @param @param goodsName
	 * @param @return   
	 * @return List<OfficeSupplies>  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	public  Map<String,Object> likeQuey(String goodsName){
		Map<String,Object> map = new HashMap<String,Object>();
		List<OfficeSupplies> list = osm.likeQuey(goodsName);
		map.put("rows",list);
		return map;
	}
	/**
	 * 
	 * @Description: ɾ��һ����Ʒ������ɾ������������
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��12��
	 */
	public int deleteCascade(int id){
		return osm.deleteCascade(id);
	}
}
