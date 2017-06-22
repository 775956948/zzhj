package com.zzhj.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zzhj.listener.SessionListener;
import com.zzhj.po.Users;
import com.zzhj.service.UsersService;
import com.zzhj.webSocket.ServerHandler;

@Controller
@RequestMapping("/users")
public class UsersAction {
	
	@Resource(name="usersService")
	private UsersService us;
	
	@RequestMapping("/login.action")
	public ModelAndView login(Users users,HttpSession session){
		Users existingUser = (Users) session.getAttribute("users");
		ModelAndView mv = new ModelAndView();
		if(existingUser==null){
			Users user=us.login(users);
			if(user!=null&&!user.getName().equals("")){
				session.setAttribute("users", user);
				mv.setViewName("redirect: ../main.jsp");
			}else{
				session.setAttribute("loginMessage","用户名或密码错误");
				mv.setViewName("redirect: ../login.jsp");
			}
		}else{
			mv.setViewName("redirect: ../main.jsp");
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
	@ResponseBody
	public int updateUser(Users user){
		
		return us.updateUser(user);
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
	@RequestMapping("/queryUserInfoOne.action")
	@ResponseBody
	public Users queryUserInfoOne(int id){
		return us.queryUserInfoOne(id);
	}
	
	//上传文件
	@RequestMapping(value="/updateUserInfo.action")
	public String updateUserInfo(HttpServletRequest request,HttpSession session){
		String path=request.getServletContext().getRealPath("/image");
		Users user = new Users();
		DiskFileItemFactory factory = new DiskFileItemFactory();  
        // 内存存储的最大值  
        factory.setSizeThreshold(4096);  
  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        //设置文件上传大小  
        upload.setSizeMax(1000000 * 20);  
        try {  
            List fileItems = upload.parseRequest(request);  
            String itemNo = "";  
            for (Iterator iter = fileItems.iterator(); iter.hasNext();) {  
                FileItem item = (FileItem) iter.next();  
                  
                //是普通的表单输入域  
                if(item.isFormField()) {  
                    switch (item.getFieldName()) {
                    case "id":
                    	user.setId(Integer.parseInt(item.getString()));
					case "password":
						user.setPassword(item.getString());
						break;
					case "phone":
						user.setPhone(item.getString());
						break;
					case "inductionDate":
						user.setInductionDate(item.getString());
						break;
					case "positiveDate":
						user.setPositiveDate(item.getString());
						break;
					case "birthday":
						user.setBirthday(item.getString());
						break;
					case "sex":
						user.setSex(item.getString("utf-8"));
						break;
					}
                }  
                //是否为input="type"输入域  
                if (!item.isFormField()) {  
                    String fileName = item.getName();  
                    long size = item.getSize();  
                    if ((fileName == null || fileName.equals("")) && size == 0) {  
                        continue;  
                    }  
                    //截取字符串 如：C:\WINDOWS\Debug\PASSWD.LOG  
                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());  
                    item.write(new File(path, fileName));  
                    user.setImageName(fileName);
                }  
            }
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        int result=us.updateUserInfo(user);
        String view="";
        if(result>0){
        	session.removeAttribute("users");
        	view="redirect: ../login.jsp";
        }else{
        	view="redirect: ../error/500.html";
        }
        return view;
	}
	@RequestMapping("/searchUserInfo.action")
	@ResponseBody
	public Map searchUserInfo(int page,int rows,Users user){
		return us.searchUserInfo(page, rows, user);
	}
	@RequestMapping("/querySubclass.action")
	@ResponseBody
	public List<String> querySubclass(HttpSession session){
		Users user =(Users) session.getAttribute("users");
		return us.querySubclass(user.getDepartmentId().getName());
	}
	
	@RequestMapping("/querySubZhuGuan.action")
	@ResponseBody
	public List<String> querySubZhuGuan(HttpSession session){
		Users user =(Users) session.getAttribute("users");
		return us.querySubZhuGuan(user.getDepartmentId().getName());
	}
	@RequestMapping(value="/userExist.action",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String userExist(String userName){
		return us.userExist(userName);
	}
}
