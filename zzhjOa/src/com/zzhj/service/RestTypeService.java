package com.zzhj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzhj.mapper.RestTypeMapper;
import com.zzhj.po.RestType;
/**
 * 
 * @author С��
 * @date 2017��4��27��
 * @Description: TODO
 * @version 1.0
 */
@Service
public class RestTypeService {
	@Resource(name="restTypeMapper")
	private RestTypeMapper rtm;
	/**
	 * 
	 * @Description: ����������ٵ�����
	 * @param @return   
	 * @return List<RestType>  
	 * @throws
	 * @author С��
	 * @date 2017��4��27��
	 */
	public List<RestType> queryAll(){
		return rtm.queryAll();
	}
	
}
