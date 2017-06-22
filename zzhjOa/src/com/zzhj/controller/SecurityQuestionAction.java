package com.zzhj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.SecurityQuestion;
import com.zzhj.service.SecurityQuestionService;

@Controller
@RequestMapping("securityQuestion")
public class SecurityQuestionAction {
	
	@Autowired
	private SecurityQuestionService sqs;
	
	@RequestMapping("queryAll.action")
	@ResponseBody
	public List<SecurityQuestion> queryAll(){
		return sqs.queryAll();
	}
}
