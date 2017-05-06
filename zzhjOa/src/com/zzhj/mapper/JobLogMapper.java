package com.zzhj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zzhj.po.JobLog;

public interface JobLogMapper {
	int saveJobLog(JobLog jobLog);
	List<JobLog> query(@Param("startPage") int startPage,@Param("rows") int rows,@Param("id")int id);
	int totalCount();
	List<JobLog> search(Map map);
	int deleteJobLog(int id);
	JobLog queryId(int id);
}
