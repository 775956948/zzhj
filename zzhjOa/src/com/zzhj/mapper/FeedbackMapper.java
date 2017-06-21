package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.Feedback;

public interface FeedbackMapper {
	
	/**
	 * 
	 * @Description: 查询申请人是自己的反馈信息
	 * @param @return   
	 * @return List<Feedback>  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	List<Feedback> queryOwn(@Param("startPage")int startPage,@Param("rows")int rows,@Param("requestName")String requestName);
	/**
	 * 
	 * @Description: 查询审批人是自己的反馈信息
	 * @param @return   
	 * @return List<Feedback>  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	List<Feedback> approverOnw(@Param("startPage")int startPage,@Param("rows")int rows,@Param("approverName")String approverName);
	/**
	 * 
	 * @Description: 添加一条反馈信息
	 * @param @param f
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	int addFeedback(Feedback f);
	/**
	 * 
	 * @Description: 审批方法
	 * @param @param id
	 * @param @param nextApprover
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	int approver(@Param("feedbackId") int id,@Param("nextApprover")String nextApprover);
	/**
	 * 
	 * @Description: 打回一个反馈信息
	 * @param @param id
	 * @param @param refuseInfo
	 * @param @param overDate
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月15日
	 */
	int refuse(@Param("feedbackId")int feedbackId,@Param("refuseInfo")String refuseInfo,@Param("overDate")String overDate);
	
	int totalCount(String userName);
	/**
	 * 
	 * @Description: 删除一条信息
	 * @param @param feedbackId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月21日
	 */
	int deleteFeedback(int feedbackId);
	
}
