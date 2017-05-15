package com.zzhj.mapper;


import java.util.List;

import com.zzhj.po.Seal;

public interface SealMapper {
	/**
	 * 
	 * @Description: 返回所有得章类型
	 * @param @return   
	 * @return List<Seal>  
	 * @throws
	 * @author 小白
	 * @date 2017年5月15日
	 */
	List<Seal> queryAll();
}
