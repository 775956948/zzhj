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
	 * @Description: ����һ������
	 * @param @param c
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��9��
	 */
	public int addCar(Car c){
		c.setState("����");
		return cp.addCar(c);
	}
}
