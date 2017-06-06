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
import com.zzhj.mapper.UsersMapper;
import com.zzhj.mapper.ZiZhiSealMapper;
import com.zzhj.po.Users;
import com.zzhj.po.ZiZhiSeal;
import com.zzhj.webSocket.ServerHandler;

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
		int number =zs.save(z);
		//调用推送方法
		send(user.getName(),z.getUserId().getName(),z.getId(),"seal/approve.jsp","资质章审批");
		return number;
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
		String view="";
		String targetName="";
		Users user =um.parentId(userId);
		String requestName=zs.requestName(sealId);
		Users parentUser=new Users();
		if(user!=null&&user.getParentId()!=null&&user.getParentId()!=0){
			Users u=um.query(user.getParentId());
			view="seal\\approve.jsp";
			targetName="资质章审批";
			parentUser.setName(u.getName());
		}else{
			 parentUser.setName("");
			 view="seal\\handling.jsp";
			 targetName="资质章办理";
		}
		send(parentUser.getName(),requestName,sealId,view,targetName);
		return zs.approver(sealId,parentUser.getName());
	}
	
	public Map<String,Object> approverZiZhiSeal(int page,int rows){
		int startPage =(page-1)*rows;
		List<ZiZhiSeal> list = zs.approverZiZhiSeal(startPage, rows);
		int total =zs.approverTotal();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rows", list);
		map.put("total",total);
		return map;
	}
	
	public int handLing(ZiZhiSeal z){
		Date today=new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		String time=f.format(today);
		z.setOverDate(time);
		return zs.handling(z);
	}
	/**
	 * 
	 * @Description: 推送消息
	 * @param @param userName
	 * @param @param requestName   
	 * @param @param id 
	 * @return void  
	 * @throws
	 * @author 小白
	 * @date 2017年5月31日
	 */
	private void send(String userName,String requestName,int id,String view,String targetName){
		Message mes =new Message();
		mes.setTargetName(targetName);
		mes.setContentId(id);
		mes.setViewTarget(view);
		mes.setFrom(requestName);
		mes.setType(MessageType.seal);
		mes.setTheme("您有未处理的资质章信息");
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
