package com.zzhj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzhj.mapper.RoleMapper;
import com.zzhj.po.Roles;

@Service
public class RoleService {
	@Resource(name="roleMapper")
	private RoleMapper rm;
	
	public List<Roles> queryAll(){
		return rm.queryAll();
	}
	
	public int saveRole(Roles role){

		return rm.saveRole(role);
	}
	
	public int deleteRole(int id){
		int number=0;
		try {
			number =rm.deleteRole(id);
		} catch (Exception e) {
			number=-1;
		}
		
		
		return number;
	}
}
