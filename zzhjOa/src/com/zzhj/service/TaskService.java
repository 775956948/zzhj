package com.zzhj.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.entityCustom.Message;
import com.zzhj.mapper.TaskMapper;
import com.zzhj.po.Task;
import com.zzhj.webSocket.ServerHandler;

import utils.DateFormater;

@Service
public class TaskService {
		
	
	@Autowired
	private TaskMapper tm;
	
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
	public int addTask(Task t){
		Date d = new Date();
		String taskDate=DateFormater.format(d);
		t.setTaskDate(taskDate);
		int result=tm.addTask(t);
/*		if(result>0){
			Message mes = new Message();
			mes.setFrom(t.getRecipient());
			mes.setTargetName("下达任务");
			send(mes, t.getUserName());
		}*/
		return result;
	}
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
	public int transmitTask(int taskId,String userName){
		return tm.transmitTask(taskId, userName);
	}
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
	public int acceptTask(int taskId){
		Date d = new Date();
		String startDate=DateFormater.format(d);
		return tm.acceptTask(taskId, startDate);
	}
	
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
	public int successTask(int taskId){
		Date d = new Date();
		String successDate=DateFormater.format(d);
		return tm.successTask(taskId, successDate);
	}
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
	public int updateTaskSpeed(int taskId,int speed){
		return tm.updateTaskSpeed(taskId, speed);
	}
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
	public Map<String,Object> queryAll(int page,int rows){
		int startPage=(page-1)*rows;
		List<Task> list= tm.queryAll(startPage, rows);
		int total=tm.totalCount();
		Map<String,Object> map = new HashMap();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
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
	public Map<String,Object> queryOwn(int page,int rows,String userName){
		int startPage=(page-1)*rows;
		List<Task> list= tm.queryOwn(startPage, rows, userName);
		int total =tm.totalCOuntOwn(userName);
		Map<String,Object> map = new HashMap();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	/**
	 * 
	 * @Description: 修改任务信息的某些字段
	 * @param @param t
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月13日
	 */
	public int updateTask(Task t){
		return tm.updateTask(t);
	}
	
	private void send(Message mes,String userName){
		ServerHandler.send(userName, mes);
	}
}
