package com.zzhj.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	UsersMapper um;
	
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
			return "���ɲ�����ǰ�û�,"+user.getName();
		}
		 um.deleteUser(id);
		return "";
	}
	
	public void updateRole(Users user){
		um.updateRole(user);
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
}
