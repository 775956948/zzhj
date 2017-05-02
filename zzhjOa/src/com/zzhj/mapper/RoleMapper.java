package com.zzhj.mapper;

import java.util.List;

import com.zzhj.po.Roles;

public interface RoleMapper {
	List<Roles> queryAll();
	int saveRole(Roles role);
	int deleteRole(int id);
}
