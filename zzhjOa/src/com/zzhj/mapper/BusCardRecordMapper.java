package com.zzhj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.BusCardRecord;

public interface BusCardRecordMapper {
	public List<BusCardRecord> queryAll(@Param("startPage")int startPage,@Param("rows")int rows);
	public int save(BusCardRecord b);
	public int delete(int id);
	public int update(BusCardRecord b);
	public int totalCount();
}
