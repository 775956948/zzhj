<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>盖章审批</title>
		<link rel="stylesheet" type="text/css" href="../css/basic.css" >
		<link rel="stylesheet" type="text/css" href="../css/style.css" >
	</head>
	<body>
		<div id="sealTb">
			<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addapply_official_Tb()" >创建申请</a>
		</div>
		
		
		<table id="apply_official_Dg"></table> 
		
		<div id="apply_official_tanc"  class="easyui-dialog" closed=true >
			<form action="" method="post" id="apply_official_form">
  	<!-- 		  	<input name="id" id="dis_none" style="display:none !important;"/> -->
				<h2 class="cmn_tit">盖章审批</h2>
				<ul class="cmn_list">
					<li>
						<span>编号</span>
						<input type="text" name="number"  value=""  class="apply_official_val" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/></li>
					<li>
						<span>项目名称</span>
						<input type="text" name="projectName"  value="" class="apply_official_val"/></li>
 					<li>
						<span>章类型</span>
						<input  name="sealId.id" id="apply_offcial_select" class="apply_offcial_select" value="" style="border:0 !important;" />
					
					</li> 
					<li>
						<span>是否骑缝</span>
						<b class="pd10" style="padding:0 5px;">是<input type="radio" name="why" id="" value="是" /></b>
						<b class="pd10" style="padding:0 5px;">否<input type="radio" name="why" id="" value="否" /></b>
					</li> 	
					<li>
						<span>页数</span>
						<input type="text" name="pageNumber"  value="" class="apply_official_val " onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/></li>
					<li>
						<span>份数</span>
						<input type="text" name="copiesNumber"  value="" class="apply_official_val" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/></li>
					<li class="txt_ctr">
						<input type="button" value="提交" onclick="apply_official_Submit()"/>
					</li>
					
				</ul>
  		</form>
			
		</div>
		<script type="text/javascript">
				$('#apply_official_Dg').datagrid({
				url:'requestSeal/queryAll.action',
			    fitColumns:true,
   			    toolbar:'#sealTb', 
   			    pagination:true,
   			    singleSelect:true,
			    fitColumns:true,
			    border:false, 
			    
			   	columns:[[    
			        {field:'id',checkbox:true,}, 
			   		{field:'number',title:'编号',width:50,},       
		        		{field:'projectName',title:'项目名称',width:100,},
 		        		{field:'userId',title:'申请人',width:50,formatter:function(value){return value.name}},
/* 		        		{field:'sealId',title:'章类型',width:50,formatter:function(value){return value.typeName}},  */
		        		{field:'pageNumber',title:'页数',width:50,},
		        		{field:'copiesNumber',title:'份数',width:50,},
		        		{field:'text',title:'收文主题',width:50,},
		        		{field:'approver',title:'审批人',width:50,},
		        		{field:'requestDate',title:'申请日期',width:50,},
		        		{field:'agent',title:'经办人',width:50,},
		        		{field:'overDate',title:'盖章日期',width:50,},
		        		{field:'state',title:'审批状态',width:50,},
		        		{field:'why',title:'是否骑缝',width:50},
	
			    ]],
			})
			
			
			function addapply_official_Tb(){
				$('#apply_official_tanc').dialog({
					title : '盖章审批',
					width : 400,
					height : 400,
					closed : false,
					cache : false,
					modal : true
				});	
				//  seal/queryAll.action
				$('#apply_offcial_select').combobox({
				    url:'seal/queryAll.action',
				    valueField:'id',
				    textField:'typeName'
				});
				
			}
				
				 function check(obj){
					  if(obj.id == 'checkbox1' && obj.checked == true){
					   document.getElementById('checkbox2').checked = false;
					  } 
					  else if(obj.id == 'checkbox2' && obj.checked == true){
					   document.getElementById('checkbox1').checked = false;
					  }
				 }
				 
				 
				 
			function apply_official_Submit(){
  		 		$.ajax({
				   url:"requestSeal/save.action",
				   type:"post",
				   data:$("#apply_official_form").serialize(),	   
	 			   success:function(data){				
						if(data == 1){
							$('#apply_official_tanc').dialog({
								closed : true,
							});
							$('#apply_official_Dg').datagrid('reload');
							alert("提交成功");
							$(".apply_official_val").val(" ");
						}else{
							
							$(".apply_official_val").val(" ");
							alert("提交失败");
						}
					} 
				});
  		 	}
			
			
		</script>
	</body>
</html>
