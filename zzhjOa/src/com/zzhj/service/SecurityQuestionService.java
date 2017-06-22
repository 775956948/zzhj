package com.zzhj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.mapper.SecurityQuestionMapper;
import com.zzhj.po.SecurityQuestion;

@Service
public class SecurityQuestionService {

	@Autowired
	private SecurityQuestionMapper sqm;
	
	public List<SecurityQuestion> queryAll(){
		return sqm.queryAll();
	}
}
