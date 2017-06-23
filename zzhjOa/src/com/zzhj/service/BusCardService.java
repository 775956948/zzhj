package com.zzhj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.mapper.BusCardMapper;
import com.zzhj.po.BusCard;

@Service
public class BusCardService {
	@Autowired
	private BusCardMapper bm;
	
	public List<BusCard> queryAll(){
		return bm.queryAll();
	}
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
	public int save(BusCard b){
		b.setState("可用");
		return bm.save(b);
	}
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
	public int delete(int cardId){
		return bm.delete(cardId);
	}
}
