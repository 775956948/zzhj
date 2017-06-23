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
	 * @Description: ���һ��ͨ
	 * @param @param b
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��23��
	 */
	public int save(BusCard b){
		b.setState("����");
		return bm.save(b);
	}
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
	public int delete(int cardId){
		return bm.delete(cardId);
	}
}
