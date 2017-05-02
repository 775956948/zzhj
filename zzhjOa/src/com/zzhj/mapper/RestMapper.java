package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.Rest;

/**
 * 
 * @author С��
 * @date 2017��4��27��
 * @Description: TODO
 * @version 1.0
 */
public interface RestMapper {
	int save(Rest rest);
	List<Rest> queryAll(@Param("startPage") int startPage,@Param("rows") int rows);
	int totalCount();
	int deleteRest(int id);
}
