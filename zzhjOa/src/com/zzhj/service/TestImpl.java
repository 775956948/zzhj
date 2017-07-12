package com.zzhj.service;

import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Service;
@Service
public class TestImpl implements Test{

	@Override
	public void test() {
		System.out.println(this);
		
	}
}
