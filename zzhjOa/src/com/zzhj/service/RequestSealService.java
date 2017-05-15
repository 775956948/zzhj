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
import com.zzhj.mapper.RequestSealMapper;
import com.zzhj.mapper.UsersMapper;
import com.zzhj.po.RequestSeal;
import com.zzhj.po.Users;
import com.zzhj.po.ZiZhiSeal;

@Service
public class RequestSealService {
	@Resource(name="requestSealMapper")
	private RequestSealMapper rsm;
	@Resource(name="usersMapper")
	private UsersMapper um;
	
	public Map<String,Object> queryAll(int page,int rows){
		int startPage =(page-1)*rows;
		Map<String,Object> map = new HashMap<String,Object>();
		List<RequestSeal> list = rsm.queryAll(startPage,rows);
		int totalCount =rsm.totalCount();
		map.put("rows", list);
		map.put("total",totalCount);
		return map;
	}
	
	public int save(RequestSeal r){
		Users user =um.userId(r.getUserId().getDepartmentId().getName());
		Date today=new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		String time=f.format(today);
		r.setRequestDate(time);
		r.setState("������");
		r.setApprover(user.getName());
		/*		List<HttpSession> list =SessionListener.list;
		for (HttpSession session : list) {
			Users u = (Users) session.getAttribute("users");
			if(u.getName().equals(user.getName())){
				session.setAttribute("ziZhiSeal", "����δ��������������Ϣ");
			}
		}*/
		return rsm.save(r);
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
		
		return rsm.approver(sealId,parentUser.getName());
	}
	
	public Map<String,Object> queryOneself(String userName,int page,int rows){
		int startPage =(page-1)*rows;
		Map<String,Object> map = new HashMap<String,Object>();
		List<RequestSeal> list = rsm.queryOneself(userName,startPage,rows);
		int totalCount =rsm.totalCountOneself(userName);
		map.put("rows", list);
		map.put("total",totalCount);
		return map;
	}
	
}
