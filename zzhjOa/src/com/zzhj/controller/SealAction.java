package com.zzhj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.Seal;
import com.zzhj.service.SealService;

@Controller
@RequestMapping("/seal")
public class SealAction {
	@Resource(name="sealService")
	private SealService ss;
	
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public List<Seal> queryAll(){
		return ss.queryAll();
	}
}
