package com.zzhj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzhj.mapper.SealMapper;
import com.zzhj.po.Seal;

@Service
public class SealService {
	@Resource(name="sealMapper")
	private SealMapper sm;

	public List<Seal> queryAll(){
		return sm.queryAll();
	}
}
