package com.zzhj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.mapper.BusCardRecordMapper;
import com.zzhj.po.BusCardRecord;

@Service
public class BusCardRecordService {
	
	@Autowired
	private BusCardRecordMapper brm;
	
	public Map<String,Object> queryAll(int page,int rows){
		int startPage =(page-1)*rows;
		List<BusCardRecord> list = brm.queryAll(startPage, rows);
		int total =brm.totalCount();
		Map<String,Object> map = new HashMap();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
}
