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
		<title>公章提交</title>
	</head>
	<body>
		<div id="requestSealTb">
			<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addapply_official_Tb()" >创建申请</a>
		</div>
		<table id="apply_official_Dg"></table>
		<div id="apply_official_tanc"  class="easyui-dialog" closed=true  style="width: 650px">
			<form action="" method="post" id="apply_official_form">
  	<!-- 		  	<input name="id" id="dis_none" style="display:none !important;"/> -->
				<h2 align="center">公章盖章提交单</h2>
				<ul class="cmn_list">
					<li>
						<span>编号</span>
						<input type="text" name="number" id="GZnumber"  onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/></li>
					<li>
						<span style="vertical-align: top;"> 项目名称</span>
						<textarea name="projectName" rows="" cols="" id="GZprojectName" ></textarea>
					</li>
					<li>
						<span style="vertical-align: top;">收文主题</span>
						<textarea name="text" rows="" cols="" id="GZtext" ></textarea>
					</li>
 					<li>
						<span>章类型</span>
						<select  name="sealId.id" id="apply_offcial_select" class="apply_offcial_select" ></select>
					</li> 
					<li>
						<span>是否骑缝</span>
						<span >是<input style="width: 50px;" type="radio" name="why" id="" value="是" /></span>
						<span>否<input style="width: 50px;" type="radio" name="why" id="" value="否" /></span>
					</li> 	
					<li>
						<span>页数</span>
						<input type="text" name="pageNumber" id="GZpageNumber"  onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/></li>
					<li>
						<span>份数</span>
						<input type="text" name="copiesNumber" id="GZcopiesNumber"  onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/></li>
					<li>
						<input  type="button" value="提交" onclick="apply_official_Submit()"/>
					</li>
					
				</ul>
  		</form>
			
		</div>
		<script type="text/javascript">
			
			$('#apply_official_Dg').datagrid({				
				url:'requestSeal/queryAll.action',
			    fitColumns:true,
				pagination:true,
		 		singleSelect:true,
		 		toolbar:'#requestSealTb',
			   	columns:[[    
			        {field:'id',checkbox:true},
			   		{field:'number',title:'编号',width:50},
			   		{field:'userId',title:'申请人',width:70,formatter:function(value){return value.name}},
		        	{field:'projectName',title:'项目名称',width:140},
		        	{field:'requestDate',title:'申请日期',width:100,sortable:true},	
		        	{field:'state',title:'审批状态',width:70},
		        	{field:'approver',title:'审批人',width:70},
		        	{field:'agent',title:'经办人',width:70},
		        	{field:'overDate',title:'盖章日期',width:100},
		        	{field:'text',title:'收文主题',width:200},
		        	{field:'why',title:'是否骑缝',width:70},	        		
		        	{field:'pageNumber',title:'页数',width:70},
		        	{field:'copiesNumber',title:'份数',width:70}
			    ]]
			});
			function addapply_official_Tb(){
				$('#apply_official_tanc').dialog({
					title : '公章审批提交单',
					height : 400,
					closed : false,
					cache : false,
					modal : true
				});
				$("#apply_offcial_select").empty();
				$.post('seal/queryAll.action',function(data){
					for (var i = 0; i < data.length; i++) {
						$("#apply_offcial_select").append("<option value='"+data[i].id+"'>"+data[i].typeName+"</option>")
					}
				})
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
	        if($("#GZnumber").val()!=""&&$("#GZprojectName").val()!=""&&$("#GZpageNumber").val()!=""&&$("#GZcopiesNumber").val()!=""&&$("#GZtext").val()!=""){
		         $.ajax({
		             url:"requestSeal/save.action",
		             type:"post",
		             data:$("#apply_official_form").serialize(),
	                	success:function(data){
		                    if(data == 1){
	                           	$('#apply_official_tanc').dialog({
	                                   	closed : true
		                    });
	                    	$('#apply_official_Dg').datagrid('reload');
		                    $.messager.alert("提示","提交成功","info");
		                    $(".apply_official_val").val(" ");
		                               }else{
		                   $(".apply_official_val").val(" ");
		                   $.messager.alert("提示","提交失败","info");
		                         }
		                }
		            });
		}else{
		            $.messager.alert("提示","请完整填写！","info");
		    }

		}
		</script>
	</body>
</html>
