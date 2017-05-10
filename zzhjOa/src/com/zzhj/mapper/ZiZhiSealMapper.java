package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.*;;

public interface ZiZhiSealMapper {
	List<ZiZhiSeal> queryAll(@Param("startPage")int startPage,@Param("rows")int rows);
	int approval(ZiZhiSeal s);
	int save(ZiZhiSeal s);
	int totalCount();
	int totalCountOneself(int userId);
	int delete(int id);
	/**
	 * 
	 * @Description: 获取审批人是当前用户的盖章申请
	 * @param @param userId
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<ZiZhiSeal>  
	 * @throws
	 * @author 小白
	 * @date 2017年5月10日
	 */
	List<ZiZhiSeal> queryOneself(@Param("userId")int userId,@Param("startPage")int startPage,@Param("rows")int rows);
	
}	
