package com.zzhj.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.mapper.UsersMapper;
import com.zzhj.po.Users;
/**
 * 
 * @author 小白
 * @date 2017年4月25日
 * @Description: TODO
 * @version 1.0
 */
@Service
public class UsersService {
	@Resource(name="usersMapper")
	UsersMapper um;
	
	public Users login(Users users){
		return um.login(users);
	}
	
	public String save(Users users){
		int count =um.exist(users.getName());
		String message="";
		if(count>0){
			message="该用户已存在";
		}else{
			message =um.save(users)+"";
		}
		return message;
		
	}
	public Map<String,Object> queryAll(int page,int rows){
		int startPage =(page-1)*(rows/2);
		int total=um.totalCount();
		List<Users> list = um.queryAll(startPage, rows);
		List<Users> roleList =um.roleQueryAll(startPage,rows);
		for (int i = 0; i < list.size(); i++) {
			boolean where=true;
			for (int j = 0; j < roleList.size(); j++) {
				if(roleList.get(j).getName().equals(list.get(i).getName())){
					where=false;
				}
			}
			if(where){
				roleList.add(list.get(i));
			}
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rows", roleList);
		map.put("total", total);
		return map;
	}
	
	public String deleteUser(int id,String name){
		Users user = um.query(id);
		if(name.equals(user.getName())){
			return "不可操作当前用户,"+user.getName();
		}
		 um.deleteUser(id);
		return "";
	}
	
	public int updateRole(Users user){
		if(user.getParentId()==0){
			int id=um.queryId("总经理");
			user.setParentId(id);
		}
		return um.updateRole(user);
	}
	
	public int updateUser(Users user){
		int count =0;
		try {
			count =um.updateUser(user);
		} catch (Exception e) {
			count=-1;
		}
		return count;
		
	}
	/**
	 * 
	 * @Description: 返回相同部门的主管或部门经理
	 * @param @param departmentName 部门名称
	 * @param @param roleName 角色名称（职位）
	 * @param @return  
	 * @return List<Users>  返回用户集合
	 * @throws
	 * @author 小白
	 * @date 2017年4月25日
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
}
