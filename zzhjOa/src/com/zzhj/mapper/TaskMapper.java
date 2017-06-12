package com.zzhj.mapper;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.Task;

/**
 * 
 * @author asus
 * ��������dao��ӿ�
 */
public interface TaskMapper {
	/**
	 * 
	 * @Description:���һ������������Ϣ
	 * @param @param t
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
	 */
	int addTask(Task t);
	/**
	 * 
	 * @Description: �´�һ������
	 * @param @param taskId
	 * @param @param userId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
	 */
	int transmitTask(@Param("taskId")int taskId,@Param("userName")String userName);
	 /**
	  * 
	  * @Description: ���գ���ʼִ��һ������
	  * @param @param taskId
	  * @param @param startDate
	  * @param @return   
	  * @return int  
	  * @throws
	  * @author С��
	  * @date 2017��6��12��
	  */
	int acceptTask(@Param("taskId")int taskId,@Param("startDate")String startDate);
	
	/**
	 * 
	 * @Description: �������
	 * @param @param taskId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
	 */
	int successTask(@Param("taskId")int taskId,@Param("successDate")String successDate);
	/**
	 * 
	 * @Description: �޸Ĺ�������
	 * @param @param taskId
	 * @param @param speed
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
	 */
	int updateTaskSpeed(@Param("taskId")int taskId,@Param("speed")int speed);
	/**
	 * 
	 * @Description: �鿴���й���������Ϣ
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<Task>  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
	 */
	List<Task> queryAll(@Param("startpage")int startPage,@Param("rows")int rows);
	/**
	 * 
	 * @Description: �鿴�����Լ�������
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<Task>  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
	 */
	List<Task> queryOwn(@Param("startpage")int startPage,@Param("rows")int rows,@Param("userName")String userName);
	/**
	 * 
	 * @Description: ������������
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
	 */
	int totalCount();
	/**
	 * 
	 * @Description: �����Լ�����������
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��12��
	 */
	int totalCOuntOwn(String name);
}
