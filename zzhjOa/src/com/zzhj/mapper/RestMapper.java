package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.Rest;

/**
 * 
 * @author 小白
 * @date 2017年4月27日
 * @Description: TODO
 * @version 1.0
 */
public interface RestMapper {
	int save(Rest rest);
	/**
	 * 
	 * @Description: 查看自己的请假信息
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<Rest>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月17日
	 */
	List<Rest> queryOwn(@Param("startPage") int startPage,@Param("rows") int rows,@Param("userName")String userName);
	int totalCount();
	int deleteRest(int id);
}
