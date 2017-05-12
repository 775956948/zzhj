<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>资质章盖章申请单</title>
	</head>
	<style type="text/css">
		td>div{
			width: auto !important;
			padding:0 10px !important;
		}
	</style>
	<body>
		 <div id="sealTb">
			<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addApply()" >创建申请</a>
			<a  class="easyui-linkbutton" iconCls="icon-Remove" plain="true" onclick="deleteApply()">删除</a>
		</div>
		<div id="apply-tanc"  class="easyui-dialog" closed=true >
  		<form action="" method="post" id="apply-form">
  			   <table>
  			   		<tr>
  			   			<td colspan="2"><h2>资质章盖章申请单</h2></td>
  			   		</tr>
  			   		<tr>
  			   			<td>编号</td>
  			   			<td><input type="text" name="number"  value="" class="apply-val" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/></td>
  			   		</tr>
  			   		<tr>
  			   			<td>项目名称</td>
  			   			<td><input type="text" name="projectName"  value="" class="apply-val"/></td>
  			   		</tr>
  			   		
  			   		<tr>
  			   			<td>盖章内容</td>
  			   			<td>
  			   				<textarea name="text" rows="" cols="" class="apply-val"></textarea>
  			   			</td>
  			   		</tr>
  			   		<tr>
  			   			<td>盖章事由</td>
  			   			<td>
  			   				<textarea name="why" rows="" cols="" class="apply-val"></textarea>
  			   			</td>
  			   		</tr>
  			   		 
  			   		<tr>
  			   			<td>页数</td>
  			   			<td><input type="text" name="pageNumber"  value="" class="apply-val " onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/></td>
  			   		</tr>
  			   		<tr>
  			   			<td>份数</td>
  			   			<td><input type="numberbox" name="copiesNumber"  value="" class="apply-val" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/></td>
  			   		</tr>
  			   		<tr align="center">
  			   			<td colspan="2"><input type="button" value="申请" onclick="applySubmit()"/></td>
  			   		</tr>
  			   
  			   </table>
  		</form>
  		</div>
  		
  		 <table id="applyDg"></table> 
  		 <script type="text/javascript">

  		 	function applySubmit(){
  		 		$.ajax({
				   url:"ziZhiSeal/save.action",
				   type:"post",
				   data:$("#apply-form").serialize(),	
				   dataType:"",			   
				   success:function(data){				
						if(data == 1){
							$('#apply-tanc').dialog({
								closed : true,
							});
							$('#applyDg').datagrid('reload');
							alert("提交成功");
							$(".apply-val").val(" ");
						}else{
							
							$(".apply-val").val(" ");
							alert("提交失败");
						
						
						}
					}
				});
  		 	}
  		 	
  		 	 		 	
  		 	$('#applyDg').datagrid({    
   			 url:'ziZhiSeal/queryAll.action',
   			 fitColumns:true,
   			 toolbar:'#sealTb', 
   			 pagination:true,
   			 singleSelect:true,
   			 columns:[[
		   		{field:'id',title:'编号',checkbox:true,}, 
		   		{field:'number',title:'编号'},       
	        		{field:'projectName',title:'项目名称',},
	        		{field:'userName',title:'申请人',formmater:function(value){
	        			return value.name;
	        		}},
	        		{field:'requestDate',title:'申请时间',},
	        		{field:'text',title:'盖章内容',},  
	        		{field:'why',title:'盖章事由',},
	        		{field:'pageNumber',title:'页数',},   
	        		{field:'copiesNumber',title:'份数',},        		
	        		{field:'approver',title:'审批人',},
	        		{field:'agent',title:'经办人',},   	        		
	        		{field:'overDate',title:'结束时间',},

	        		{field:'state',title:'状态',},

	        		{field:'overDate',title:'状态',},
	        		

    		]]    
		}); 
		////
		function addApply(){
			$('#apply-tanc').dialog({
				title : '资质盖章申请单',
				width : 400,
				height : 400,
				closed : false,
				cache : false,
				modal : true
			});
		};
		function deleteApply(){	
			var row = $("#applyDg").datagrid('getSelected');
			if(row){
				$.post('abnormal/applyDg.action',{'id':row.id},function(data){
					if(data!=null&&data>0){
						$("#applyDg").datagrid('reload');
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
