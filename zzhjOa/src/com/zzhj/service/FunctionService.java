package com.zzhj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zzhj.po.*;

import java.util.*;

import javax.annotation.Resource;

import com.zzhj.mapper.FunctionMapper;

@Service
public class FunctionService {
	@Resource(name="functionMapper")
	private FunctionMapper fm ;
	

	public List<Function> getNode(Integer id,Integer roleId){
		if(id!=null&&id>0){
			return fm.nodes(id,roleId);
		}else{
			return fm.node(roleId);
		}
		
	}
	


}
