package com.zzhj.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.entityCustom.Message;
import com.zzhj.entityCustom.MessageType;
import com.zzhj.mapper.NoticeMapper;
import com.zzhj.po.Notice;
import com.zzhj.webSocket.ServerHandler;

@Service
public class NoticeService {
	@Autowired
	private NoticeMapper nm;
	
	public List<Notice> queryAll(){
		return nm.queryAll();
	}
	
	public int save(Notice n){
		Date today=new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		String time=f.format(today);
		n.setReleaseDate(time);
		Message msg = new Message();
		msg.setType(MessageType.notice);
		ServerHandler.sendAll(msg);
		return nm.save(n);
	}
	
	public Notice queryOne(int id){
		return nm.queryOne(id);
	}
	/**
	 * 
	 * @Description: ��ҳ��ѯ���й���
	 * @param @param page
	 * @param @param rows
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author С��
	 * @date 2017��6��22��
	 */
	public Map<String,Object> queryAllList(int page,int rows){
		Map<String,Object> map =new HashMap<String,Object>();
		int startPage=(page-1)*rows;
		List<Notice> list =nm.queryAllList(startPage, rows);
		int total =nm.totalCount();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	/**
	 * 
	 * @Description: ����idɾ��һ������
	 * @param @param noticeId
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author С��
	 * @date 2017��6��22��
	 */
	public int deleteNotice(int noticeId){
		return nm.deleteNotice(noticeId);
	}
}
