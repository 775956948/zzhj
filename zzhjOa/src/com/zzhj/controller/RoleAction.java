package com.zzhj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.Roles;
import com.zzhj.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleAction {
	
	@Resource(name="roleService")
	private RoleService rs;
	@RequestMapping("queryAll.action")
	@ResponseBody
	public List<Roles> queryAll(){
		return rs.queryAll();
	}
	
	@RequestMapping("saveRole.action")
	@ResponseBody
	public Integer saveRole(Roles role){
		return rs.saveRole(role);
	}
	
	@RequestMapping("deleteRole.action")
	@ResponseBody
	public int deleteRole(int id){
		return rs.deleteRole(id);
	}
}
