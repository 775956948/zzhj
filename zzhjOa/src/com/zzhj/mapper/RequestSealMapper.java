package com.zzhj.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zzhj.po.RequestSeal;

public interface RequestSealMapper {
	/**
	 * 
	 * @Description: 获取所有公章申请信息
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<ZiZhiSeal>  
	 * @throws
	 * @author 小白
	 * @date 2017年5月15日
	 */
	List<RequestSeal> queryAll(@Param("startPage")int startPage,@Param("rows")int rows);
	/**
	 * 
	 * @Description: 审批接口
	 * @param @param sealId
	 * @param @param userName
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年5月15日
	 */
	int approver(@Param("sealId")int sealId,@Param("userName")String userName);
	/**
	 * 
	 * @Description: 新增公章信息接口
	 * @param @param s
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年5月15日
	 */
	int save(RequestSeal s);
	/**
	 * 
	 * @Description: 获取公章总条数
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年5月15日
	 */
	int totalCount();
	/**
	 * 
	 * @Description: 获取审批人是自己得条数
	 * @param @param userName
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年5月15日
	 */
	int totalCountOneself(String userName);
	/**
	 * 
	 * @Description: 删除一条公章信息
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年5月15日
	 */
	int delete(int id);
	/**
	 * 
	 * @Description:  获取审批人是当前用户的盖章申请
	 * @param @param userName
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<RequestSeal>  
	 * @throws
	 * @author 小白
	 * @date 2017年5月15日
	 */
	List<RequestSeal> queryOneself(@Param("userName")String userName,@Param("startPage")int startPage,@Param("rows")int rows);
	/**
	 * 
	 * @Description: 根据id返回数据
	 * @param @param id
	 * @param @return   
	 * @return RequestSeal  
	 * @throws
	 * @author 小白
	 * @date 2017年5月15日
	 */
	RequestSeal queryOneOneself(int id);
	/**
	 * 
	 * @Description: 返回所有已经审批的数据
	 * @param @return   
	 * @return List<RequestSeal>  
	 * @throws
	 * @author 小白
	 * @date 2017年5月18日
	 */
	 List<RequestSeal> approverRequestSeal(@Param("startPage")int startPage,@Param("rows")int rows);
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
	 /**
	  * 
	  * @Description: 最终的公章办理
	  * @param @param r
	  * @param @return   
	  * @return int  
	  * @throws
	  * @author 小白
	  * @date 2017年5月18日
	  */
	 int handling(RequestSeal r);
	 /**
	  * 
	  * @Description: 根据id返回章信息
	  * @param @param sealId
	  * @param @return   
	  * @return String  
	  * @throws
	  * @author 小白
	  * @date 2017年5月31日
	  */
	 RequestSeal requestName(int sealId);
	 /**
	  * 
	  * @Description: 修改章的申请时内容
	  * @param @param r
	  * @param @return   
	  * @return int  
	  * @throws
	  * @author 小白
	  * @date 2017年8月7日
	  */
	 int updateRequestSeal(RequestSeal r);
}
