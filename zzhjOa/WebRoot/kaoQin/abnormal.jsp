<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>打卡异常</title>
    
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
  		<div id="abnormalTb">
			<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addAbnormal()">打卡异常申请</a>
			<a  class="easyui-linkbutton" iconCls="icon-Remove" plain="true" onclick="deleteAbnormal()">删除</a>
		</div>
		<div id="abnormalDd"  class="easyui-dialog" closed=true >
  		<form action="" method="post">
  			   <table>
  			   		<tr>
  			   			<td colspan="2"><h2>打卡异常信息表</h2></td>
  			   		</tr>
  			   		<tr>
  			   			<td>申请人</td>
  			   			<td><input type="text" name="userId" disabled="disabled"  value="${users.name}"/></td>
  			   		</tr>
  			   		<tr>
  			   			<td>异常类型</td>
  			   			<td>
  			   				<select name="abnormalType">
  			   					<option>上午</option>
  			   					<option>下午</option>
  			   					<option>全天</option>
  			   				</select>
  			   			</td>
  			   		</tr>
  			   		<tr>
  			   			<td>异常时间</td>
  			   			<td><input type="datetime-local" name="abnormalDate"/></td>
  			   		</tr>
  			   		<tr>
  			   			<td>异常原由</td>
  			   			<td><textarea name="abnormalText" rows="10" cols="30"></textarea></td>
  			   		</tr>
  			   		 <tr align="center">
  			   			<td colspan="2"><input type="button" value="申请" onclick="abnormalSubmit()"/></td>
  			   		</tr>
  			   </table>
  		</form>
  		</div>
  		
  		 <table id="abnormalDg"></table> 
  		 
  		 
  	<script type="text/javascript">
  		 	$('#abnormalDg').datagrid({    
   			 url:'abnormal/queryAll.action',
   			 fitColumns:true,
   			 toolbar: '#abnormalTb', 
   			 pagination:true,
   			 singleSelect:true,
   			 columns:[[
   			    {field:'id',title:'编号',checkbox:true,width:200},    
        		{field:'userId',title:'申请人',width:200,formatter:function(value){return value.name;}}, 
        		{field:'abnormalText',title:'异常原由',width:400},  
        		{field:'abnormalType',title:'异常类型',width:200},
        		{field:'abnormalDate',title:'异常时间'}, 
        		{field:'date',title:'申请时间'},
        		{field:'approver',title:'审批人'},
        		{field:'state',title:'状态'},   
    		]]    
		}); 
		////
		function addAbnormal(){
			$("#abnormalDd").dialog({
				title : '异常信息',
				width : 400,
				height : 400,
				closed : false,
				cache : false,
				modal : true
			});
		};
		///
		function abnormalSubmit(){
			var abnormalDate=$("input[name='abnormalDate']").val();
			var abnormalType= $("select[name='abnormalType']").find("option:selected").text();
			var abnormalText=$("textarea[name='abnormalText']").val();
		 	if(abnormalDate!=""){
				$.post('abnormal/save.action',{'abnormalDate':abnormalDate,'abnormalType':abnormalType,'abnormalText':abnormalText},function(data){
					if(data!=null&&data>0){
						$('#abnormalDg').datagrid('reload');
						$.messager.alert("提示", "添加成功", "info");
							$('#abnormalDd').dialog({
								closed : true, 
							});
					}
				});
			}else{
				 $.messager.alert("提示", "请填写完整信息", "info");  
			}; 
		};
		///
		function deleteAbnormal(){	
			var row = $("#abnormalDg").datagrid('getSelected');
			if(row){
				$.post('abnormal/deleteAbnormal.action',{'id':row.id},function(data){
					if(data!=null&&data>0){
						$("#abnormalDg").datagrid('reload');
						 $.messager.alert("提示", "删除成功", "info"); 
					}
				})
			}else{
				 $.messager.alert("提示", "请选中一行信息", "info");  
			}
		}
  	</script>
 </body>
</html>
