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
    <table id="jobLogtt"></table>  
    
    <div id="jobLogDd"  class="easyui-dialog" closed=true >
    	 <div id="jobLogTb">
    	 	<input id="jobLogDd" type="text" class="easyui-datebox" ></input>
    	 	<div style="margin-left:100px; display: inline;">
    	 		选择类型：  
				<select id="type">
					<option>工作日报</option>
					<option>工作周报</option>
				</select>
			</div>
			<button style="margin-left:100px;">搜索</button>
		</div>
		<table id="jobLogDg"></table>  
	</div>
    <script type="text/javascript">
    	var id;
			$('#jobLogtt').treegrid({    
   				url:'users/roleUser.action',    
   				idField:'id',    
    			treeField:'text',    
   				columns:[[    
        		{field:'id',title:'编号',formatter:function(value){ id=value;},hidden:true},    
        		{field:'text',title:'名称',width:300}, 
        		{field:'departmentName',title:'部门',width:200}, 
        		{field:'roleName',title:'职位',width:200},    
       		 	{field:'null',title:'查看',width:200,formatter:function(){
       		 		return "<a href='javascript:selectLog("+id+")'>查看 </a>";
       		 	}}    
    			]]    
			}); 
			
			function selectLog(id){
				$('#jobLogDd').dialog({    
   					 title: '查看日志',    
   					 width: 600,    
    				height: 300,    
    				closed: false,     
    				modal: true ,
    				onOpen:function(){
    					
    				} 
			});  
		}
    </script>
  </body>
</html>
