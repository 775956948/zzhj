package com.zzhj.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.zzhj.listener.SessionListener;
import com.zzhj.mapper.UsersMapper;
import com.zzhj.mapper.ZiZhiSealMapper;
import com.zzhj.po.Users;
import com.zzhj.po.ZiZhiSeal;

@Service
public class ZiZhiSealService {
	@Resource(name="ziZhiSealMapper")
	ZiZhiSealMapper  zs;
	@Resource(name="usersMapper")
	UsersMapper um;
	public Map<String,Object> queryAll(int page,int rows){
		int startPage =(page-1)*rows;
		Map<String,Object> map = new HashMap<String,Object>();
		List<ZiZhiSeal> list = zs.queryAll(startPage,rows);
		int totalCount =zs.totalCount();
		map.put("rows", list);
		map.put("total",totalCount);
		return map;
	}
	
	public int save(ZiZhiSeal z){
		Users user =um.userId(z.getUserId().getDepartmentId().getName());
		Date today=new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		String time=f.format(today);
		z.setRequestDate(time);
		z.setState("待审批");
		z.setApprover(user.getName());
		/*		List<HttpSession> list =SessionListener.list;
		for (HttpSession session : list) {
			Users u = (Users) session.getAttribute("users");
			if(u.getName().equals(user.getName())){
				session.setAttribute("ziZhiSeal", "您有未审批的资质章消息");
			}
		}*/
		return zs.save(z);
	}
	public int delete(int id){
		return zs.delete(id);
	}
	public Map<String,Object> queryOneself(String userName,int page,int rows){
		int startPage =(page-1)*rows;
		Map<String,Object> map = new HashMap<String,Object>();
		List<ZiZhiSeal> list = zs.queryOneself(userName,startPage,rows);
		int totalCount =zs.totalCountOneself(userName);
		map.put("rows", list);
		map.put("total",totalCount);
		return map;
	}
	public ZiZhiSeal queryOneOneself(int id){
		return zs.queryOneOneself(id);
	}
	
	public int approver(int sealId,int userId){
		Users user =um.parentId(userId);
		Users parentUser=new Users();
		if(user!=null&&user.getParentId()!=null&&user.getParentId()!=0){
			Users u=um.query(user.getParentId());
			parentUser.setName(u.getName());
		}else{
			 parentUser.setName("");
		}
		
		return zs.approver(sealId,parentUser.getName());
	}
}
