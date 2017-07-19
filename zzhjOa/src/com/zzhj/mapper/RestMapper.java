package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.Rest;

/**
 * 
 * @author 小白
 * @date 2017年4月27日
 * @Description: TODO
 * @version 1.0
 */
public interface RestMapper {
	int save(Rest rest);
	/**
	 * 
	 * @Description: 查看自己的请假信息
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<Rest>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月17日
	 */
	List<Rest> queryOwn(@Param("startPage") int startPage,@Param("rows") int rows,@Param("userName")String userName);
	int totalCount();
	/**
	 * 
	 * @Description: 根据id删除一条信息
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月18日
	 */
	int deleteRest(int id);
	/**
	 * 
	 * @Description: 查询审批人是当前登陆用户的总条数
	 * @param @param userName
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月18日
	 */
	int totalCountApproverOnw(@Param("userName")String userName);
	/**
	 * 
	 * @Description: 查询审批人是当前登陆用户的信息
	 * @param @param startPage
	 * @param @param rows
	 * @param @param userName
	 * @param @return   
	 * @return List<Rest>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月18日
	 */
	List<Rest> approverOwn(@Param("startPage") int startPage,@Param("rows") int rows,@Param("userName")String userName);
	/**
	 * 
	 * @Description: 审批方法
	 * @param @param restId
	 * @param @param approverName
	 * @param @param state
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月19日
	 */
	int approver(@Param("restId")int restId,@Param("approverName")String approverName,@Param("state")String state);
	/**
	 * 
	 * @Description: 组合查询
	 * @param @param date
	 * @param @param userName
	 * @param @return   
	 * @return List<Rest>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月19日
	 */
	List<Rest> combinationQuery(@Param("date")String date,@Param("userName")String userName);
	
	List<Rest> queryAll(@Param("startPage")int startPage,@Param("rows")int rows);
	
}
