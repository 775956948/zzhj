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
	 * @Description: ����id�����û����û���
	 * @param @param id
	 * @param @return   
	 * @return Users  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
	 */
	Users query(int id);
	
	String queryId(String roleName);
	
	int exist(String name);
	
	List<Users> roleQueryAll(@Param("startPage") int startPage,@Param("rows") int rows);
	
	int updateRole(Users user);
	/**
	 * 
	 * @Description: �޸��û�����
	 * @param @param user
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��6��
	 */
	int updateUser(Users user);
	
	List<Users> queryUser(@Param("departmentName") String departmentName,@Param("roleName") String roleName);

	
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
	 * @Description: �����û�id����parentId
	 * @param @param userId
	 * @param @return   
	 * @return Users  
	 * @throws
	 * @author С��
	 * @date 2017��5��11��
	 */
	Users parentId(int userId);
	/**
	 * 
	 * @Description: ���ݲ��ŷ��ز�������Ա��
	 * @param @param departmentName
	 * @param @return   
	 * @return List<Users>  
	 * @throws
	 * @author С��
	 * @date 2017��5��31��
	 */
	List<Users> departmentUser(String departmentName);
	/**
	 * 
	 * @Description: ����id�����û���ϸ��Ϣ
	 * @param @param id
	 * @param @return   
	 * @return Users  
	 * @throws
	 * @author С��
	 * @date 2017��6��6��
	 */
	Users queryUserInfoOne(int id);
	
	/**
	 * 
	 * @Description: �޸��û�������Ϣ
	 * @param @param user
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��6��
	 */
	int updateUserInfo(Users user);
	/**
	 * 
	 * @Description: ��ѯԱ������Ϣ
	 * @param @param startPage
	 * @param @param rows
	 * @param @param departmentId
	 * @param @param userName
	 * @param @return   
	 * @return List<Users>  
	 * @throws
	 * @author С��
	 * @date 2017��6��8��
	 */
	List<Users> searchUserInfo(@Param("startPage") int startPage,@Param("rows") int rows,@Param("user")Users user);
	/**
	 * 
	 * @Description: ���ݲ��ŷ��ز���Ա������
	 * @param @param userId
	 * @param @return   
	 * @return List<String>  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
	 */
	List<String> querySubclass(String departmentName);
	
	/**
	 * 
	 * @Description: ���ز�ѯ��ǰ�û����Ƿ������û���������Ա��
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��20��
	 */
	int querySubCount(int id);
	/**
	 * 
	 * @Description: ���ص�ǰ��������
	 * @param @param departmentName
	 * @param @return   
	 * @return List<String>  
	 * @throws
	 * @author С��
	 * @date 2017��6��21��
	 */
	List<String> querySubZhuGuan(String departmentName);
	/**
	 * 
	 * @Description: �ж��û����Ƿ���ڣ������򷵻ض�Ӧ���ܱ�����
	 * @param @param userId
	 * @param @return   
	 * @return Users  
	 * @throws
	 * @author С��
	 * @date 2017��6��22��
	 */
	String userExist(String userName);
	
	/**
	 * 
	 * @Description: ���ݲ��źͽ�ɫ��ְλ�����ض�Ӧ��Ա��
	 * @param @return   
	 * @return List<String>  
	 * @throws
	 * @author С��
	 * @date 2017��7��5��
	 */
	List<String> queryDepartmentAndRole(@Param("departmentName")String departmentName,@Param("roleName")String roleName);
	/**
	 * 
	 * @Description: ����ӵ�иò�����ɫ���û�
	 * @param @param roleName
	 * @param @return   
	 * @return List<String>  
	 * @throws
	 * @author С��
	 * @date 2017��7��11��
	 */
	List<Users> queryRoleUser(String roleName);
}
