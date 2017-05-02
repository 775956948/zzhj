package com.zzhj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzhj.po.Car;
import com.zzhj.service.CarService;

@Controller
@RequestMapping("/car")
public class CarAction {
	@Resource(name="carService")
	private CarService cs ;
	
	@RequestMapping("/getAll.action")
	@ResponseBody
	public List<Car> getAll(){
		return cs.getAll();
	}
}
