
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
			<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="DeleteApprove_official_Tb()" >删除</a>
	</div>
		<div id="approve_official_tanc" class="easyui-dialog"  style="width: 650px">
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
						<input type="text" id="type"  readonly="readonly" class="approve_official_val" />
					<li>
					<li style="position: relative;">
						<!--遮罩层-->
						<div style="width: 100%; height: 40px; position: absolute;z-index: 10;"></div>
						<span>是否骑缝</span>
						<span >是<input style="width: 50px;" type="radio" id="radioYes"  /></span>
						<span>否<input style="width: 50px;" type="radio" id="radioNo"  /></span>
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
	 		fitColumns:false,
		    toolbar:'#approve_official_Tb',
	        onDblClickRow:function() {  //双击打开当前行详情函数
	           approve_official_Tb();
	        },
		   	columns:[[
		        {field:'id',title:'id',checkbox:true},
				{field:'number',title:'编号',width:50},
				{field:'projectName',title:'项目名称',width:140},
				{field:'sealId',title:'章类型',width:70,formatter:function(value){ return value.typeName}},				
	       		{field:'userId',title:'申请人',width:70,formatter:function(value){
	    			return value.name;
	    		}},
	    		{field:'requestDate',title:'申请日期',width:100,sortable:true},
	    		{field:'state',title:'审批状态',width:70},
	    		{field:'approver',title:'审批人',width:70},
	    		{field:'agent',title:'经办人',width:70},
	    		{field:'overDate',title:'盖章日期',width:100},
				{field:'text',title:'收文主题',width:200},
	       		{field:'pageNumber',title:'页数',width:70},
				{field:'copiesNumber',title:'份数',width:70},
				{field:'why',title:'是否骑缝',width:70}
			    ]]
			});
	
		spprove_tanc2 = $('#approve_official_tanc').dialog({
			title : '审批',
			height : 400,
			closed : true,
			cache : false,
			modal : true
		});	
		//查看
			
		function approve_official_Tb(){		
			var row = $('#approve_official_Dg').datagrid('getSelected');
			if(row == null){
			   $.messager.alert("提示","请选择一条数据","info");
			}else{
				$('#approve_official_tanc').dialog({
					title : '审批',
					height : 400,
					closed : false,
					cache : false,
					modal : true,
					onOpen:function(){
						var  aa = row.why;
						if(aa=="是"){
							$("#radioYes").prop("checked", true);
							$("#radioNo").prop("checked", false);
						}else{
							$("#radioYes").prop("checked", false);
							$("#radioNo").prop("checked", true);
						}
						$("input[name = requestSealId]").val(row.id);			
						$("input[name = number]").val(row.number);
						$("#type").val(row.sealId.typeName);
						$("textarea[name = projectName]").val(row.projectName);
						$("input[name = pageNumber]").val(row.pageNumber);
						$("input[name = copiesNumber]").val(row.copiesNumber);
						$("textarea[name = text]").val(row.text);
					}
				});		
			}

		}

		 function approve_official_Submit(){	
			 var id=$("input[name='requestSealId']").val();
		 	$.ajax({
				   url:"requestSeal/approver.action",
				   type:"post",
				   data:{"requestSealId":id},	   
				   success:function(data){
					   if(data == 1){
					   		$('#approve_official_tanc').dialog({
								closed : true
							});
					   	$('#approve_official_Dg').datagrid('reload');
					   	$.messager.alert("提示","审批完成","info");
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
					   	$.messager.alert("提示","提交失败","info");
					   }
				   }
			}) 
		}
	    // 公章申请删除
			function DeleteApprove_official_Tb(){
				var row = $("#approve_official_Dg").datagrid('getSelected');
				if(row){
					if(row.state=="待审批"){
						$.messager.confirm('确认','您确认想要删除记录吗？',function(r){
							if (r){
								$.post('',{'id':row.id},function(data){
									if(data!=null&&data>0){
										$.messager.alert("提示", "删除成功！","info");
										$("#approve_official_Dg").datagrid('reload');
									}
								})
							}
						});
					}else{
						$.messager.alert("提示", "当前状态不可删除，仅可删除“待审批”的申请信息。","info");
					}
				}else{
					$.messager.alert("提示", "请选中一行信息","info");
				}
			}
  	</script>
		
	</body>
</html>
