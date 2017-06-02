package com.zzhj.mapper;

import java.util.List;

import com.zzhj.po.Notice;

public interface NoticeMapper {
	/**
	 * 
	 * @Description: 添加一个公告
	 * @param @param n
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年6月1日
	 */
	int save(Notice n);
	/**
	 * 
	 * @Description:查询所有公告
	 * @param @return   
	 * @return List<Notice>  
	 * @throws
	 * @author 小白
	 * @date 2017年6月1日
	 */
	List<Notice> queryAll();
	/**
	 * 
	 * @Description: 根据Id查询某一个公告信息
	 * @param @param id
	 * @param @return   
	 * @return Notice  
	 * @throws
	 * @author 小白
	 * @date 2017年6月1日
	 */
	Notice queryOne(int id);
}
