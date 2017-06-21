package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.Feedback;

public interface FeedbackMapper {
	
	/**
	 * 
	 * @Description: ��ѯ���������Լ��ķ�����Ϣ
	 * @param @return   
	 * @return List<Feedback>  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
	 */
	List<Feedback> queryOwn(@Param("startPage")int startPage,@Param("rows")int rows,@Param("requestName")String requestName);
	/**
	 * 
	 * @Description: ��ѯ���������Լ��ķ�����Ϣ
	 * @param @return   
	 * @return List<Feedback>  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
	 */
	List<Feedback> approverOnw(@Param("startPage")int startPage,@Param("rows")int rows,@Param("approverName")String approverName);
	/**
	 * 
	 * @Description: ���һ��������Ϣ
	 * @param @param f
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
	 */
	int addFeedback(Feedback f);
	/**
	 * 
	 * @Description: ��������
	 * @param @param id
	 * @param @param nextApprover
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
	 */
	int approver(@Param("feedbackId") int id,@Param("nextApprover")String nextApprover);
	/**
	 * 
	 * @Description: ���һ��������Ϣ
	 * @param @param id
	 * @param @param refuseInfo
	 * @param @param overDate
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��15��
	 */
	int refuse(@Param("feedbackId")int feedbackId,@Param("refuseInfo")String refuseInfo,@Param("overDate")String overDate);
	
	int totalCount(String userName);
	/**
	 * 
	 * @Description: ɾ��һ����Ϣ
	 * @param @param feedbackId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��21��
	 */
	int deleteFeedback(int feedbackId);
	
}
