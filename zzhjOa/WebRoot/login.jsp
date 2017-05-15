<!--<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>中兆恒基Oa登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" href="css/basic.css" />
	<link rel="stylesheet" href="css/login.css" />
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript">
		function registered(){
			$("#form").attr("action", "department/queryAll.action");
			$("#form").submit();
		}
		function login(){
			$("#form").attr("action", "users/login.action");
			$("#form").submit();
		}
		
		$(document).keydown(function(event){
    		var  code = event.keyCode;
    		if(code==13){
    			login();
    		}
		});
	</script>
  </head>
  <body>
  	<div class="login_header">
  		<div class="header_container"> 
  			<a href="#" class="logo_btn"><img src="image/logo_02.png"/></a>
  			<!--<span>Oa办公系统登陆</span>-->
  		</div>
  	</div>
  	<div class="login_main">
  		<div id="max" class="login_table">
	  		<form action="" method="post" id="form">
				    <table id="table">
					    <tr>			    	
					    		<h5>登录</h5>
					    </tr>
					    	<tr>
					    		<td colspan="2" class="">

					    			<input type="text" name="name" class="login_input login_input-icon1" placeholder="请输入用户名"/>
					    		</td>
					    	</tr>
					    	<tr>
					    
					    		<td colspan="2" class="">

					    			<input type="password" name="password" class="login_input login_input-icon2" placeholder="请输入密码"/>
					    		</td>
					    		
					    	</tr>
					    	<tr>
					    		<td><input type="button" value="立 即 登 录" onclick="login()" class="button" /></td>
					    		
					    	</tr>
					    	 <tr>
					    		<td>
					    			<a href="back.jsp" class="forget_btn">忘记密码？</a><a href="javascript:;" class="register_btn" onclick="registered()">没账号？点击注册</a>
					    		</td>
					    		
					    	</tr>
					   		 <tr>
					    		<td colspan="2">${message }</td>
					    	</tr>
				    	</table>  
		    </form>
	    	</div>
  	</div>
  </body>
</html>
