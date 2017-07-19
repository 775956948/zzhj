package com.zzhj.service;

import java.security.interfaces.RSAKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.mapper.RestMapper;
import com.zzhj.mapper.UsersMapper;
import com.zzhj.po.Rest;
import com.zzhj.po.Users;


/**
 * 
 * @author С��
 * @date 2017��4��27��
 * @Description: TODO
 * @version 1.0
 */
@Service
public class RestService {
	@Resource(name="restMapper")
	private RestMapper rm;
	
	@Autowired
	private UsersMapper um;
	/**
	 * 
	 * @Description: ���һ��rest����
	 * @param @param rest
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��4��27��
	 */
	public int save(Rest rest){
		Users parentId = um.parentId(rest.getUserId().getId());
		Users userName = um.queryUserInfoOne(parentId.getParentId());
		rest.setApprover(userName.getName());
		return rm.save(rest);
	}
	
	public Map<String,Object> queryOwn(int page,int rows,String userName){
		int total =rm.totalCount();
		int startPage =(page-1)*rows;
		List<Rest> list =rm.queryOwn(startPage, rows,userName);
		Map map = new HashMap<String,Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	
	public int deleteRest(int id){
		return rm.deleteRest(id);
	}
	/**
	 * 
	 * @Description: ��ѯ�������ǵ�ǰ��½�û��������Ϣ
	 * @param @param startPage
	 * @param @param rows
	 * @param @param userName
	 * @param @return   
	 * @return List<Rest>  
	 * @throws
	 * @author С��
	 * @date 2017��7��19��
	 */
	public Map<String,Object> approverOwn(int page,int rows,String userName){
		int total =rm.totalCountApproverOnw(userName);
		int startPage =(page-1)*rows;
		List<Rest> list =rm.approverOwn(startPage, rows, userName);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	/**
	 * 
	 * @Description: ��������
	 * @param @param restId
	 * @param @param user
	 * @param @param day
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��19��
	 */
	public int approver(int restId,Users user,double day){
		String roleName =user.getRoleId().getName();
		Users parentId = um.parentId(user.getId());
		Users userName = um.queryUserInfoOne(parentId.getParentId());
		int resoult=0;
		String state="������";
		if(day<=0.5){
			if(roleName.equals("����")){
				resoult=rm.approver(restId, userName.getName(), state);
			}else if(roleName.equals("���ž���")){
				state="������";
				resoult=rm.approver(restId, user.getName(), state);
			}
		}else if(day<=1){
			if(roleName.equals("����")){
				resoult=rm.approver(restId, userName.getName(), state);
			}else if(roleName.equals("���ž���")){

				resoult=rm.approver(restId, userName.getName(), state);
			}else if(roleName.equals("����")){
				state="������";
				resoult=rm.approver(restId, user.getName(), state);
			}
		}else if(day>1){
			if(roleName.equals("����")){
				resoult=rm.approver(restId, userName.getName(), state);
			}else if(roleName.equals("���ž���")){

				resoult=rm.approver(restId, userName.getName(), state);
			}else if(roleName.equals("����")){
				resoult=rm.approver(restId, userName.getName(), state);
			}else if(roleName.equals("�ܾ���")){
				state="������";
				resoult=rm.approver(restId, user.getName(), state);
			}
		}
		return resoult;
	}
	/**
	 * 
	 * @Description: ��ϲ�ѯ
	 * @param @param date
	 * @param @param userName
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author С��
	 * @date 2017��7��19��
	 */
	public Map<String,Object> combinationQuery(String date,String userName){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Rest> list =rm.combinationQuery(date, userName);
		map.put("rows", list);
		return map;
	}
	

	
}
