package com.zzhj.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	
	@RequestMapping("/addCar.action")
	@ResponseBody
	public int addCar(Car c){
		return cs.addCar(c);
	}

}
