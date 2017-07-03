<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>请假休假信息</title>
    
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
  		<div id="restTb">
			<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addRest()">申请请假/休假</a>
			<c:if test="${users.roleId.name=='副总' || users.roleId.name=='总经理' || users.roleId.name=='管理员'}">
				<a  class="easyui-linkbutton" iconCls="icon-Remove" plain="true" onclick="deleteRest()">删除</a>
			</c:if>
		</div>
		<div id="restDd"  class="easyui-dialog" closed=true  style="width: 750px">
  		<form action="" method="post">
  				<h2 style="margin: auto; width:150px; margin-top: 20px;">请假/休假信息表</h2>
				<ul id="addRest" >
					<li>
						<span>请假人</span>
						<input type="text" name="userId" disabled="disabled"  value="${users.name}"/>
					</li>
					<li>
						<span>请假类型</span>
						<select name="restTypeId"></select>
					<li >
						<span>请假天数</span>
						<input type="text" name="restDate" min="0" onchange="if(!/^\d+(\.5)?$/.test(this.value)){$.messager.alert('请输入请假天数','只能输入0.5的倍数！','info');this.value='';}" />
					</li>
					<li>
						<span>请假起始时间</span>
						<input type="text" name="currentDate" id="currentDate" />
					</li>
					<li>
						<span style="float: left;">请假原由</span>
						<textarea name="restText" rows="3" cols="30"  style="width: 348px"></textarea>
					</li>
					<li>
						<input class="button-task" type="button" value="申请" onclick="restSubmit()" />
					</li>
				</ul>
  		</form>
  		</div>
  		
  		 <table id="restDg"></table> 
  		 
  		 
  	<script type="text/javascript">
	        $("#currentDate").datetimebox({
	        required: true,
	        showSeconds: false,
	        editable:false
	        });
   		 	$('#restDg').datagrid({    
   			 url:'rest/queryAll.action',
   			 fitColumns:true,
   			 toolbar: '#restTb', 
   			 pagination:true,
   			 singleSelect:true,
   			 columns:[[
   			    {field:'id',title:'编号',checkbox:true,width:200},    
        		{field:'userId',title:'请假人',width:200,formatter:function(value){return value.name}}, 
        		{field:'restText',title:'请假原由',width:400},  
        		{field:'restTypeId',title:'请假类型',formatter: function(value){return value.name;},width:100},
        		{field:'restDate',title:'请假天数'},
        		{field:'currentDate',title:'请假起始时间'}, 
        		{field:'date',title:'申请时间'},
        		{field:'approver',title:'审批人'},
        		{field:'state',title:'状态'},   
    		]]    
		});  
		////
		function addRest(){
			$("#restDd").dialog({
				title : '请假信息',
				height : 400,
				closed : false,
				cache : false,
				modal : true,
				onOpen:function(){
					$.post('restType/queryAll.action',function(data){
						$("select[name='restTypeId']").empty();
						for(var i=0;i<data.length;i++){
							$("select[name='restTypeId']").append("<option value="+data[i].id+" >"+data[i].name+"</option>")
						}
					});
				}
			});
		};
		///
		function restSubmit(){
			var restDate=$("input[name='restDate']").val();
			var currentDate=$("input[name='currentDate']").val();
			var restTypeId=$("select[name='restTypeId']").val();
			var restText=$("textarea[name='restText']").val();
		 	if(restDate!=""&&currentDate!=""&&restTypeId!=""&&restText!=""){
				$.post('rest/save.action',{'restDate':restDate,'restTypeId.id':restTypeId,'restText':restText,'currentDate':currentDate},function(data){
					if(data!=null&&data>0){
						$('#restDg').datagrid('reload');
						$.messager.alert("提示", "添加成功", "info");
							$('#restDd').dialog({
								closed : true, 
							});
					}
				});
			}else{
				 $.messager.alert("提示", "请填写完整信息", "info");  
			}; 
		};
		///
		function deleteRest(){	
			var row = $("#restDg").datagrid('getSelected');
			if(row){
				$.post('rest/deleteRest.action',{'id':row.id},function(data){
					if(data!=null&&data>0){
						$("#restDg").datagrid('reload');
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
