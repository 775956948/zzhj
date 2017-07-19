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
	/**
	 * 
	 * @Description: ����idɾ��һ����Ϣ
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��18��
	 */
	int deleteRest(int id);
	/**
	 * 
	 * @Description: ��ѯ�������ǵ�ǰ��½�û���������
	 * @param @param userName
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��18��
	 */
	int totalCountApproverOnw(@Param("userName")String userName);
	/**
	 * 
	 * @Description: ��ѯ�������ǵ�ǰ��½�û�����Ϣ
	 * @param @param startPage
	 * @param @param rows
	 * @param @param userName
	 * @param @return   
	 * @return List<Rest>  
	 * @throws
	 * @author С��
	 * @date 2017��7��18��
	 */
	List<Rest> approverOwn(@Param("startPage") int startPage,@Param("rows") int rows,@Param("userName")String userName);
	/**
	 * 
	 * @Description: ��������
	 * @param @param restId
	 * @param @param approverName
	 * @param @param state
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��19��
	 */
	int approver(@Param("restId")int restId,@Param("approverName")String approverName,@Param("state")String state);
	/**
	 * 
	 * @Description: ��ϲ�ѯ
	 * @param @param date
	 * @param @param userName
	 * @param @return   
	 * @return List<Rest>  
	 * @throws
	 * @author С��
	 * @date 2017��7��19��
	 */
	List<Rest> combinationQuery(@Param("date")String date,@Param("userName")String userName);
	
	List<Rest> queryAll(@Param("startPage")int startPage,@Param("rows")int rows);
	
}
