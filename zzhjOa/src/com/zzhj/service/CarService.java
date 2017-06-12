package com.zzhj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzhj.mapper.CarMapper;
import com.zzhj.po.Car;

@Service
public class CarService {
	
	@Resource(name="carMapper")
	private CarMapper cp ;
	
	
	public List<Car> getAll(){
		return cp.getAll();
	}
	/**
	 * 
	 * @Description: 新增一个车辆
	 * @param @param c
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月9日
	 */
	public int addCar(Car c){
		c.setState("可用");
		return cp.addCar(c);
	}
}
