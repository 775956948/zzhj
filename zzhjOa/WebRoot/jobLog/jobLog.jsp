<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dayLog.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table id="jobLogtt" style="width:600px;height:400px"></table>  
    
    
    <script type="text/javascript">
			$('#jobLogtt').treegrid({    
   				 url:'function/getNode.action',    
   				 idField:'id',    
    			treeField:'id',    
   				columns:[[    
        		{title:'Task Name',field:'id',width:180},    
        		{field:'text',title:'Persons',width:60,align:'right'},    
       			 {field:'begin',title:'Begin Date',width:80},    
       		 	{field:'end',title:'End Date',width:80}    
    			]]    
			}); 
    </script>
  </body>
</html>
