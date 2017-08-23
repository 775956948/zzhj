<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公告详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" type="image/x-icon" href="../image/oa.ico" media="screen" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#parent{
			width: 90%;
			margin:auto;
			overflow:hidden;
			background-color: F8F8F8;
			box-shadow: 10px 10px 10px  #888888;
			padding: 20px;
		}
		.li{
			float: left;
			margin-left: 130px;
			list-style: none;
		}
		.clear{
			clear: left;
		}
		#head h2{
			width:200px;
			margin: auto;
		}
		#head{
			width: 100%;
			height: 100px;
			padding-top: 40px;
		}
		body{
			background-color: E6EFFF;
		}
	</style>
  </head>
  
  <body>
  	<div id="head">
  		<h2>公告详情</h2>
  	</div>
  	<div id="parent">
  		<ul id="title">
  			<li class="li"><h4>发布人:${notice.userId.name }</h4></li>
  			<li class="li"><h4>发布时间:${notice.releaseDate }</h4></li>
  			<li class="li"><h4>主题:${notice.theme }</h4></li>
  		</ul>
  		<hr class="clear"/>
  		<div class="clear">${notice.text }</div>
  	</div>
  </body>
</html>
