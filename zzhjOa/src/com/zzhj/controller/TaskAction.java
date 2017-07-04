package com.zzhj.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.Task;
import com.zzhj.po.Users;
import com.zzhj.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskAction {
	@Autowired
	private TaskService ts;
	/**
	 * 
	 * @Description: ���һ��������Ϣ
	 * @param @param t
	 * @param @param session
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��13��
	 */
	@RequestMapping("/addTask.action")
	@ResponseBody
	public int addTask(Task t,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		t.setUserName(user.getName());
		return ts.addTask(t);
	}
	/**
	 * 
	 * @Description: �´�һ��������Ϣ
	 * @param @param taskId
	 * @param @param userName
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��13��
	 */
	@RequestMapping("/transmitTask.action")
	@ResponseBody
	public int transmitTask(int taskId,String implement,String successDate,String implementDate){
		return ts.transmitTask(taskId, implement,successDate,implementDate);
	}
	/**
	 * 
	 * @Description: ���ܿ�ʼִ��һ������
	 * @param @param taskId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��13��
	 */
	@RequestMapping("/acceptTask.action")
	@ResponseBody
	public int acceptTask(int taskId){
		return ts.acceptTask(taskId);
	}
	/**
	 * 
	 * @Description: ��������ύ
	 * @param @param taskId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��13��
	 */
	@RequestMapping("/successTask.action")
	@ResponseBody
	public int successTask(int taskId){
		return ts.successTask(taskId);
	}
	/**
	 * 
	 * @Description: �޸��������
	 * @param @param taskId
	 * @param @param speed
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��13��
	 */
	@RequestMapping("/updateTaskSpeed.action")
	@ResponseBody
	public int updateTaskSpeed(int taskId,int speed,String taskPhase){
		return ts.updateTaskSpeed(taskId, speed,taskPhase);
	}
	/**
	 * 
	 * @Description: ��ѯ����������Ϣ
	 * @param @param page
	 * @param @param rows
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author С��
	 * @date 2017��6��13��
	 */
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int page,int rows){
		return ts.queryAll(page, rows);
	}
	/**
	 * 
	 * @Description: ��ѯ�����Լ���������Ϣ
	 * @param @param page
	 * @param @param rows
	 * @param @param session
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author С��
	 * @date 2017��6��13��
	 */
	@RequestMapping("/queryOwn.action")
	@ResponseBody
	public Map<String,Object> queryOwn(int page,int rows,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return ts.queryOwn(page, rows, user.getName());
	}
	/**
	 * 
	 * @Description: �޸�����ĳ����Ϣ
	 * @param @param t
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��13��
	 */
	@RequestMapping("updateTask.action")
	@ResponseBody
	public int updateTask(Task t){
		System.out.println(t.getId());
		return ts.updateTask(t);
	}
	
	@RequestMapping("/deleteTask.action")
	@ResponseBody
	public int deleteTask(int taskId){
		return ts.deleteTask(taskId);
	}
	
	/**
	 * 
	 * @Description: ����ִ�����ǵ�ǰ�û��ķ���������Ϣ
	 * @param @param session
	 * @param @return   
	 * @return List<Task>  
	 * @throws
	 * @author С��
	 * @date 2017��6��22��
	 */
	@RequestMapping("/queryImplementOwn.action")
	@ResponseBody
	public List<Task> queryImplementOwn(HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return ts.queryImplementOwn(user.getName());
	}
}
