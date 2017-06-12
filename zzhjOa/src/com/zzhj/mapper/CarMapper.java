package com.zzhj.mapper;

import java.util.List;

import com.zzhj.po.Car;

public interface CarMapper {
	List<Car> getAll();
	int CarId(String carNo);
	void updateState(Car car);
	int addCar(Car c);
}	
