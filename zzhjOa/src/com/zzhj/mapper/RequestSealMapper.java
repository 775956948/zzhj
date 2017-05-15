package com.zzhj.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zzhj.po.RequestSeal;

public interface RequestSealMapper {
	/**
	 * 
	 * @Description: ��ȡ���й���������Ϣ
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<ZiZhiSeal>  
	 * @throws
	 * @author С��
	 * @date 2017��5��15��
	 */
	List<RequestSeal> queryAll(@Param("startPage")int startPage,@Param("rows")int rows);
	/**
	 * 
	 * @Description: �����ӿ�
	 * @param @param sealId
	 * @param @param userName
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��5��15��
	 */
	int approver(@Param("sealId")int sealId,@Param("userName")String userName);
	/**
	 * 
	 * @Description: ����������Ϣ�ӿ�
	 * @param @param s
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��5��15��
	 */
	int save(RequestSeal s);
	/**
	 * 
	 * @Description: ��ȡ����������
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��5��15��
	 */
	int totalCount();
	/**
	 * 
	 * @Description: ��ȡ���������Լ�������
	 * @param @param userName
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��5��15��
	 */
	int totalCountOneself(String userName);
	/**
	 * 
	 * @Description: ɾ��һ��������Ϣ
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��5��15��
	 */
	int delete(int id);
	/**
	 * 
	 * @Description:  ��ȡ�������ǵ�ǰ�û��ĸ�������
	 * @param @param userName
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<RequestSeal>  
	 * @throws
	 * @author С��
	 * @date 2017��5��15��
	 */
	List<RequestSeal> queryOneself(@Param("userName")String userName,@Param("startPage")int startPage,@Param("rows")int rows);
	/**
	 * 
	 * @Description: ����id��������
	 * @param @param id
	 * @param @return   
	 * @return RequestSeal  
	 * @throws
	 * @author С��
	 * @date 2017��5��15��
	 */
	RequestSeal queryOneOneself(int id);
}
