package com.zzhj.mapper;

import java.util.List;

import com.zzhj.po.Notice;

public interface NoticeMapper {
	/**
	 * 
	 * @Description: ���һ������
	 * @param @param n
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��1��
	 */
	int save(Notice n);
	/**
	 * 
	 * @Description:��ѯ���й���
	 * @param @return   
	 * @return List<Notice>  
	 * @throws
	 * @author С��
	 * @date 2017��6��1��
	 */
	List<Notice> queryAll();
	/**
	 * 
	 * @Description: ����Id��ѯĳһ��������Ϣ
	 * @param @param id
	 * @param @return   
	 * @return Notice  
	 * @throws
	 * @author С��
	 * @date 2017��6��1��
	 */
	Notice queryOne(int id);
}
