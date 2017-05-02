package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.*;
public interface FunctionMapper {
	public List<Function> nodes(@Param("parentId")Integer parentId,@Param("roleId")Integer roleId);
	public List<Function> node(Integer roleId);
	
}
