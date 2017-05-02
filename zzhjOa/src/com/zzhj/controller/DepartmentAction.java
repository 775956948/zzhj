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
	public ModelAndView queryAll(){
		List<Department> list= ds.queryAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("department", list);
		mv.setViewName("/registered.jsp");
		return mv;
	}
}
