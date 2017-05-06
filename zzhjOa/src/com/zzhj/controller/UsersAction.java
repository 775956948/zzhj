package com.zzhj.controller;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zzhj.listener.SessionListener;
import com.zzhj.po.Users;
import com.zzhj.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersAction {
	
	@Resource(name="usersService")
	private UsersService us;
	
	@RequestMapping("/login.action")
	public ModelAndView login(Users users,HttpSession session){
		Users user=us.login(users);
		ModelAndView mv = new ModelAndView();
		if(user!=null&&!user.getName().equals("")){
			session.setAttribute("users", user);
			mv.setViewName("redirect: ../main.jsp");
		}else{
			mv.addObject("message", "账户或密码错误");
			mv.setViewName("/login.jsp");
		}
		return mv;
		
	}
	@RequestMapping("/save.action")
	public ModelAndView save(Users users){
		String message =us.save(users);
		ModelAndView mv = new ModelAndView();
		Pattern pattern = Pattern.compile("[0-9]*"); 
		Matcher isNum = pattern.matcher(message);
		if(!message.equals("")&&!isNum.matches()){
			mv.addObject("message", message);
			mv.setViewName("/department/queryAll.action");
		}else{
			mv.setViewName("/login.jsp");
		}
		return mv;
	}
	@RequestMapping("/exit.action")
	@ResponseBody
	public String exit(HttpSession session){
		session.removeAttribute("users");
		return "login.jsp";
	}
	@RequestMapping("/queryAll.action")
	@ResponseBody
	public Map<String,Object> queryAll(int page,int rows){
		return us.queryAll(page, rows);
	}
	@RequestMapping("/deleteUser.action")
	@ResponseBody
	public String deleteUser(int id,HttpSession session){
		Users user =(Users) session.getAttribute("users");
		String message =us.deleteUser(id,user.getName());
		if(true){
			List<HttpSession> list=SessionListener.list;
			for (int i = 0; i < list.size(); i++) {
				HttpSession sessionListener = list.get(i);
				Users users = (Users) sessionListener.getAttribute("users");
				if(users!=null&&users.getId()==id){
					sessionListener.removeAttribute("users");
				}
			}
		}
		return message;
	}
	
	@RequestMapping("/updateRole.action")
	@ResponseBody
	public int updateRole(Users user){
		return us.updateRole(user);
	}
	
	@RequestMapping("/updateUser.action")
	public ModelAndView updateUser(Users user){
		ModelAndView mv = new ModelAndView();
		int count =us.updateUser(user);
		if(count>0){
			mv.setViewName("/login.jsp");
		}else{
			mv.addObject("message", "该用户名不存在");
			mv.setViewName("/back.jsp");
		}
		return mv;
	}
	/**
	 * 
	 * @Description: 返回相同部门的主管或部门经理
	 * @param @param departmentName 部门名称
	 * @param @param roleName 角色名称（职位）
	 * @param @return  
	 * @return List<Users>  返回用户集合
	 * @throws
	 * @author 小白
	 * @date 2017年4月25日
	 */
	@RequestMapping("/queryUser.action")
	@ResponseBody
	public List<Users> queryUser(String departmentName,String roleName){
		return us.queryUser(departmentName, roleName);
	}
	
	@RequestMapping("/roleUser.action")
	@ResponseBody
	public List<Users> roleUser(Integer id,HttpSession session){
		Users u =(Users) session.getAttribute("users");
		if(id!=null&&id!=0){
			u.setParentId(id);
		}else{
			u.setParentId(null);
		}
		return us.roleUser(u);
	}
}
