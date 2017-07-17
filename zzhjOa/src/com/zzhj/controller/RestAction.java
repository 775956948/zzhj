package com.zzhj.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
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
	public int save(MultipartFile file,Rest rest,HttpSession session){
		int resoult=0;
		if(!file.isEmpty()){
			String path =session.getServletContext().getRealPath("/fileUpload");
			rest.setAppendix(path+file.getOriginalFilename());
			System.out.println(rest.getAppendix());
			try {
				file.transferTo(new File(path,file.getOriginalFilename()));
				Users user = (Users) session.getAttribute("users");
				rest.setUserId(user);
				rest.setState("´ýÉóÅú");
				resoult=rs.save(rest);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return resoult;
	}
	@RequestMapping("queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int page,int rows,HttpSession session){
		Users user = (Users) session.getAttribute("users");
		return rs.queryOwn(page, rows,user.getName());
	}
	
	@RequestMapping("/deleteRest.action")
	@ResponseBody
	public int deleteRest(int id){
		return rs.deleteRest(id);
	}
	
	
	@RequestMapping("/test.action")
	@ResponseBody
	public int[] test(){
		return new int[]{1,2,3,4,5,6,7,8,9};
	}
	
}
