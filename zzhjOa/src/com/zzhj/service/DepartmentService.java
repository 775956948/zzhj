package com.zzhj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzhj.mapper.DepartmentMapper;
import com.zzhj.po.Department;

@Service
public class DepartmentService {
	@Resource(name="departmentMapper")
	private DepartmentMapper dp;
	
	public List<Department> queryAll(){
		return dp.queryAll();
	}
}
