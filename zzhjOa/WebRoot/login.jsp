<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
	<style type="text/css">
		#table{
			width: 90%;
			height: 50%;
			margin: 0 auto;
			text-align: center;
		}
		#table input{
			height: 30px;
		}
		.button{
			width: 100px;
			height: 40px;
			margin-left: 60%;
			margin-top: 15%;
		}
		#max{
			width: 35%;
			border-radius:50px;
			height: 50%;
			margin: 0 auto;
			margin-top:14%;
			background-color:DAD4D1;
			
		}
		body{
			background-image: url(image/login.png);
			background-size:cover;
			margin: 0px;
		}
		.color{
			color: FFFFFF;
			margin-left: 30%;
		}
	</style>
  </head>
  <body>
  	<div id="max">
  		<img alt="" src="image/logo_02.png" style="width: 50%">
  		<form action="" method="post" id="form">
    <table id="table">
    	<tr>
    		<td colspan="2">
    			<h2 class="color">Oa办公系统登陆</h2>
    		</td>
    	</tr>
    	<tr>
    		<td>用户名</td>
    		<td colspan="2"><input type="text" name="name"/></td>
    	</tr>
    	<tr>
    		<td>密码  </td>
    		<td colspan="2"><input type="password" name="password"/></td>
    		<td><a href="back.jsp">忘记密码？</a></td>
    	</tr>
    	<tr>
    		<td><input type="button" value="登陆" onclick="login()" class="button" /></td>
    		<td><input type="button" value="注册" onclick="registered()" class="button" /></td>
    	</tr>
    	<tr>
    		<td colspan="2">${message }</td>
    	</tr>
    </table>
    </form>
  	</div>
  </body>
</html>
