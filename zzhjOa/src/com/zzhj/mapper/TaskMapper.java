package com.zzhj.mapper;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.Task;

/**
 * 
 * @author asus
 * 工作任务dao层接口
 */
public interface TaskMapper {
	/**
	 * 
	 * @Description:添加一个工作任务信息
	 * @param @param t
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月12日
	 */
	int addTask(Task t);
	/**
	 * 
	 * @Description: 下达一个任务
	 * @param @param taskId
	 * @param @param userId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月12日
	 */
	int transmitTask(@Param("taskId")int taskId,@Param("userName")String userName);
	 /**
	  * 
	  * @Description: 接收，开始执行一个任务
	  * @param @param taskId
	  * @param @param startDate
	  * @param @return   
	  * @return int  
	  * @throws
	  * @author 小白
	  * @date 2017年6月12日
	  */
	int acceptTask(@Param("taskId")int taskId,@Param("startDate")String startDate);
	
	/**
	 * 
	 * @Description: 完成任务
	 * @param @param taskId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月12日
	 */
	int successTask(@Param("taskId")int taskId,@Param("successDate")String successDate);
	/**
	 * 
	 * @Description: 修改工作进度
	 * @param @param taskId
	 * @param @param speed
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月12日
	 */
	int updateTaskSpeed(@Param("taskId")int taskId,@Param("speed")int speed);
	/**
	 * 
	 * @Description: 查看所有工作任务信息
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<Task>  
	 * @throws
	 * @author 小白
	 * @date 2017年6月12日
	 */
	List<Task> queryAll(@Param("startpage")int startPage,@Param("rows")int rows);
	/**
	 * 
	 * @Description: 查看属于自己的任务
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<Task>  
	 * @throws
	 * @author 小白
	 * @date 2017年6月12日
	 */
	List<Task> queryOwn(@Param("startpage")int startPage,@Param("rows")int rows,@Param("userName")String userName);
	/**
	 * 
	 * @Description: 返回任务条数
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月12日
	 */
	int totalCount();
	/**
	 * 
	 * @Description: 返回自己的任务条数
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月12日
	 */
	int totalCOuntOwn(String name);
}
