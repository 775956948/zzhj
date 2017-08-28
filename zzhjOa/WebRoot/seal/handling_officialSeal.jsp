<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>公章经办</title>	

	</head>

	<body>
		<!--经办表格-->
		 <div id="hanhling_official_Tb">
			<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="hanhling_official_Tb()" >查看</a>				
		</div>
		<div id="hanhling_official_tanc" style="display: none;" class="easyui-dialog"  style="width: 650px">
			<form action="" method="post" id="approve_official_form" class="approve_official_form">
				<input name="id" id="dis_none" style="opacity:0" />
				<h2 align="center">公章盖章经办单</h2>
				<ul class="cmn_list">
					<li>
						<span>编号</span>
						<input type="text" name="number"  value="" readonly="readonly" class="approve_official_val" />
					</li>
					<li>
						<span>项目名称</span>
						<textarea name="projectName"  rows="" cols="" readonly="readonly" style="vertical-align: top;"></textarea>
					</li>	
					<li>
						<span>收文主题</span>
						<textarea name="text"  rows="" cols="" readonly="readonly" style="vertical-align: top;" ></textarea>
					</li>
					<li>
						<span>章类型</span>
						<select id="type" name="sealId" class="approve_official_val">
							<option value=""></option>
						</select>
					<li style="position: relative;">
						<!--遮罩层-->
						<div style="width: 100%; height: 40px; position: absolute;z-index: 10;"></div>
						<span>是否骑缝</span>
						<span>是<input style="width: 50px;" type="radio" name="why"  value="是" id="bRadioYes"/></span>
						<span>否<input style="width: 50px;" type="radio" name="why"  value="否" id="bRadioNo"/></span>
					<li>
					<li>
						<span>页数</span>
						<input type="text" name="pageNumber" readonly="readonly" value="" />
					</li>
					<li>
						
						<span>份数</span>
						<input type="text" name="copiesNumber" readonly="readonly" value=""  />
					</li>
					
					<li class="txt_ctr" >
						<input type="button" value="经办" onclick="hanhling_official_Submit()"/>
					</li>
				</ul>
  			</form>
		</div>
		
		
		
		<table id="hanhling_official_Dg"></table>
		

		<script type="text/javascript">	
		
		$('#hanhling_official_Dg').datagrid({
			 url:'requestSeal/approverRequestSeal.action',
			pagination:true,
	 		singleSelect:true,
	 		fitColumns:false,
		    toolbar:'#hanhling_official_Tb',
	        onDblClickRow:function() {  //双击打开当前行详情函数
	          hanhling_official_Tb();
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
		handling_official_tanc = $('#hanhling_official_tanc').dialog({
				title : '经办',
				height : 400,
				closed : true,
				cache : false,
				modal : true
			});	
			
		//查看
		function hanhling_official_Tb(){
			var row = $('#hanhling_official_Dg').datagrid('getSelected');
			if(row == null){
			   $.messager.alert("提示","请先选择一条数据","info");
			}else{
				$('#hanhling_official_tanc').dialog({
					title : '经办',
					height : 460,
					closed : false,
					cache : false,
					modal : true,
					onOpen:function(){
						var  aa = row.why;
						if(aa=="是"){
							$("#bRadioYes").prop("checked", true);
							$("#bRadioNo").prop("checked", false)
						}else{
							$("#bRadioYes").prop("checked", false);
							$("#bRadioNo").prop("checked", true)
						}
						$("input[name = id]").val(row.id);				
						$("#type option").val(row.sealId.id).text(row.sealId.typeName);
						$("input[name = sealId]").val(row.sealId); 
						$("input[name = number]").val(row.number);
						$("textarea[name = projectName]").val(row.projectName);
						$("input[name = pageNumber]").val(row.pageNumber);
						$("input[name = copiesNumber]").val(row.copiesNumber);
						$("textarea[name = text]").val(row.text);
					}
				});	
				
			}
		}

		 function hanhling_official_Submit(){	
			 var id=$("#dis_none").val();
			$.ajax({
				   url:"requestSeal/handLing.action",
				   type:"post",
				   data:{'id':id},				   
				   success:function(data){
					   if(data == 1){
						 	$('#hanhling_official_Dg').datagrid('reload');
					   		$('#hanhling_official_tanc').dialog({
								closed : true
							});
					   	$.messager.alert("提示","提交成功","info");
					   	spprove_tanc.dialog('close');	
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
  	</script>
		
	</body>
</html>
