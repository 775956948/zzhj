package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.OfficeSupplies;

public interface OfficeSuppliesMapper {
	
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
	public int saveOfficeSupplies(OfficeSupplies o);
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
	public int updateOfficeSupplies(OfficeSupplies o);
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
	public List<OfficeSupplies> queryAll(@Param("rows")int rows,@Param("startPage")int startPage);
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
	public int reduce(@Param("number")int number,@Param("id")int id);
	/**
	 * 
	 * @Description: 返回物品的库存数
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	public int balance(int id);
	/**
	 * 
	 * @Description: 得到总条数
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	public int totalCount();
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
	public List<OfficeSupplies> likeQuey(String goodsName);
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
	public int deleteGoods(int id);
	
	
}
