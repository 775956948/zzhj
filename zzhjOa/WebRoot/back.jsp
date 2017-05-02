<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>中兆恒基Oa注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<style type="text/css">
		#table{
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
		}
		#max{
			width: 35%;
			height: 50%;
			margin: 0 auto;
			margin-top: 14%;
			background-color: DAD4D1;
		}
		body{
			background-image: url(image/registered.png);
			background-size:cover;
			margin: 0px;
		}
	</style>
  </head>
  
  <body>
   	<div id="max">
   		<img alt="" src="image/logo_02.png" style="width: 50%">
  		<form action="users/updateUser.action" method="post">
    	<table id="table">
    		<tr>
    			<td colspan="4">
    				<h2>密码找回</h2>
    			</td>
    		</tr>
    		<tr>
    			<td>用户名</td>
    			<td><input type="text" name="name"/></td>
    			<td>新密码</td>
    			<td><input type="password" name="password"/></td>
    		</tr>
						
    		<tr>
    			<td colspan="4">
    				<input type="submit" value="修改"/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="4">
    				${message }
    			</td>
    		</tr>
    	</table>
    </form>
  	</div> 
  </body>
</html>
