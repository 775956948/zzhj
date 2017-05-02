package com.zzhj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzhj.mapper.CarInfoMapper;
import com.zzhj.mapper.CarMapper;
import com.zzhj.po.Car;
import com.zzhj.po.CarInfo;

@Service
public class CarInfoService {
	@Resource(name="carInfoMapper")
	private CarInfoMapper cm ;
	@Resource(name="carMapper")
	private CarMapper carM;
	public Map<String,Object> getCarInfo(int page,int rows){
		int start = (page-1)*rows;
		List<CarInfo> list=cm.getCarInfo(start,rows);
		int total =cm.totalCount();
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	public void saveCarInfo(CarInfo carInfo){
		int id =carM.CarId(carInfo.getCarId().getCarNo());
		carInfo.getCarId().setId(id);
		Car car = carInfo.getCarId();
		car.setState("不可用");
		carM.updateState(car);
		cm.saveCarInfo(carInfo);
	}
	
	public void delCarInfo(CarInfo carInfo){
		int id =carM.CarId(carInfo.getCarId().getCarNo());
		Car car =carInfo.getCarId();
		car.setId(id);
		car.setState("可用");
		carM.updateState(car);
		cm.delCarInfo(carInfo);
	}
	public void updateCarInfo(CarInfo carInfo){
		int id =carM.CarId(carInfo.getCarId().getCarNo());
		Car car =carInfo.getCarId();
		car.setId(id);
		car.setState("可用");
		carM.updateState(car);
		cm.updateCarInfo(carInfo);
	}
	public CarInfo carInfoId(int id){
		CarInfo carInfo = cm.carInfoId(id);
		carInfo.setStartDate(insertChar(carInfo.getStartDate()));
		String overDate =carInfo.getOverDate();
		if(overDate!=null&&!"".equals(overDate)){
			carInfo.setOverDate(insertChar(carInfo.getOverDate()));
		}
		System.out.println(carInfo.getStartDate());
		return carInfo;
	}
	private String insertChar(String str){
		char [] chars =str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 19; i++) {
			if(i==10){
				chars[i]='T';
			}
			sb.append(chars[i]);
		}
		return sb.toString();
	}
	
}
