package com.zzhj.service;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.BeforeAdvice;

public class PointCat implements BeforeAdvice{

	public void before(){
		System.out.println("before action");
	}
}
