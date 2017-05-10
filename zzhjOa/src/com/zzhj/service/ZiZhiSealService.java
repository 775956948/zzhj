package com.zzhj.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.zzhj.mapper.UsersMapper;
import com.zzhj.mapper.ZiZhiSealMapper;
import com.zzhj.po.Users;
import com.zzhj.po.ZiZhiSeal;

@Service
public class ZiZhiSealService {
	@Resource(name="ziZhiSealMapper")
	ZiZhiSealMapper  zs;
	@Resource(name="usersMapper")
	UsersMapper um;
	public Map<String,Object> queryAll(int page,int rows){
		int startPage =(page-1)*rows;
		Map<String,Object> map = new HashMap<String,Object>();
		List<ZiZhiSeal> list = zs.queryAll(startPage,rows);
		int totalCount =zs.totalCount();
		map.put("rows", list);
		map.put("total",totalCount);
		return map;
	}
	
	public int save(ZiZhiSeal z){
		Users user =um.userId(z.getUserId().getDepartmentId().getName());
		Date today=new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		String time=f.format(today);
		z.setRequestDate(time);
		z.setState("´ýÉóÅú");
		z.setApprover(user.getName());
		return zs.save(z);
	}
	public int delete(int id){
		return zs.delete(id);
	}
	public Map<String,Object> queryOneself(int userId,int page,int rows){
		int startPage =(page-1)*rows;
		Map<String,Object> map = new HashMap<String,Object>();
		List<ZiZhiSeal> list = zs.queryOneself(userId,startPage,rows);
		int totalCount =zs.totalCountOneself(userId);
		map.put("rows", list);
		map.put("total",totalCount);
		return map;
	}
	public ZiZhiSeal queryOneOneself(int id){
		return zs.queryOneOneself(id);
	}
}
