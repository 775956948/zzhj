package com.zzhj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.BusCard;
import com.zzhj.service.BusCardService;

@Controller
@RequestMapping("/busCard")
public class BusCardAction {

	@Autowired
	private BusCardService bs;
	
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public List<BusCard> queryAll(){
		return bs.queryAll();
	}
	@RequestMapping("/save.action")
	@ResponseBody
	public int save(BusCard b){
		return bs.save(b);
	}
	@RequestMapping("delete.action")
	@ResponseBody
	public int delete(int cardId){
		return bs.delete(cardId);
	}
}
