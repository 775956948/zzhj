<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理</title>
    
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
  	  	<div id="userTb">
			<a  class="easyui-linkbutton" iconCls="icon-Remove" plain="true" onclick="deleteUser()">刪除</a>
			<a  class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateUser()">分配角色</a>
		</div>
		<div id="userDd"  class="easyui-dialog" closed=true >
			<form>
			<table id="table">
				<tr>
					<td><input type="text" name="name" disabled="disabled"/></td>
					<td colspan="2">请选择角色:<select name="roleId.id" onchange="change()"></select></td>
				</tr>
				<tr>
					<td id="zhuGuan">请选择主管:<select name="zhuGuan"></select></td>
					<td id="dManager">请选择部门经理:<select name="dManager"></select></td>
					<td id="manager">请选择副总:<select name="manager"></select></td>
				</tr>
				<tr align="center">
					<td colspan="3"><input type="button" value="分配"  style="width: 150px; height: 30px;  margin-top: 40px;" onclick="submitUser()"></td>
				</tr>
			</table>
			</form>
		</div>
    <table id="userDg"></table>  
    
    <script type="text/javascript">
    	$('#userDg').datagrid({    
   			 url:'users/queryAll.action',
   			 fitColumns:true,
   			 toolbar: '#userTb', 
   			 pagination:true,
   			 singleSelect:true,
   			 columns:[[
   			    {field:'id',title:'编号',checkbox:true,width:200},    
        		{field:'name',title:'用户名',width:400}, 
        		{field:'password',title:'密码',width:400},  
        		{field:'departmentId',title:'所属部门',formatter: function(value){return value.name;},width:400},
        		{field:'roleId',title:'所属角色',formatter: function(values){
        			if(typeof(values) == "undefined"||values==null){
						return null;
        			}else{
        				return values.name;
        			}
        			
        		},width:400},
    		]]    
		}); 
		
		//
		function deleteUser(){
			var row = $('#userDg').datagrid('getSelected');
			 if (row){
				$.post('users/deleteUser.action',{'id':row.id,},function(data){
					if(data!=null&&data!=""){
						$.messager.alert("提示", data, "info");  
					}else{
						$('#userDg').datagrid('reload');
						$.messager.alert("提示", "删除成功", "info"); 
						
					}
				}); 
				
			}else{
				 $.messager.alert("提示", "请选中一行记录", "info");  
			} 
		}
		//
		function updateUser(){
			var row = $('#userDg').datagrid('getSelected');
			if(row){
				$('#userDd').dialog({
					title : '角色分配',
					width : 400,
					height : 300,
					closed : false,
					cache : false,
					modal : true, 
					onOpen:function(){
						$("input[name='name']").val(row.name);
						$("#zhuGuan").hide();
						$("#manager").hide();
						$("#dManager").hide();
						$.post('role/queryAll.action',function(data){
							$("select[name='roleId.id']").empty();
							for(var i=0;i<data.length;i++){
								$("select[name='roleId.id']").append("<option value="+data[i].id+" >"+data[i].name+"</option>");
							}
				
						});
					}
				}); 
			}else{
				 $.messager.alert("提示", "请选中一行记录", "info");  
			}
		}
		function submitUser(){
			var name=$("input[name='name']").val();
			var id=$("select[name='roleId.id']").val();
			var parentId=0;
			if(!$("#manager").is(":hidden")){
				parentId=$("select[name='manager']").val();
			}else if(!$("#dManager").is(":hidden")){
				parentId=$("select[name='dManager']").val();
			}else if(!$("#zhuGuan").is(":hidden")){
				parentId=$("select[name='zhuGuan']").val();
			}
	 		$.post('users/updateRole.action',{'name':name,'roleId.id':id,'parentId':parentId},function(data){
	 			$('#userDg').datagrid('reload');
	 			$('#userDd').dialog({
						closed : true
				});
				$.messager.alert("提示", "修改成功", "info");  
	 		});

		}
		//
		function change(){
			var row = $('#userDg').datagrid('getSelected');
			var name= $("select[name='roleId.id']").find("option:selected").text();
		 	if(name=="员工"){
				$("#manager").hide();
				$("#dManager").hide();
				$.post('users/queryUser.action',{'departmentName':row.departmentId.name,'roleName':'主管'},function(data){
					$("select[name='zhuGuan']").empty();
					for(var i=0;i<data.length;i++){
						$("select[name='zhuGuan']").append("<option value="+data[i].id+">"+data[i].name+"</option>");
					}
					$("#zhuGuan").show();
				});
			}else if(name=="部门经理"){
				$("#zhuGuan").hide();
				$("#dManager").hide();			
				$.post('users/queryUser.action',{'departmentName':row.departmentId.name,'roleName':'副总'},function(data){
					$("select[name='manager']").empty();
					for(var i=0;i<data.length;i++){
						$("select[name='manager']").append("<option value="+data[i].id+" >"+data[i].name+"</option>");
					}
					$("#manager").show();
				});
			}else if(name=="主管"){
				$("#zhuGuan").hide();
				$("#manager").hide();		
				$.post('users/queryUser.action',{'departmentName':row.departmentId.name,'roleName':'部门经理'},function(data){
					$("select[name='dManager']").empty();
					for(var i=0;i<data.length;i++){
						$("select[name='dManager']").append("<option value="+data[i].id+" >"+data[i].name+"</option>");
					}
					$("#dManager").show();
				});
			}else{
				$("#dManager").hide();
				$("#zhuGuan").hide();
				$("#manager").hide();		
			}
		} 
    </script>
  </body>
</html>
