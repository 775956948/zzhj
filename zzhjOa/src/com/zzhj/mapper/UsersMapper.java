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
	int queryId(String roleName);
	int exist(String name);
	List<Users> roleQueryAll(@Param("startPage") int startPage,@Param("rows") int rows);
	int updateRole(Users user);
	int updateUser(Users user);
	List<Users> queryUser(@Param("departmentName") String departmentName,@Param("roleName") String roleName);
	/**
	 * 
	 * @Description: �������û����Լ���������
	 * @param @param id
	 * @param @return   
	 * @return List<Users>  
	 * @throws
	 * @author С��
	 * @date 2017��5��3��
	 */
	List<Users> roleUser(Users user);
	/**
	 * 
	 * @Description: ���ݲ��ŷ��ز��ŵĸ���
	 * @param @param departmentName
	 * @param @return   
	 * @return Users  
	 * @throws
	 * @author С��
	 * @date 2017��5��11��
	 */
	Users userId(String departmentName);
	/**
	 * 
	 * @Description: �����û�id����parentName
	 * @param @param userId
	 * @param @return   
	 * @return Users  
	 * @throws
	 * @author С��
	 * @date 2017��5��11��
	 */
	Users parentId(int userId);
}
