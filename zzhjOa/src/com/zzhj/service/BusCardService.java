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
}
