package com.zzhj.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.zzhj.po.CarInfo;
import com.zzhj.service.CarInfoService;

@Controller
@RequestMapping("/carInfo")
public class CarInfoAction {
	@Resource(name="carInfoService")
	private CarInfoService cs;
	
	@RequestMapping("/getCarInfo.action")
	@ResponseBody
	public Map<String,Object> getCarInfo(int page,int rows){
		return cs.getCarInfo(page,rows);
	}
	@RequestMapping("/saveCarInfo.action")
	@ResponseBody
	public int saveCarInfo(CarInfo carInfo){
		return cs.saveCarInfo(carInfo);
	}
	
	@RequestMapping("/delCarInfo.action")
	@ResponseBody
	public int delCarInfo(CarInfo carInfo){
		return cs.delCarInfo(carInfo);
	}
	@RequestMapping("/updateCarInfo.action")
	@ResponseBody
	public int  updateCarInfo(CarInfo carInfo){
		return cs.updateCarInfo(carInfo);
	}
	@RequestMapping("/carInfoOne.action")
	@ResponseBody
	public CarInfo carInfoId(int id){
		return cs.carInfoId(id);
	}
	
}
