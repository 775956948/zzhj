package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.BusCard;

public interface BusCardMapper {
	List<BusCard> queryAll();
	int updateState(@Param("busCardId")int busCardId,@Param("state")String state);
}
