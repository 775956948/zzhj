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
	/**
	 * 
	 * @Description: �鿴�Լ��������Ϣ
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<Rest>  
	 * @throws
	 * @author С��
	 * @date 2017��7��17��
	 */
	List<Rest> queryOwn(@Param("startPage") int startPage,@Param("rows") int rows,@Param("userName")String userName);
	int totalCount();
	int deleteRest(int id);
}
