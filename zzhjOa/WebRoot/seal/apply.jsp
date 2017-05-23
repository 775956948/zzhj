<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title>资质章盖章申请单</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
	<body>
		 <div id="sealTb">
			<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addApply()" >创建申请</a>
			<a  class="easyui-linkbutton" iconCls="icon-Remove" plain="true" onclick="deleteApply()">删除</a>
		</div>
		<div id="apply-tanc"  class="easyui-dialog" closed=true >
  		<form action="" method="post" id="apply-form">
  			   <table  style="font-size: 12px; margin-left: 60px; margin-top:10px;" name="form">
  			   		<tr>
					 <td colspan="2" align="center"><h5>资质章申请</h5></td>
					</tr>
  			   		<tr>
  			   			<td>编号</td>
  			   			<td><input type="text" name="number"  value=""  onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" /></td>
  			   		</tr>
  			   		<tr>
  			   			<td>项目名称</td>
  			   			<td><input type="text" name="projectName"  value="" /></td>
  			   		</tr>
  			   		
  			   		<tr>
  			   			<td>盖章内容</td>
  			   			<td>
  			   				<textarea name="text" rows="" cols="" ></textarea>
  			   			</td>
  			   		</tr>
  			   		<tr>
  			   			<td>盖章事由</td>
  			   			<td>
  			   				<textarea name="why" rows="" cols="" ></textarea>
  			   			</td>
  			   		</tr>
  			   		 
  			   		<tr>
  			   			<td>页数</td>
  			   			<td><input type="text" name="pageNumber"  value="" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/></td>
  			   		</tr>
  			   		<tr>
  			   			<td>份数</td>
  			   			<td><input type="numberbox" name="copiesNumber"  value="" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/></td>
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
		   		{field:'id',title:'',checkbox:true,}, 
		   		{field:'number',title:'编号'},       
	        		{field:'projectName',title:'项目名称',},
	        		{field:'userId',title:'申请人',formatter:function(value){
	        			return value.name;
	        		}},
	        		{field:'requestDate',title:'申请时间',},
	        		{field:'state',title:'状态',},
	        		{field:'approver',title:'审批人',},
	        		{field:'agent',title:'经办人',},
	        		{field:'overDate',title:'盖章时间',},
	        		{field:'text',title:'盖章内容',},  
	        		{field:'why',title:'盖章事由',},
	        		{field:'pageNumber',title:'页数',},   
	        		{field:'copiesNumber',title:'份数',},        		

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
