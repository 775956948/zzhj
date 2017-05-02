package com.zzhj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzhj.mapper.RestTypeMapper;
import com.zzhj.po.RestType;
/**
 * 
 * @author 小白
 * @date 2017年4月27日
 * @Description: TODO
 * @version 1.0
 */
@Service
public class RestTypeService {
	@Resource(name="restTypeMapper")
	private RestTypeMapper rtm;
	/**
	 * 
	 * @Description: 返回所有请假得类型
	 * @param @return   
	 * @return List<RestType>  
	 * @throws
	 * @author 小白
	 * @date 2017年4月27日
	 */
	public List<RestType> queryAll(){
		return rtm.queryAll();
	}
	
}
