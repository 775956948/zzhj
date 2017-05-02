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
	List<Rest> queryAll(@Param("startPage") int startPage,@Param("rows") int rows);
	int totalCount();
	int deleteRest(int id);
}
