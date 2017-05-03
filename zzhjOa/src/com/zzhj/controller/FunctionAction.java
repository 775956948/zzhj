package com.zzhj.controller;



import java.util.List;
import java.util.Stack;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.*;
import com.zzhj.service.FunctionService;

@Controller
@RequestMapping("/function")
public class FunctionAction {
	@Resource(name="functionService")
	private FunctionService fs ;
	
	@RequestMapping("getNode.action")
	@ResponseBody
	public List<Function> getNode(Integer id,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return fs.getNode(id,user.getRoleId().getId());

	}
	

	
}
