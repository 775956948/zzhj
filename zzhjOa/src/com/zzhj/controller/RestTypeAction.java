package com.zzhj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.RestType;
import com.zzhj.service.RestTypeService;

/**
 * 
 * @author 小白
 * @date 2017年4月27日
 * @Description: TODO
 * @version 1.0
 */
@Controller
@RequestMapping("/restType")
public class RestTypeAction {

	@Resource(name="restTypeService")
	private RestTypeService rts;
	/**
	 * 
	 * @Description: 返回所有请假类型
	 * @param @return   
	 * @return List<RestType>  
	 * @throws
	 * @author 小白
	 * @date 2017年4月27日
	 */
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public List<RestType> queryAll(){
		return rts.queryAll();
	}
}
