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
	 * @Description: ɾ��һ��������Ϣ
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��8��7��
	 */
	int delete(int id);
	/**
	 * 
	 * @Description: ��ȡ�������ǵ�ǰ�û��ĸ�������
	 * @param @param userId
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<ZiZhiSeal>  
	 * @throws
	 * @author С��
	 * @date 2017��5��10��
	 */
	List<ZiZhiSeal> queryOneself(@Param("userName")String userName,@Param("startPage")int startPage,@Param("rows")int rows);
	/**
	 * 
	 * @Description: ����Id������Ե�����
	 * @param @param id
	 * @param @return   
	 * @return ZiZhiSeal  
	 * @throws
	 * @author С��
	 * @date 2017��5��10��
	 */
	ZiZhiSeal queryOneOneself(int id);
	/**
	 * 
	 * @Description: ����������������������
	 * @param @return   
	 * @return List<ZiZhiSeal>  
	 * @throws
	 * @author С��
	 * @date 2017��5��18��
	 */
	List<ZiZhiSeal> approverZiZhiSeal(@Param("startPage")int startPage,@Param("rows")int rows);
	
	/**
	 * 
	 * @Description: ��ȡ������������
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��5��18��
	 */
	int approverTotal();
	
	int handling(ZiZhiSeal z);
	/**
	 * 
	 * @Description: ����id�����������û���
	 * @param @param id
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author С��
	 * @date 2017��5��31��
	 */
	String requestName(int id);
	/**
	 * 
	 * @Description:�޸�������
	 * @param @param z
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��8��7��
	 */
	int updateZiZhiSeal(ZiZhiSeal z);
}	
