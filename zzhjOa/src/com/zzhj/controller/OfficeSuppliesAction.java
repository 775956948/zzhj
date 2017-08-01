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
	 * @Description: 添加一个物品
	 * @param @param o
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	
	@RequestMapping("/saveOfficeSupplies.action")
	@ResponseBody
	public int saveOfficeSupplies(OfficeSupplies o){
		return oss.saveOfficeSupplies(o);
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
	@RequestMapping("/updateOfficeSupplies.action")
	@ResponseBody
	public int updateOfficeSupplies(OfficeSupplies o){
		return oss.updateOfficeSupplies(o);
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
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int rows,int page){
		return oss.queryAll(rows, page);
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
	@RequestMapping("/reduce.action")
	@ResponseBody
	public int reduce(int number,int id){
		return oss.reduce(number, id);
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
	@RequestMapping("/likeQuey.action")
	@ResponseBody
	public  Map<String,Object> likeQuey(String goodsName){
		return oss.likeQuey(goodsName);
	}
	/**
	 * 
	 * @Description: 删除一天信息同时级联删除所有关联的信息
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年8月1日
	 */
	@RequestMapping("/deleteGoods.action")
	@ResponseBody
	public int deleteGoods(int id){
		return oss.deleteGoods(id);
	}
}
