package com.zzhj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.web.servlet.ModelAndView;

import com.zzhj.po.Department;
import com.zzhj.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentAction {
	@Resource(name="departmentService")
	private DepartmentService ds;
	
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public List<Department> queryAll(){
		List<Department> list= ds.queryAll();
		return list;
	}
	
	@RequestMapping("/departmentInfo.action")
	@ResponseBody
	public List<Department> departmentInfo(){
		return ds.queryAll();
	}
}
