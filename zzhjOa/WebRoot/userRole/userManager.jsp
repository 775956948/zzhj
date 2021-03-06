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
			<a  class="easyui-linkbutton" iconCls="icon-Remove" plain="true" onclick="deleteUser()">刪除角色</a>
			<a  class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateUser()">分配角色</a>
			<a class="easyui-linkbutton" iconCls="icon-xd" plain="true" onclick="allotDepartment()">分配部门</a>
        	<a  class="easyui-linkbutton" iconCls="icon-no" plain="true"  onclick="clearUser()">角色消权</a>
		</div>
		<div id="userDd"  class="easyui-dialog" closed=true >
			<form>
			<table id="table" style="font-size: 12px;">
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
	<!--修改框-->
	<div class="easyui-dialog" title="分配部门" id="DepartmentDIG" closed=true>
		<ul>
			<li><input type="text" readonly id="changeUserName"></li>
			<li><select name="" id="DepartmentName1"></select></li>
			<li><input type="button" value="确 定 修 改" onclick="changeDepartmentId()"></li>
		</ul>
	</div>

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
        			
        		},width:400}
    		]]    
		}); 
		
		//
		function deleteUser(){
			var row = $('#userDg').datagrid('getSelected');
			 if (row){
				$.post('users/deleteUser.action',{'id':row.id},function(data){
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
			}else if(name=="主管"||name=="质检"){
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
	// 消除角色
	function clearUser(){
		var row = $("#userDg").datagrid('getSelected');
			if(row){
				$.messager.confirm('确认','您确认想要消除该角色OA使用权限吗？',function(r){
					if (r){
						$.post('users/removeRole.action',{'id':row.id},function(data){
							if(data!=null&&data>0){
								$.messager.alert("提示", "消除角色权限成功！","info");
								$("#userDg").datagrid('reload');
							}
						})
					}
				});
			}else{
				$.messager.alert("提示", "请选中一行信息","info");
			}
	}
	//分配部门
	function allotDepartment() {
		var row = $("#userDg").datagrid('getSelected');
			if (row) {
				$('#DepartmentDIG').dialog({
				closed: false,
				cache: false,
				modal: true,
				onOpen: function () {
				// 初始化部门选择
					$.post('department/queryAll.action', function (data) {
						$("#DepartmentName1").empty();
						for (var i = 0; i < data.length; i++) {
							$("#DepartmentName1").append("<option value=" + data[i].id + ">" + data[i].name + "</option>")
						}
					});
					$("#changeUserName").val(row.name);
				}
				})
			}else{
				$.messager.alert("提示", "请先选中一行信息！", "info");
			}
	}
	// 确定修改部门
	function changeDepartmentId(){
			var row = $("#userDg").datagrid('getSelected');
			$.post('users/updateDepartment.action', {'userId': row.id,'departmentId':$("#DepartmentName1").val()}, function (data) {
				if (data != null && data > 0) {
					$.messager.alert("提示", "修改角色部门成功！请从新分配角色，定义工作流", "info");
					$("#userDg").datagrid('reload');
					$('#DepartmentDIG').dialog({
						closed: true
					})
				}else{
					$.messager.alert("提示", "修改失败，请稍候重试！", "info");
				}
			})
	}
    </script>
  </body>
</html>
