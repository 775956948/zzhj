package com.zzhj.service;

import org.springframework.stereotype.Service;

@Service
public class ActionImpl implements Actions {

	@Override
	public void action() {
		System.out.println("actionImpl.action()");

	}

}
