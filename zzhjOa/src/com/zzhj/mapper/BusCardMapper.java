package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.BusCard;

public interface BusCardMapper {
	List<BusCard> queryAll();
	int updateState(@Param("busCardId")int busCardId,@Param("state")String state);
	/**
	 * 
	 * @Description: 添加一卡通
	 * @param @param b
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月23日
	 */
	int save(BusCard b);
	/**
	 * 
	 * @Description: 删除一条信息
	 * @param @param cardId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月23日
	 */
	int delete(int cardId);
}
