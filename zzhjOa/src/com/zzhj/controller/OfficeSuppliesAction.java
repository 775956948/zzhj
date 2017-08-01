package com.zzhj.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.OfficeSupplies;
import com.zzhj.service.OfficeSuppliesService;
@Controller
@RequestMapping("/officeSupplies")
public class OfficeSuppliesAction {
	
	@Autowired
	private OfficeSuppliesService oss;
	
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
	
	@RequestMapping("/saveOfficeSupplies.action")
	@ResponseBody
	public int saveOfficeSupplies(OfficeSupplies o){
		return oss.saveOfficeSupplies(o);
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
	@RequestMapping("/updateOfficeSupplies.action")
	@ResponseBody
	public int updateOfficeSupplies(OfficeSupplies o){
		return oss.updateOfficeSupplies(o);
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
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int rows,int page){
		return oss.queryAll(rows, page);
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
	@RequestMapping("/reduce.action")
	@ResponseBody
	public int reduce(int number,int id){
		return oss.reduce(number, id);
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
	@RequestMapping("/likeQuey.action")
	@ResponseBody
	public  Map<String,Object> likeQuey(String goodsName){
		return oss.likeQuey(goodsName);
	}
	/**
	 * 
	 * @Description: ɾ��һ����Ϣͬʱ����ɾ�����й�������Ϣ
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��8��1��
	 */
	@RequestMapping("/deleteGoods.action")
	@ResponseBody
	public int deleteGoods(int id){
		return oss.deleteGoods(id);
	}
}
