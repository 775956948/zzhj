package com.zzhj.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.JobLog;
import com.zzhj.po.Users;
import com.zzhj.service.JobLogService;

@Controller
@RequestMapping("/jobLog")
public class JobLogAction {
	@Resource(name="jobLogService")
	private JobLogService jls;
	
	@RequestMapping("/saveJobLog.action")
	@ResponseBody
	public int saveJobLog(JobLog jobLog,HttpSession session){
		Date today=new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		String time=f.format(today);
		jobLog.setDate(time);
		Users user = (Users) session.getAttribute("users");
		jobLog.setUser(user);
		return jls.saveJobLig(jobLog);
	}
	
	@RequestMapping("/query.action")
	@ResponseBody
	public List<JobLog> query(int page,int rows,int id){
		return jls.query(id, rows, page);
	}
	@RequestMapping("/searchJobLog.action")
	@ResponseBody
	public Map search(JobLog jobLog,int rows,int page){
		List<JobLog> list=jls.search(rows, page, jobLog);
		Map m = new HashMap();
		m.put("total", list.size());
		m.put("rows",list);
		return m;
	}
	
	@RequestMapping("/deleteJobLog.action")
	@ResponseBody
	public int deleteJobLog(int id){
		return jls.deleteJobLog(id);
	}
	
}
