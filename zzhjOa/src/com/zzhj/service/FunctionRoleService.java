package com.zzhj.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzhj.mapper.FunctionRoleMapper;
import com.zzhj.po.Function;
import com.zzhj.po.FunctionRole;
import com.zzhj.po.Roles;

@Service
public class FunctionRoleService {
	@Resource(name="functionRoleMapper")
	private FunctionRoleMapper frm;
	
	public List<FunctionRole> queryAll(int roleId){
 
		return frm.queryAll(roleId);
	}
	
	public void updateFunctionRole(String str,int roleId){
		String[] functionId = str.split(",");
		List<FunctionRole> list = new ArrayList<FunctionRole>();
		int count=0;
		for (int i = 0; i < functionId.length; i++) {
			if(!functionId[i].equals("")){
				FunctionRole fr = new FunctionRole();
				Function f= new Function();
				Roles r = new Roles();
				r.setId(roleId);
				f.setId(Integer.parseInt(functionId[i]));
				fr.setFunctionId(f);
				fr.setRoleId(r);
				list.add(fr);
				count++;
			}	
		}
		
		frm.deleteFunctionRole(roleId);
		if(count>0){
			frm.saveFunctionRole(list);
		}
		
		
	}
	
}
