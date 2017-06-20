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
	<style type="text/css">
		
	</style>
  </head>
  
  <body>
  		<div id="abnormalTb">
			<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addAbnormal()">打卡异常申请</a>
			<a  class="easyui-linkbutton" iconCls="icon-Remove" plain="true" onclick="deleteAbnormal()">删除</a>
		</div>
		<div id="abnormalDd"  class="easyui-dialog" closed=true >
  		<form action="" method="post">
  				<h2 style="margin: auto; width:130px; margin-top: 20px;">打卡异常信息表</h2>
				<ul class='marginLeft'>
					<li>
						<span>申请人&nbsp;</span>
						<input type="text" name="userId" disabled="disabled"  value="${users.name}"/>
					</li>
					<li>
						<span>异常类型</span>
						<select name="abnormalType">
 			   					<option>上午</option>
 			   					<option>下午</option>
 			   					<option>全天</option>
 			   				</select>
					<li>
						<span>异常时间</span>
						<input type="text" name="abnormalDate" id="adnormalDate" />
					</li>
					<li >
						<span style="float: left;">异常原由</span>
						<textarea rows="2" cols="30" name="abnormalText"></textarea>
					</li>
					<li >
						<input style="margin-left: 65px;"  type="button" value="申请" onclick="abnormalSubmit()"/>
					</li>
				
				</ul>
  		
  			  
  		</form>
  		</div>
  		
  		 <table id="abnormalDg"></table> 
  		 
  		 
  	<script type="text/javascript">
	        $("#adnormalDate").datetimebox({
	        required: true,
	        showSeconds: false
	        });
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
        		{field:'date',title:'申请时间',sortable:true},
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
			var abnormalType=$("textarea[name='abnormalText']").val();
		 	if(abnormalDate!=""&& abnormalType!=""&& abnormalType!=""){
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
