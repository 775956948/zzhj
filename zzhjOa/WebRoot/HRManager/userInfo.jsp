<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工通讯录</title>
</head>
<body>
	<div id="userInfoTb">
		&nbsp;&nbsp;
		部门：<select id="departmentType"></select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		姓名：<input id="search" class="easyui-searchbox" style="width:300px mar;" ></input> 
		&nbsp;&nbsp;
		<input type="button" value="搜索" onclick="searchUserInfoDo()">
	</div>
	<table id="userInfoDg"></table>  
	<script type="text/javascript">
		$.post('department/departmentInfo.action',function(data){
			$("#departmentType").empty();
			$("#departmentType").append("<option value=0 >全部</option>")
			for (var i = 0; i < data.length; i++) {
				$("#departmentType").append("<option value="+data[i].id+">"+data[i].name+"</option>")
			}
		});
		$('#userInfoDg').datagrid({
			url :'users/searchUserInfo.action',
			fitColumns : true,
			toolbar : '#userInfoTb',
			pagination : true,
			singleSelect : true,
			columns : [ [ 
			              {field : 'id',title : '编号',hidden: true}, 
			              {field : 'name',title : '用户名',width:400}, 
			              {field : 'departmentId',title : '所属部门',width:400,formatter : function(value) {return value.name;}}, 
			              {field : 'roleId',title : '所属角色',width:400,formatter : function(values) {
								if (typeof (values) == "undefined" || values == null) {
									return null;
								} else {
									return values.name;
								}
						  }},
						  {field:'phone',title:'联系电话',width:400} 
					] ] 
		});
		function searchUserInfoDo(){
			var departmentId=$("#departmentType").val();
			var userName =$("#search").val();
			$('#userInfoDg').datagrid({
				url :'users/searchUserInfo.action',
				fitColumns : true,
				toolbar : '#userInfoTb',
				pagination : true,
				singleSelect : true,
	 			queryParams: {
						'departmentId.id':departmentId,
						'name':userName
				},
				columns : [ [ 
				              {field : 'id',title : '编号',hidden: true}, 
				              {field : 'name',title : '用户名',width:400}, 
				              {field : 'departmentId',title : '所属部门',width:400,formatter : function(value) {return value.name;}}, 
				              {field : 'roleId',title : '所属角色',width:400,formatter : function(values) {
									if (typeof (values) == "undefined" || values == null) {
										return null;
									} else {
										return values.name;
									}
							  }},
							  {field:'phone',title:'联系电话',width:400} 
						] ] 
			});
			
		}
	</script>
</body>
</html>