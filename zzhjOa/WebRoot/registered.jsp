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
	<script type="text/javascript">
		function submits(){
			var cout=0;
			$("input").each(function(){
				if($(this).val()==''||$(this)==null){
					cout++;
				}
			});
			if(cout<1){
				$("#form").submit();
			}else{
				window.alert("信息填写不完整");
			}
			
		}
	</script>
  </head>
  
  <body>
   	<div id="max">
   		<img alt="" src="image/logo_02.png" style="width: 50%">
  		<form action="users/save.action" method="post" id="form">
    	<table id="table">
    		<tr>
    			<td colspan="4">
    				<h2>用户注册</h2>
    			</td>
    		</tr>
    		<tr>
    			<td>用户名</td>
    			<td><input type="text" name="name"/></td>
    			<td>密码</td>
    			<td><input type="text" name="password"/></td>
    		</tr>
    		<tr>
    			<td>性别</td>
    			<td>男<input type="radio" name="sex" checked="checked" value="男"/>女<input type="radio" name="sex" value="女"/></td>
    			<td>出生起日</td>
    			<td><input name="birthday" type="date"/></td>
    		</tr>
    		<tr>
    			<td>部门</td>
    			<td>
    				<select name="departmentId.id">
    					<c:forEach items="${department }" var="dpm">
    						<option value="${dpm.id }">${dpm.name }</option>
    					</c:forEach>
    				</select>
    			</td>
    			<td>手机号</td>
    			<td><input type="text" name="phone"/></td>
    		</tr>
    		<tr>
    			<td colspan="4">
    				<input type="button" value="注册"  style="width:100px" onclick="submits()"/>
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
