package com.zzhj.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
}
