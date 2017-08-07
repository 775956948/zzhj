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
	/**
	 * 
	 * @Description: 删除一条申请信息
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年8月7日
	 */
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
	/**
	 * 
	 * @Description: 返回所有已审批的资质章
	 * @param @return   
	 * @return List<ZiZhiSeal>  
	 * @throws
	 * @author 小白
	 * @date 2017年5月18日
	 */
	List<ZiZhiSeal> approverZiZhiSeal(@Param("startPage")int startPage,@Param("rows")int rows);
	
	/**
	 * 
	 * @Description: 获取已审批的条数
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年5月18日
	 */
	int approverTotal();
	
	int handling(ZiZhiSeal z);
	/**
	 * 
	 * @Description: 根据id返回申请人用户名
	 * @param @param id
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author 小白
	 * @date 2017年5月31日
	 */
	String requestName(int id);
	/**
	 * 
	 * @Description:修改资质章
	 * @param @param z
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年8月7日
	 */
	int updateZiZhiSeal(ZiZhiSeal z);
}	
