package com.zzhj.mapper;

import java.util.List;

import com.zzhj.po.RestType;

/**
 * 
 * @author 小白
 * @date 2017年4月27日
 * @Description: TODO
 * @version 1.0
 */
public interface RestTypeMapper {
	/**
	 * 
	 * @Description: 返回全部得请假类型
	 * @param @return   
	 * @return List<RestType>  
	 * @throws
	 * @author 小白
	 * @date 2017年4月27日
	 */
	List<RestType> queryAll();
}
