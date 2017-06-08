
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>公章审批</title>

	</head>
	<body>
		<!--审批表格-->
		 <div id="approve_official_Tb">
			<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="approve_official_Tb()" >查看</a>			
		</div>
		<div id="approve_official_tanc"> 
			<form action="" method="post" id="approve_official_form" class="approve_official_form">
				<input name="requestSealId" id="dis_none" style="opacity:0;" value=""/> 
				<h2 align="center">公章盖章审批单</h2>
				<ul class="cmn_list">
					<li>
						<span>编号</span>
						<input type="text" name="number"  value="" readonly="readonly" class="approve_official_val" />
					</li>
					<li>
						<span style="vertical-align: top;" >项目名称</span>
						<textarea name="projectName" rows="" cols="" readonly="readonly" class="approve_official_val"></textarea>
					</li>
					<li>
						<span>章类型</span>
						<select id="type" name="sealId" class="approve_official_val">
						</select>
					<li>
					<li style="position: relative;">
						<!--遮罩层-->
						<div style="width: 100%; height: 40px; position: absolute;z-index: 10;">
							
						</div>
						<span>是否骑缝</span>
						
						<b >是<input style="width: 50px;" type="radio" name="why" id="" value="是"/></b>
						<b >否<input style="width: 50px;" type="radio" name="why" id="" value="否"/></b>
					<li>
					<li>
						<span>页数</span>
						<input type="text" name="pageNumber" readonly="readonly" value="" class="approve_official_val "/>
					</li>
					<li>					
						<span>份数</span>
						<input type="text" name="copiesNumber" readonly="readonly" value="" class="approve_official_val" />
					</li>
					<li>
						<span style="vertical-align: top;" >收文主题</span>
						<textarea name="text"  rows="" cols="" readonly="readonly" class="approve_official_val"></textarea>
					</li>
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
		    singleSelect:true, 
			pagination:true,
	 		singleSelect:true,
	 		fitColumns:false,
		    toolbar:'#approve_official_Tb', 
		   	columns:[[    
		  	
		        {field:'id',title:'id',checkbox:true,}, 
				{field:'number',title:'编号',width:50,},   
				{field:'projectName',title:'项目名称',width:140,},
				{field:'sealId',title:'章类型',width:70,formatter:function(value){ return value.typeName}},				
	       		{field:'userId',title:'申请人',width:70,formatter:function(value){
	    			return value.name;
	    		}},
	    		{field:'requestDate',title:'申请日期',width:100,sortable:true},
	    		{field:'state',title:'审批状态',width:70,},
	    		{field:'approver',title:'审批人',width:70,},
	    		{field:'agent',title:'经办人',width:70,},
	    		{field:'overDate',title:'盖章日期',width:100,},
				{field:'text',title:'收文主题',width:200,},  
	       		{field:'pageNumber',title:'页数',width:70,},   
				{field:'copiesNumber',title:'份数',width:70},
				{field:'why',title:'是否骑缝',width:70,},
				
	       		
				
	       		
			    ]],
			})
	
		spprove_tanc2 = $('#approve_official_tanc').dialog({
			title : '审批',
			width : 400,
			height : 400,
			closed : true,
			cache : false,
			modal : true
		});	
		//查看
			
		function approve_official_Tb(){		
			var row = $('#approve_official_Dg').datagrid('getSelected');
			if(row == null){
			   alert("请选择一条数据");
			}else{		
				
				var  aa = row.why;
				
				if(aa == "是"){
					$(".cmn_list li input[type = radio]").eq(0).click()
				}else if(aa == "否"){
					$(".cmn_list li input[type = radio]").eq(1).click()
				}
				$("input[name = requestSealId]").val(row.id);			
				$("input[name = number]").val(row.number);	
				$("#type option").val(row.sealId).text(row.sealId);
				$("#type").empty();
				$("#type").append("<option value='"+row.sealId.id+"'>"+row.sealId.typeName+"</option>"); 			
				$("input[name = number]").val(row.number);
				$("textarea[name = projectName]").val(row.projectName);
				$("input[name = pageNumber]").val(row.pageNumber);
				$("input[name = copiesNumber]").val(row.copiesNumber);
				$("textarea[name = text]").val(row.text);
				spprove_tanc2.dialog('open')
				
			}
			
		};
		
		

		 function approve_official_Submit(){	
			 var id=$("input[name='requestSealId']").val();
		 	$.ajax({
				   url:"requestSeal/approver.action",
				   type:"post",
				   data:{"requestSealId":id},	   
				   success:function(data){
				   	
					   if(data == 1){
					   		$('#approve_official_tanc').dialog({
								closed : true,
							});
					   	$('#approve_official_Dg').datagrid('reload');
					   	alert("审批完成");
					   	$("#listMes li").each(function(){
					   		 var target=$(this).attr("id");
					   		 if(target==id){
					   		 	 $(this).remove(); 
					   		 	var number =$("#listMes").children('li').length;
					   		 	if(number==0){
					   		 	 $("#message").hide();  
					   		 	}
					   		 }
					   	})
					   }else{
					   	alert("提交失败");
					   	
					   }
				   }
			}) 
		}
  	</script>
		
	</body>
</html>
