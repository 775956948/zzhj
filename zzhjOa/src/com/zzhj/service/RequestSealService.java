package com.zzhj.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.zzhj.entityCustom.Message;
import com.zzhj.listener.SessionListener;
import com.zzhj.mapper.RequestSealMapper;
import com.zzhj.mapper.UsersMapper;
import com.zzhj.po.RequestSeal;
import com.zzhj.po.Users;
import com.zzhj.po.ZiZhiSeal;
import com.zzhj.webSocket.ServerHandler;

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
		r.setState("待审批");
		r.setApprover(user.getName());
		//调用推送方法
		send(user.getName(),r.getUserId().getName());
		return rsm.save(r);
	}
	
	public int approver(int sealId,int userId){
		Users user =um.parentId(userId);
		String requestName=rsm.requestName(sealId);
		Users parentUser=new Users();
		if(user!=null&&user.getParentId()!=null&&user.getParentId()!=0){
			Users u=um.query(user.getParentId());
			parentUser.setName(u.getName());
		}else{
			 parentUser.setName("");
		}
		send(parentUser.getName(),requestName);
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
	
	public Map<String,Object> approverRequestSeal(int page,int rows){
		int startPage =(page-1)*rows;
		Map<String,Object> map = new HashMap<String,Object>();
		List<RequestSeal> list =rsm.approverRequestSeal(startPage, rows);
		int totalCount =rsm.approverTotal();
		map.put("rows", list);
		map.put("total",totalCount);
		return map;
	}
	
	public int handLing(RequestSeal r){
		Date today=new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		String time=f.format(today);
		r.setOverDate(time);
		return rsm.handling(r);
	}
	
	/**
	 * 
	 * @Description: 推送消息
	 * @param @param userName
	 * @param @param requestName   
	 * @return void  
	 * @throws
	 * @author 小白
	 * @date 2017年5月31日
	 */
	private void send(String userName,String requestName){
		Message mes =new Message();
		mes.setFrom(requestName);
		mes.setTheme("您有未处理的得公章信息");
		if(!userName.equals("")){
			ServerHandler.send(userName,mes);
		}else{
			List<Users> list =um.departmentUser("行政部");
			for (int i = 0; i < list.size(); i++) {
				ServerHandler.send(list.get(i).getName(),mes);
			}
		}
		
	}
	
}

