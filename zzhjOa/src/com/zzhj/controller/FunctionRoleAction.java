package com.zzhj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.Function;
import com.zzhj.po.FunctionRole;
import com.zzhj.service.FunctionRoleService;

@Controller
@RequestMapping("functionRole")
public class FunctionRoleAction {
	
	@Resource(name="functionRoleService")
	private FunctionRoleService frs;
	
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public List<FunctionRole> queryAll(int roleId){
		 return frs.queryAll(roleId);
	}
	
	@RequestMapping("/updateFunctionRole.action")
	@ResponseBody
	public int updateFunctionRole(String str,Integer roleId){
		return frs.updateFunctionRole(str, roleId);
	}
}
