package com.zzhj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.Function;
import com.zzhj.po.FunctionRole;

public interface FunctionRoleMapper {
	List<FunctionRole> queryAll(int roleId);
	int deleteFunctionRole(int roleId);
	int saveFunctionRole(List<FunctionRole> list);
}
