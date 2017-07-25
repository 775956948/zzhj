package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.BusCard;

public interface BusCardMapper {
	List<BusCard> queryAll();
	/**
	 * 
	 * @Description: �޸�״̬
	 * @param @param busCardId
	 * @param @param state
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��7��25��
	 */
	int updateState(@Param("busCardId")int busCardId,@Param("state")String state);
	/**
	 * 
	 * @Description: ���һ��ͨ
	 * @param @param b
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��23��
	 */
	int save(BusCard b);
	/**
	 * 
	 * @Description: ɾ��һ����Ϣ
	 * @param @param cardId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��23��
	 */
	int delete(int cardId);

}
