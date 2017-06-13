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
	 * @Description:���һ������������Ϣ
	 * @param @param t
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
	 */
	public int addTask(Task t){
		Date d = new Date();
		String taskDate=DateFormater.format(d);
		t.setTaskDate(taskDate);
		int result=tm.addTask(t);
/*		if(result>0){
			Message mes = new Message();
			mes.setFrom(t.getRecipient());
			mes.setTargetName("�´�����");
			send(mes, t.getUserName());
		}*/
		return result;
	}
	/**
	 * 
	 * @Description: �´�һ������
	 * @param @param taskId
	 * @param @param userId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
	 */
	public int transmitTask(int taskId,String userName){
		return tm.transmitTask(taskId, userName);
	}
	 /**
	  * 
	  * @Description: ���գ���ʼִ��һ������
	  * @param @param taskId
	  * @param @param startDate
	  * @param @return   
	  * @return int  
	  * @throws
	  * @author С��
	  * @date 2017��6��12��
	  */
	public int acceptTask(int taskId){
		Date d = new Date();
		String startDate=DateFormater.format(d);
		return tm.acceptTask(taskId, startDate);
	}
	
	/**
	 * 
	 * @Description: �������
	 * @param @param taskId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
	 */
	public int successTask(int taskId){
		Date d = new Date();
		String successDate=DateFormater.format(d);
		return tm.successTask(taskId, successDate);
	}
	/**
	 * 
	 * @Description: �޸Ĺ�������
	 * @param @param taskId
	 * @param @param speed
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
	 */
	public int updateTaskSpeed(int taskId,int speed){
		return tm.updateTaskSpeed(taskId, speed);
	}
	/**
	 * 
	 * @Description: �鿴���й���������Ϣ
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<Task>  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
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
	 * @Description: �鿴�����Լ�������
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<Task>  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
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
	 * @Description: �޸�������Ϣ��ĳЩ�ֶ�
	 * @param @param t
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��13��
	 */
	public int updateTask(Task t){
		return tm.updateTask(t);
	}
	
	private void send(Message mes,String userName){
		ServerHandler.send(userName, mes);
	}
}
