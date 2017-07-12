package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.RequestGoods;

public interface RequestGoodsMapper {
	
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
	int saveRequestGoods(RequestGoods g);
	
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
	List<RequestGoods> queryAll(@Param("startPage")int startPage,@Param("rows")int rows);
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
	List<RequestGoods> queryOwnAll(@Param("userId")int userId,@Param("startPage")int startPage,@Param("rows")int rows);
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
	int approver(@Param("id")int id,@Param("date")String date,@Param("approverName")String approverName);
	
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
	int delete(int id);
	/**
	 * 
	 * @Description: 查询总条数
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	int totalCount();
	/**
	 * 
	 * @Description: 查询自己申请的总条数
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	int totalOwnCont();
	/**
	 * 
	 * @Description: 根据申请人模糊查询
	 * @param @param userName
	 * @param @return   
	 * @return List<RequestGoods>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月11日
	 */
	List<RequestGoods> likeUserQueryAll(String userName);
	/**
	 * 
	 * @Description: 根据申请单id拿到物品id
	 * @param @param id
	 * @param @return   
	 * @return RequestGoods  
	 * @throws
	 * @author 小白
	 * @date 2017年7月12日
	 */
	RequestGoods queryId(int id);
}
