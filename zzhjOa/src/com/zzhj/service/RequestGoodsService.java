package com.zzhj.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzhj.mapper.OfficeSuppliesMapper;
import com.zzhj.mapper.RequestGoodsMapper;
import com.zzhj.mapper.UsersMapper;
import com.zzhj.po.RequestGoods;
import com.zzhj.po.Users;

import utils.DateFormater;

@Service
public class RequestGoodsService {
	
	@Autowired
	private RequestGoodsMapper rgm;
	@Autowired
	private OfficeSuppliesService os;
	@Autowired
	private UsersMapper um;
	
	
	/**
	 * 
	 * @Description: 添加一天申请
	 * @param @param g
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	public int saveRequestGoods(RequestGoods g){
		List<Users> list = um.queryRoleUser("行政");
		g.setApprover(list.get(0).getName());
		g.setState("待审批");
		g.setRequestDate(DateFormater.format(new Date()));
		return rgm.saveRequestGoods(g);
	}
	
	/**
	 * 
	 * @Description: 查看所有申请单
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<RequestGoods>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	public Map<String,Object> queryAll(int page,int rows){
		Map<String,Object> map = new HashMap<String,Object>();
		int startPage =(page-1)*rows;
		List<RequestGoods> list = rgm.queryAll(startPage, rows);
		map.put("rows", list);
		map.put("total", rgm.totalCount());
		return map;
	}
	/**
	 * 
	 * @Description: 查看自己的申请单
	 * @param @param startPage
	 * @param @param rows
	 * @param @return   
	 * @return List<RequestGoods>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	public Map<String,Object>  queryOwnAll(int userId,int page,int rows){
		Map<String,Object> map = new HashMap<String,Object>();
		int startPage =(page-1)*rows;
		List<RequestGoods> list = rgm.queryOwnAll(userId, startPage, rows);
		map.put("rows", list);
		map.put("total", rgm.totalCount());
		return map;
	}
	/**
	 * 
	 * @Description: 审批报销单
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	public int approver(int id,String approverName,int number){
		System.out.println("+++++++++++++"+AopUtils.isAopProxy(this));
		System.out.println("+++++++++++++"+AopUtils.isCglibProxy(this));
		System.out.println("+++++++++++++"+AopUtils.isJdkDynamicProxy(this));
		System.out.println(this);
		String date =DateFormater.format(new Date());
		int resoult=rgm.approver(id, date,approverName);
		RequestGoods rg =rgm.queryId(id);
		int update=0;
		if(resoult>0){
			update=os.reduce(number,/* rg.getGoodId().getId()*/22);
		}
		return update;
	}
	
	/**
	 * 
	 * @Description: 删除一个申请单
	 * @param @param id
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author 小白
	 * @date 2017年7月10日
	 */
	public int delete(int id){
		return rgm.delete(id);
	}
	/**
	 * 
	 * @Description: 根据申请人模糊查询
	 * @param @param userName
	 * @param @return   
	 * @return List<RequestGoods>  
	 * @throws
	 * @author 小白
	 * @date 2017年7月11日
	 */
	public List<RequestGoods> likeUserQueryAll(String userName){
		return rgm.likeUserQueryAll(userName);
	}


}
