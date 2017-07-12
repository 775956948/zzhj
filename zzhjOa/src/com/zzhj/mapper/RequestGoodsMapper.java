package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.RequestGoods;

public interface RequestGoodsMapper {
	
	/**
	 * 
	 * @Description: ���һ������
	 * @param @param g
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	int saveRequestGoods(RequestGoods g);
	
	/**
	 * 
	 * @Description: �鿴�������뵥
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<RequestGoods>  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	List<RequestGoods> queryAll(@Param("startPage")int startPage,@Param("rows")int rows);
	/**
	 * 
	 * @Description: �鿴�Լ������뵥
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<RequestGoods>  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	List<RequestGoods> queryOwnAll(@Param("userId")int userId,@Param("startPage")int startPage,@Param("rows")int rows);
	/**
	 * 
	 * @Description: ����������
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	int approver(@Param("id")int id,@Param("date")String date,@Param("approverName")String approverName);
	
	/**
	 * 
	 * @Description: ɾ��һ�����뵥
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	int delete(int id);
	/**
	 * 
	 * @Description: ��ѯ������
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	int totalCount();
	/**
	 * 
	 * @Description: ��ѯ�Լ������������
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	int totalOwnCont();
	/**
	 * 
	 * @Description: ����������ģ����ѯ
	 * @param @param userName
	 * @param @return   
	 * @return List<RequestGoods>  
	 * @throws
	 * @author С��
	 * @date 2017��7��11��
	 */
	List<RequestGoods> likeUserQueryAll(String userName);
	/**
	 * 
	 * @Description: �������뵥id�õ���Ʒid
	 * @param @param id
	 * @param @return   
	 * @return RequestGoods  
	 * @throws
	 * @author С��
	 * @date 2017��7��12��
	 */
	RequestGoods queryId(int id);
}
