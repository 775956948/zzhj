<!--<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>-->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>审批</title>	
	</head>
	<body>
		<!--审批表格-->
		 <div id="approve_official_Tb">
			<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="approve_official_Tb()" >查看</a>
			<!--  <a  class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteSpprove()">删除</a>-->				
		</div>
		<div id="approve_official_tanc"> 
			<form action="" method="post" id="approve_official_form" class="approve_official_form">
				<input name="requestSealtId" id="dis_none" /> 
				<h2 class="cmn_tit">资质章盖章申请单</h2>
				<ul class="cmn_list">
					<li>
						<span>编号</span>
						<input type="text" name="number"  value="" readonly="readonly" class="approve_official_val" /></li>
					<li>
						<span>项目名称</span>
						<input type="text" name="projectName" readonly="readonly" value="" class="approve_official_val"/></li>
					<li>
						<span>章类型</span>
						<select id="type" disabled="disabled">
						</select>
					<li>
					<li>
						<span>页数</span>
						<input type="text" name="pageNumber" readonly="readonly" value="" class="approve_official_val "/></li>
					<li>
						
						<span>份数</span>
						<input type="text" name="copiesNumber" readonly="readonly" value="" class="approve_official_val" /></li>
					<li>
						<span>收文主题</span>
						<textarea name="text"  rows="" cols="" readonly="readonly" class="approve_official_val"></textarea></li>
					<li>
						<span>是否骑缝</span>
						<textarea name="why" rows="" cols="" readonly="readonly" class="approve_official_val"></textarea></li>
					<li class="txt_ctr">
						<input type="button" value="审批" onclick="approve_official_Submit()"/>
				
					</li>
						
				</ul>
  			   
  			</form>

		</div>
		
		
		
		<table id="approve_official_Dg"></table>
		


		<script type="text/javascript">	
			
			
			
		$('#approve_official_Dg').datagrid({
			 url:'requestSeal/queryOneself.action',
			rownumbers:true,
		    singleSelect:true, 
			nowarp:false,
		    fit:true, 
		    fitColumns:true,
		    border:false,
			pagination:true,
	 		singleSelect:true,
		    toolbar:'#approve_official_Tb', 
		   	columns:[[    
	        {field:'id',title:'id',checkbox:true,}, 
			{field:'number',title:'编号',width:100,},       
			{field:'projectName',title:'项目名称',width:100,},
			{field:'sealId',title:'章类型',width:80,formatter:function(value){return value.typeName}},
			{field:'userId',title:'申请人',width:100,formatter:function(value){
    			return value.name;
    		}},
			{field:'requestDate',title:'申请时间',width:100,},
			{field:'text',title:'收文主题',width:100,},  
			{field:'why',title:'是否骑缝',width:100,},
			{field:'pageNumber',title:'页数',width:100,},   
			{field:'copiesNumber',title:'份数',width:100,},        		
			{field:'approver',title:'审批人',width:100,},
			{field:'agent',title:'经办人',width:100,},   	        		
       		{field:'overDate',title:'盖章时间',width:100,},
       		{field:'state',title:'状态',width:50,},
		    ]],
		})
	
		spprove_tanc = $('#approve_official_tanc').dialog({
			title : '审批',
			width : 400,
			height : 400,
			closed : true,
			cache : false,
			modal : true
		});	
		//查看
		function approve_official_Tb(){		
			//var row = $('#approveDg').datagrid('getChecked');  你这个是选择所以行
			var row = $('#approve_official_Dg').datagrid('getSelected');
			if(row == null){
			   alert("请选择一条数据");
			}else{
				$("input[name = requestSealtId]").val(row.id);
				/* $("input[name = sealId]").val(row.sealId); */
				
				$("#type").append("<option value=''>"+row.sealId.typeName+"</option>"); 
				$("input[name = number]").val(row.number);
				$("input[name = projectName]").val(row.projectName);
				$("input[name = pageNumber]").val(row.pageNumber);
				$("input[name = copiesNumber]").val(row.copiesNumber);
				$("textarea[name = text]").val(row.text);
				$("textarea[name = why]").val(row.why);
				spprove_tanc.dialog('open') // 打开dialog
//				spprove_tanc.dialog('close') // 关闭dialog
			}
			//console.log(row)
			
			
		};
		
		

		 function approve_official_Submit(){	
			$.ajax({
				   url:"requestSeal/approver.action",
				   type:"post",
				   data:$("#approve_official_form").serialize(),				   
				   success:function(data){
					   if(data == 1){
					   		$('#approve_official_tanc').dialog({
								closed : true,
							});
					   	alert("审批完成");
					   	spprove_tanc.dialog('close');
					   	$('#approve_official_Dg').datagrid('reload');
					   	
					   }else{
					   	alert("提交失败");
					   	
					   }
				   }
			})
		}
  	</script>
		
	</body>
</html>
