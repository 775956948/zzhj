package com.zzhj.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.mapper.RoleMapper;
import com.zzhj.mapper.UsersMapper;
import com.zzhj.po.Users;
/**
 * 
 * @author С��
 * @date 2017��4��25��
 * @Description: TODO
 * @version 1.0
 */
@Service
public class UsersService {
	@Resource(name="usersMapper")
	private UsersMapper um;
	
	@Autowired
	private RoleMapper rm;
	
	
	public Users login(Users users){
		return um.login(users);
	}
	
	public String save(Users users){
		int count =um.exist(users.getName());
		String message="";
		if(count>0){
			message="���û��Ѵ���";
		}else{
			message =um.save(users)+"";
		}
		return message;
		
	}
	public Map<String,Object> queryAll(int page,int rows){
		int startPage =(page-1)*(rows);
		int total=um.totalCount();
		List<Users> roleList =um.roleQueryAll(startPage,rows);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rows", roleList);
		map.put("total", total);
		return map;
	}
	
	public String deleteUser(int id,String name){
		Users user = um.query(id);
		if(name.equals(user.getName())){
			return "���ɲ�����ǰ�û�,"+user.getName();
		}
		 um.deleteUser(id);
		return "";
	}
	
	public int updateRole(Users user){
		if(user.getParentId()==0){
			String id=um.queryId("�ܾ���");
			if(id!=null&&!id.equals("")){
				user.setParentId(Integer.parseInt(id));
			}else{
				user.setParentId(0);
			}
			
		}
		String roleName =rm.queryRoleName(user.getRoleId().getId());
		if(!roleName.equals("Ա��")){
			user.setState("closed");
		}else{
			user.setState("open");
		}
		if(roleName.equals("��������")){
			user.setParentId(Integer.parseInt(um.queryId("����")));
		}else if(roleName.equals("��������")){
			user.setParentId(Integer.parseInt(um.queryId("����")));
		}
		return um.updateRole(user);
	}
	
	/**
	 * 
	 * @Description: �޸��û�����
	 * @param @param user
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��22��
	 */
	public int updateUser(Users user){
		
		return um.updateUser(user);
		
	}
	/**
	 * 
	 * @Description: ������ͬ���ŵ����ܻ��ž���
	 * @param @param departmentName ��������
	 * @param @param roleName ��ɫ���ƣ�ְλ��
	 * @param @return  
	 * @return List<Users>  �����û�����
	 * @throws
	 * @author С��
	 * @date 2017��4��25��
	 */
	public List<Users> queryUser(String departmentName,String roleName){
		return  um.queryUser(departmentName, roleName);
	}
	
	public List<Users> roleUser(Users user){
		return um.roleUser(user);
	}
	
	public Users queryUserInfoOne(int id){
		return um.queryUserInfoOne(id);
	}
	
	public int updateUserInfo(Users user){
		return um.updateUserInfo(user);
	}
	
	public Map<String,Users> searchUserInfo(int page,int rows,Users user){
		int startPage =(page-1)*(rows);
		List<Users> list = um.searchUserInfo(startPage, rows,user);
		int total = um.totalCount();
		Map map = new HashMap();
		map.put("rows",list);
		map.put("total", total);
		return map;
	}
	
	public List<String> querySubclass(String departmentName){
		return um.querySubclass(departmentName);
	}
	
	public List<String> querySubZhuGuan(String departmentName){
		return um.querySubZhuGuan(departmentName);
	}
	/**
	 * 
	 * @Description: �ж��û��Ƿ���ڣ������򷵻��û��ܱ�����
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author С��
	 * @date 2017��6��22��
	 */
	public String userExist(String userName){
		String a =um.userExist(userName);
		System.out.println(a);
		return a;
	}
}
