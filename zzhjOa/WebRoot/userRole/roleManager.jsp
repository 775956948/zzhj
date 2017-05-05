<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色权限管理</title>
    
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
    	<div id="roleTb">
    		<a  class="easyui-linkbutton" iconCls="icon-Add" plain="true" onclick="addRole()">添加</a>
			<a  class="easyui-linkbutton" iconCls="icon-Remove" plain="true" onclick="deleteRole()">刪除</a>
			<a  class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateRole()">分配权限</a>
		</div>
		<div id="roleDd"  class="easyui-dialog" closed=true >
			<ul id="roleTree"></ul>
			<input type="button" value="分配" onclick="roleChecked()">
		</div>
		<div id="addRole"  class="easyui-dialog" closed=true >
			请输入角色名称:<input name="name" type="text" /><br/>
			<input type="button" value="添加" onclick="saveRole()">
		</div>
    <table id="roleDg"></table>  
    
    <script type="text/javascript">
    	$('#roleDg').datagrid({    
   			 url:'role/queryAll.action',
   			 fitColumns:true,
   			 toolbar: '#roleTb', 
   			 pagination:true,
   			 singleSelect:true,
   			 columns:[[
   			    {field:'null',title:'编号',checkbox:true,width:200}, 
   			    {field:'id',title:'编号',width:200},      
        		{field:'name',title:'角色',width:400}, 
    		]]    
		}); 
		
		//
		function deleteRole(){
			var row = $('#roleDg').datagrid('getSelected');
			 if (row){
				$.post('role/deleteRole.action',{'id':row.id,},function(data){
					if(data>0){
						$('#roleDg').datagrid('reload');
						$.messager.alert("提示", "删除成功", "info"); 
					}else{
						$.messager.alert("提示", "请先删除拥有该角色的用户", "info");  
					}
				}); 
				
			}else{
				 $.messager.alert("提示", "请选中一行记录", "info");  
			} 
		}
		//
		function updateRole(){
			var row = $('#roleDg').datagrid('getSelected');
			if(row){
				$('#roleDd').dialog({
					title : '角色分配',
					width : 600,
					height : 400,
					closed : false,
					cache : false,
					modal : true, 
					onOpen:function(){
						var row = $('#roleDg').datagrid('getSelected');
						$.post('functionRole/queryAll.action',{'roleId':row.id},function(data){
							$("#roleTree").tree({
								url:'function/getNode.action',
								dnd:false,
			  			 		animate:true,
			   					lines:true,
			   					checkbox:true,
			   					cascadeCheck:false,
								loadFilter:function(nodes){
									for(var i = 0; i < nodes.length;i++){
		  								nodes[i].attributes = {'url':nodes[i].url};
		  								for(var j=0;j<data.length;j++){
		  									if(nodes[i].id==data[j].functionId.id){
		  										$(nodes[i]).attr('checked',true);
		  									}
		  								}
		  							} 
		  								return nodes;
								},
								onExpand:function(nodes){
									for(var i = 0; i < nodes.children.length;i++){
		  							 for(var j=0;j<data.length;j++){
		  									if(nodes.children[i].id==data[j].functionId.id){
		  										$(nodes.children[i]).attr('checked',true);
		  									}
		  								}
		  							} 
								}
							});
							
						});
					}
				}); 
			
				
			}else{
				 $.messager.alert("提示", "请选中一行记录", "info"); 
			}
		}
		//
		function roleChecked(){
			var check =$("#roleTree").tree('getChecked');
			var node =$("#roleTree").tree('getChecked','indeterminate');
			var str ='';
			for(var i=0;i<check.length;i++){
				if(str!=''){
					str+=',';
				}
				str+=check[i].id;
			}
			for(var i=0;i<node.length;i++){
				if(str!=''){
					str+=',';
				}
				str+=node[i].id;
			}
 			 var row = $('#roleDg').datagrid('getSelected');
			$.post('functionRole/updateFunctionRole.action',{'str':str,'roleId':row.id},function(data){
				if(data>0){
					$.messager.alert("信息","修改成功","info");
						$('#roleDd').dialog({
							closed : true,
						});
				}		
			});		

		}
		function addRole(){
			$('#addRole').dialog({
					title : '添加角色',
					closed : false,
					width:300,
					height:300,
					}
			);		
		}
		function saveRole(){
			var name=$("input[name='name']").val();
			if(name!=''){
				$.post('role/saveRole.action',{'name':name},function(data){
					if(data>0){
						$('#roleDg').datagrid('reload');
						$.messager.alert("信息","添加成功","info");
						$('#addRole').dialog({closed : ture});
					}
				});
			}else{
				$.messager.alert("信息","请填写完整信息","info");
			}
		}
    </script>
  </body>
</html>
