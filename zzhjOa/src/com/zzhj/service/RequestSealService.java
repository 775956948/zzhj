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
import com.zzhj.entityCustom.MessageType;
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
		Users user=null;
		String roleName = r.getUserId().getRoleId().getName();
		if(roleName.equals("行政")||roleName.equals("人事")||roleName.equals("财务")||roleName.equals("副总")){
			user =um.queryBoss();
		}else if(roleName.equals("行政助理")||roleName.equals("人事助理")||roleName.equals("财务助理")){
			Users parentUser = um.parentId(r.getUserId().getId());
			user=um.query(parentUser.getParentId());
		}else{
			user =um.userId(r.getUserId().getDepartmentId().getName());
		}
		Date today=new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		String time=f.format(today);
		r.setRequestDate(time);
		r.setState("待审批");
		r.setApprover(user.getName());
		int number =rsm.save(r);
		RequestSeal rs=rsm.requestName(r.getId());
		//调用推送方法
		send(user.getName(),r.getUserId().getName(),rs.getSealId().getTypeName(),r.getId(),"seal/approve_officialSeal.jsp","公章审批");
		return number;
	}
	/**
	 * 
	 * @Description: 公共章审批方法
	 * @param @param sealId
	 * @param @param userId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月13日
	 */
	public int approver(int sealId,int userId){
		String view="";
		String targetName="";
		Users user =um.parentId(userId);
		RequestSeal rs=rsm.requestName(sealId);
		Users parentUser=new Users();
		if(user!=null&&user.getParentId()!=null&&user.getParentId()!=0){
			Users u=um.query(user.getParentId());
			parentUser.setName(u.getName());
			view="seal/approve_officialSeal.jsp";
			targetName="盖章审批";
		}else{
			view="seal/handling_officialSeal.jsp";
			targetName="公章经办";
			parentUser.setName("");
		}
		send(parentUser.getName(),rs.getUserId().getName(),rs.getSealId().getTypeName(),sealId,view,targetName);
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
	 * @Description: 修改章的申请时内容
	 * @param @param r
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年8月7日
	 */
	public int updateRequestSeal(RequestSeal r){
		return rsm.updateRequestSeal(r);
	}
	
	/**
	 * 
	 * @Description: 删除一条公章信息
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年8月7日
	 */
	public int delete(int id){
		return rsm.delete(id);
	}
	
	/**
	 * 
	 * @Description: 消息推送方法
	 * @param @param userName
	 * @param @param requestName
	 * @param @param mesText
	 * @param @param id   
	 * @return void  
	 * @throws
	 * @author 小白
	 * @date 2017年6月2日
	 */
	private void send(String userName,String requestName,String mesText,int id,String view,String targetName){
		Message mes =new Message();
		mes.setContentId(id);
		mes.setTargetName(targetName);
		mes.setViewTarget(view);
		mes.setFrom(requestName);
		mes.setType(MessageType.seal);
		mes.setTheme("您有未处理的"+mesText);
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

