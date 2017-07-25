package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.Abnormal;
import com.zzhj.po.Rest;

public interface AbnormalMapper {
	int save(Abnormal abnormal);
	List<Rest> queryAll(@Param("startPage") int startPage,@Param("rows") int rows);
	int totalCount();
	int deleteAbnormal(int id); 
}
