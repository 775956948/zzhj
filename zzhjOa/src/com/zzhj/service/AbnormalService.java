package com.zzhj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzhj.mapper.AbnormalMapper;
import com.zzhj.mapper.RestMapper;
import com.zzhj.po.Abnormal;
import com.zzhj.po.Rest;

@Service
public class AbnormalService {
	@Resource(name="abnormalMapper")
	private AbnormalMapper am;

	public int save(Abnormal abnormal){
		return am.save(abnormal);
	}
	
	public Map<String,Object> queryAll(int page,int rows){
		int total = am.totalCount();
		int startPage =(page-1)*rows;
		List<Rest> list = am.queryAll(startPage, rows);
		Map map = new HashMap<String,Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	
	public int deleteRest(int id){
		return  am.deleteAbnormal(id);
	}
	
}
