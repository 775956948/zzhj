package com.zzhj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzhj.mapper.JobLogMapper;
import com.zzhj.po.JobLog;

@Service
public class JobLogService {
 
	@Resource(name="jobLogMapper")
	private JobLogMapper jlm;
	
	public int saveJobLig(JobLog jobLog){
		
		return jlm.saveJobLog(jobLog);
	}
	
	public List<JobLog> query(int id,int rows,int page){
		int startPage=(page-1)*rows;
		return jlm.query(startPage, rows, id);
	}
	
	public List<JobLog> search(int rows,int page,JobLog jobLog){
		int startPage=(page-1)*rows;
		Map map = new HashMap();
		map.put("rows",rows);
		map.put("startPage", startPage);
		map.put("jobLog", jobLog);
		return jlm.search(map);
	}
	
	public int deleteJobLog(int id){
		
		return jlm.deleteJobLog(id);
	}
}
