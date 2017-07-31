package com.zzhj.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zzhj.po.Rest;
import com.zzhj.po.Users;
import com.zzhj.service.RestService;

@Controller
@RequestMapping("/rest")
public class RestAction {

	@Resource(name="restService")
	private RestService rs;
	
	@RequestMapping("/save.action")
	@ResponseBody
	public int save(MultipartFile file,Rest rest,HttpSession session,HttpServletRequest request){
		if(file!=null&&!file.isEmpty()){
			String path =session.getServletContext().getRealPath("/fileUpload");
			String uplaodPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/zzhjOa/fileUpload/"+file.getOriginalFilename();
			rest.setAppendix(uplaodPath);
			try {
				file.transferTo(new File(path,file.getOriginalFilename()));

			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Users user = (Users) session.getAttribute("users");
		rest.setUserId(user);
		rest.setState("待审批");
		return rs.save(rest);
	}
	@RequestMapping("queryOwn.action")
	@ResponseBody
	public Map<String,Object> queryOwn(int page,int rows,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return rs.queryOwn(page, rows,user.getName());
	}
	
	@RequestMapping("/deleteRest.action")
	@ResponseBody
	public int deleteRest(int id){
		return rs.deleteRest(id);
	}
	/**
	 * 
	 * @Description: 查询审批人是当前登陆用户的申请请假信息
	 * @param @param page
	 * @param @param rows
	 * @param @param session
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月19日
	 */
	@RequestMapping("/approverOwn.action")
	@ResponseBody
	public Map<String,Object> approverOwn(int page,int rows,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return rs.approverOwn(page, rows, user.getName());
	}
	/**
	 * 
	 * @Description: 审批方法
	 * @param @param session
	 * @param @param restId
	 * @param @param day
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月19日
	 */
	@RequestMapping("/approver.action")
	@ResponseBody
	public int approver(HttpSession session,int restId,double day){
		Users user = (Users) session.getAttribute("users");
		return rs.approver(restId,user,day);
	}
	
	/**
	 * 
	 * @Description: 组合查询
	 * @param @param date
	 * @param @param userName
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月19日
	 */
	@RequestMapping("/combinationQuery.action")
	@ResponseBody
	public Map<String,Object> combinationQuery(String date,String userName){
		return rs.combinationQuery(date, userName);
	}
	
	
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int page,int rows){
		return rs.queryAll(page, rows);
	}
	
	@RequestMapping("/test.action")
	@ResponseBody
	public int[] test(){
		return new int[]{1,2,3,4,5,6,7,8,9};
	}
	/**
	 * 
	 * @Description: 打回一条信息
	 * @param @param restId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月31日
	 */
	@RequestMapping("/restRepulse.action")
	@ResponseBody
	public int restRepulse(int restId){
		return rs.restRepulse(restId);
	}

	
}
