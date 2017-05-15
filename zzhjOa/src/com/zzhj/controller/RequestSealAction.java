package com.zzhj.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.service.RequestSealService;
@Controller
@RequestMapping("/requestSeal")
public class RequestSealAction {
	@Resource(name="requestSealService")
	private RequestSealService rss;
	
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int page,int rows){
		return rss.queryAll(page,rows);
	}
}
