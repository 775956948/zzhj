package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.OfficeSupplies;

public interface OfficeSuppliesMapper {
	
	/**
	 * 
	 * @Description: ���һ����Ʒ
	 * @param @param o
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	public int saveOfficeSupplies(OfficeSupplies o);
	/**
	 * 
	 * @Description: �޸���Ʒ��Ϣ
	 * @param @param o
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	public int updateOfficeSupplies(OfficeSupplies o);
	/**
	 * 
	 * @Description: ��ѯ������Ʒ��Ϣ
	 * @param @param rows
	 * @param @param startPage
	 * @param @return   
	 * @return List<OfficeSupplies>  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	public List<OfficeSupplies> queryAll(@Param("rows")int rows,@Param("startPage")int startPage);
	/**
	 * 
	 * @Description: ��Ʒ����
	 * @param @param number
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	public int reduce(@Param("number")int number,@Param("id")int id);
	/**
	 * 
	 * @Description: ������Ʒ�Ŀ����
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	public int balance(int id);
	/**
	 * 
	 * @Description: �õ�������
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	public int totalCount();
	/**
	 * 
	 * @Description: ģ����ѯ��Ʒ
	 * @param @param goodsName
	 * @param @return   
	 * @return List<OfficeSupplies>  
	 * @throws
	 * @author С��
	 * @date 2017��7��10��
	 */
	public List<OfficeSupplies> likeQuey(String goodsName);
	/**
	 * 
	 * @Description: ɾ��һ����Ϣͬʱ����ɾ�����й�������Ϣ
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��8��1��
	 */
	public int deleteGoods(int id);
	
	
}
