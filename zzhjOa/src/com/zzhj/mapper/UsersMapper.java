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
	/**
	 * 
	 * @Description: 根据id返回用户，用户名
	 * @param @param id
	 * @param @return   
	 * @return Users  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	Users query(int id);
	
	String queryId(String roleName);
	
	int exist(String name);
	
	List<Users> roleQueryAll(@Param("startPage") int startPage,@Param("rows") int rows);
	
	int updateRole(Users user);
	/**
	 * 
	 * @Description: 修改用户密码
	 * @param @param user
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月6日
	 */
	int updateUser(Users user);
	
	List<Users> queryUser(@Param("departmentName") String departmentName,@Param("roleName") String roleName);

	
	List<Users> roleUser(Users user);
	/**
	 * 
	 * @Description: 根据部门返回部门的副总
	 * @param @param departmentName
	 * @param @return   
	 * @return Users  
	 * @throws
	 * @author 小白
	 * @date 2017年5月11日
	 */
	Users userId(String departmentName);
	/**
	 * 
	 * @Description: 根据用户id返回parentId
	 * @param @param userId
	 * @param @return   
	 * @return Users  
	 * @throws
	 * @author 小白
	 * @date 2017年5月11日
	 */
	Users parentId(int userId);
	/**
	 * 
	 * @Description: 根据部门返回部门所有员工
	 * @param @param departmentName
	 * @param @return   
	 * @return List<Users>  
	 * @throws
	 * @author 小白
	 * @date 2017年5月31日
	 */
	List<Users> departmentUser(String departmentName);
	/**
	 * 
	 * @Description: 根据id返回用户详细信息
	 * @param @param id
	 * @param @return   
	 * @return Users  
	 * @throws
	 * @author 小白
	 * @date 2017年6月6日
	 */
	Users queryUserInfoOne(int id);
	
	/**
	 * 
	 * @Description: 修改用户个人信息
	 * @param @param user
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月6日
	 */
	int updateUserInfo(Users user);
	/**
	 * 
	 * @Description: 查询员工的信息
	 * @param @param startPage
	 * @param @param rows
	 * @param @param departmentId
	 * @param @param userName
	 * @param @return   
	 * @return List<Users>  
	 * @throws
	 * @author 小白
	 * @date 2017年6月8日
	 */
	List<Users> searchUserInfo(@Param("startPage") int startPage,@Param("rows") int rows,@Param("user")Users user);
	/**
	 * 
	 * @Description: 根据部门返回部门员工名称
	 * @param @param userId
	 * @param @return   
	 * @return List<String>  
	 * @throws
	 * @author 小白
	 * @date 2017年6月12日
	 */
	List<String> querySubclass(String departmentName);
	
	/**
	 * 
	 * @Description: 返回查询当前用户下是否有子用户，即手下员工
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月20日
	 */
	int querySubCount(int id);
	/**
	 * 
	 * @Description: 返回当前部门主管
	 * @param @param departmentName
	 * @param @return   
	 * @return List<String>  
	 * @throws
	 * @author 小白
	 * @date 2017年6月21日
	 */
	List<String> querySubZhuGuan(String departmentName);
	/**
	 * 
	 * @Description: 判断用户名是否存在，存在则返回对应的密保问题
	 * @param @param userId
	 * @param @return   
	 * @return Users  
	 * @throws
	 * @author 小白
	 * @date 2017年6月22日
	 */
	String userExist(String userName);
	
	/**
	 * 
	 * @Description: 根据部门和角色（职位）返回对应的员工
	 * @param @return   
	 * @return List<String>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月5日
	 */
	List<String> queryDepartmentAndRole(@Param("departmentName")String departmentName,@Param("roleName")String roleName);
	/**
	 * 
	 * @Description: 返回拥有该参数角色的用户
	 * @param @param roleName
	 * @param @return   
	 * @return List<String>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月11日
	 */
	List<Users> queryRoleUser(String roleName);
}
