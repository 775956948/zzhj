package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.CarInfo;

public interface CarInfoMapper {
	List<CarInfo> getCarInfo(@Param("start")int start,@Param("rows")int rows);
	void saveCarInfo(CarInfo carInfo);
	void delCarInfo(CarInfo carInfo);
	void updateCarInfo(CarInfo carInfo);
	CarInfo carInfoId(int id);
	int totalCount();
}
