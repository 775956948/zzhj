package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.*;;

public interface ZiZhiSealMapper {
	List<ZiZhiSeal> queryAll(@Param("startPage")int startPage,@Param("rows")int rows);
	int approver(@Param("sealId")int sealId,@Param("userName")String userName);
	int save(ZiZhiSeal s);
	int totalCount();
	int totalCountOneself(String userName);
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
	List<ZiZhiSeal> queryOneself(@Param("userName")String userName,@Param("startPage")int startPage,@Param("rows")int rows);
	/**
	 * 
	 * @Description: 根据Id返回相对的数据
	 * @param @param id
	 * @param @return   
	 * @return ZiZhiSeal  
	 * @throws
	 * @author 小白
	 * @date 2017年5月10日
	 */
	ZiZhiSeal queryOneOneself(int id);
}	
