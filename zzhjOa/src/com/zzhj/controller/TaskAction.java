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
	@RequestMapping("/addTask.action")
	@ResponseBody
	public int addTask(Task t,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		t.setUserName(user.getName());
		return ts.addTask(t);
	}
	@RequestMapping("/transmitTask.action")
	@ResponseBody
	public int transmitTask(int taskId,String userName){
		return ts.transmitTask(taskId, userName);
	}
	@RequestMapping("/acceptTask.action")
	@ResponseBody
	public int acceptTask(int taskId){
		return ts.acceptTask(taskId);
	}
	@RequestMapping("/successTask.action")
	@ResponseBody
	public int successTask(int taskId){
		return ts.successTask(taskId);
	}
	@RequestMapping("/updateTaskSpeed.action")
	@ResponseBody
	public int updateTaskSpeed(int taskId,int speed){
		return ts.updateTaskSpeed(taskId, speed);
	}
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int page,int rows){
		return ts.queryAll(page, rows);
	}
	@RequestMapping("/queryOwn.action")
	@ResponseBody
	public Map<String,Object> queryOwn(int page,int rows,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return ts.queryOwn(page, rows, user.getName());
	}
	@RequestMapping("updateTask.action")
	@ResponseBody
	public int updateTask(Task t){
		return ts.updateTask(t);
	}
}
