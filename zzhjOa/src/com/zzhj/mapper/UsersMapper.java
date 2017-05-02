package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.Users;

public interface UsersMapper {
	Users login(Users users);
	int save(Users users);
	List<Users> queryAll(@Param("startPage") int startPage,@Param("rows") int rows);
	int totalCount();
	int deleteUser(int id);
	Users query(int id);
	int exist(String name);
	List<Users> roleQueryAll(@Param("startPage") int startPage,@Param("rows") int rows);
	int updateRole(Users user);
	int updateUser(Users user);
	List<Users> queryUser(@Param("departmentName") String departmentName,@Param("roleName") String roleName);
}
