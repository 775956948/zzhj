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
		rest.setState("´ýÉóÅú");
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
	
	

	
}
