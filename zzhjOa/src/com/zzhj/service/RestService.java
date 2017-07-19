package com.zzhj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.mapper.RestMapper;
import com.zzhj.mapper.UsersMapper;
import com.zzhj.po.Rest;
import com.zzhj.po.Users;


/**
 * 
 * @author 小白
 * @date 2017年4月27日
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
	 * @Description: 添加一条rest数据
	 * @param @param rest
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年4月27日
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
	
	
}
