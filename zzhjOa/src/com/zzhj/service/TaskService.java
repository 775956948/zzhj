package com.zzhj.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.collections.SynchronizedQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.entityCustom.Message;
import com.zzhj.entityCustom.MessageType;
import com.zzhj.mapper.TaskMapper;
import com.zzhj.mapper.UsersMapper;
import com.zzhj.po.Task;
import com.zzhj.webSocket.ServerHandler;

import utils.DateFormater;

@Service
public class TaskService {
		
	
	@Autowired
	private  TaskMapper tm;
	
	@Autowired
	private UsersMapper um;
	
	/**
	 * 
	 * @Description:���һ������������Ϣ�����´�����ܻ��߲��ž���
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
		if(result>0){
			Message mes = new Message();
			mes.setFrom(t.getUserName());
			mes.setTargetName("�´�����");
			mes.setViewTarget("task/queryOwnTask.html");
			mes.setType(MessageType.task);
			mes.setContentId(t.getId());
			mes.setTheme("����δ�����������Ϣ");
			send(mes,t.getRecipient());
		}

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
	public int transmitTask(int taskId,String userName,String successDate,String implementDate){
		int result=tm.transmitTask(taskId, userName,successDate,implementDate);
		String recipient=tm.queryRecipient(taskId);
		if(result>0){
			Message mes = new Message();
			mes.setFrom(recipient);
			mes.setTargetName("��������");
			mes.setViewTarget("task/OwnTask.html");
			mes.setType(MessageType.task);
			mes.setContentId(taskId);
			mes.setTheme("����δ�����������Ϣ");
			send(mes,userName);
		}
		return result;
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
	public int updateTaskSpeed(int taskId,int speed,String taskPhase,String userName){
		
		int resoult =tm.updateTaskSpeed(taskId, speed,taskPhase);
		if(resoult>0&&speed>=100){
			Message mes = new Message();
			mes.setFrom(userName);
			mes.setTargetName("�����������");
			mes.setViewTarget("task/qualityTask.html");
			mes.setType(MessageType.task);
			mes.setContentId(taskId);
			mes.setTheme("����δ�����������Ϣ");
			List<String> list =um.queryDepartmentAndRole("��沿","�ʼ�");
			for(String name : list){
				send(mes,name);
			}
			
		}		
		return resoult; 
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
	public Map<String,Object> queryAll(int page,int rows,String userName){
		int startPage=(page-1)*rows;
		List<Task> list= tm.queryAll(startPage, rows,userName);
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
	/**
	 * 
	 * @Description: ɾ��һ������
	 * @param @param taskId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��21��
	 */
	public int deleteTask(int taskId){
		return tm.deleteTask(taskId);
	}
	
	/**
	 * 
	 * @Description: ���ص�ǰ�û�ִ�������Լ�����Ϣ
	 * @param @param userName
	 * @param @return   
	 * @return List<Task>  
	 * @throws
	 * @author С��
	 * @date 2017��6��22��
	 */
	public List<Task> queryImplementOwn(String userName){
		return tm.queryImplementOwn(userName);
	}
	public int updateTaskTime(Task t){
		return tm.updateTaskTime(t);
	}
	/**
	 * 
	 * @Description: �����������Ϊ100%������
	 * @param @param page
	 * @param @param rows
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author С��
	 * @date 2017��7��5��
	 */
	public Map<String,Object> querySuccessTask(int page,int rows){
		int startPage=(page-1)*rows;
		List<Task> list= tm.querySuccessTask(startPage, rows);
		int total=tm.totalCountSuccess();
		Map<String,Object> map = new HashMap();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	public int qualifiedTask(int id,String userName){
		String date =DateFormater.format(new Date());
		String overDate=tm.queryOverDate(id);
		int resoult =date.compareTo(overDate);
		String message="";
		if(resoult>0){
			message="�������";
		}else if(resoult==0){
			message="��ʱ���";
		}else{
			message="��ǰ���";
		}
		return tm.qualifiedTask(id, userName, message);
	}
	
	/**
	 * 
	 * @Description: �ʼ첻�ϸ�
	 * @param @param userName
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��5��
	 */
	public int UnqualifiedTask(String userName,int id){
		return tm.UnqualifiedTask(id, userName);
	}
	
	/**
	 * 
	 * @Description: ֪ͨ����
	 * @param @param mes
	 * @param @param userName   
	 * @return void  
	 * @throws
	 * @author С��
	 * @date 2017��6��22��
	 */
	private void send(Message mes,String userName){
		ServerHandler.send(userName, mes);
	}
	
	
}
