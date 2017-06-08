<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>资质章审批</title>
	</head>
	<body>
		<!--审批表格-->
		 <div id="spproveTb">
			<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addSpproveTb()" >查看</a>
			<!--  <a  class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteSpprove()">删除</a>-->				
		</div>
		<div id="spprove-tanc"> 
 			<form action="" method="post" id="approve-form" class="approve-form">
				<input name="sealId" id="dis_none" style="opacity:0;"/>
				<h2 align="center">资质章审批</h2>
				<ul class="cmn_list">
					<li><span>编号</span><input type="text" name="id2"  value="" readonly="readonly" class="apply-val" /></li>
					<li><span>项目名称</span><input type="text" name="projectName2" readonly="readonly" value="" class="apply-val"/></li>
					<li><span>页数</span><input type="text" name="pageNumber2" readonly="readonly" value="" class="apply-val "/></li>
					<li><span>份数</span><input type="text" name="copiesNumber2" readonly="readonly" value="" class="apply-val" /></li>
					<li><span>盖章内容</span><textarea name="text2"  rows="" cols="" readonly="readonly" class="apply-val"></textarea></li>
					<li><span>盖章事由</span><textarea name="why2" rows="" cols="" readonly="readonly" class="apply-val"></textarea></li>
					<li class="txt_ctr">
					<input type="button" value="审批" onclick="applySubmit()"/>
				
					</li>
				</ul>
				
  			   
  			</form>

		</div>
		
		
		
		<table id="approveDg"></table>
		


		<script type="text/javascript">	
		$('#approveDg').datagrid({
			url:'ziZhiSeal/queryOneself.action',
		    fitColumns:true,
			pagination:true,
	 		singleSelect:true,
		    toolbar:'#spproveTb', 
		   	columns:[[    
	        {field:'id',title:'id',checkbox:true,}, 
			{field:'number',title:'编号',width:50,},       
			{field:'projectName',title:'项目名称',width:140,},	
			{field:'userId',title:'申请人',width:70,formatter:function(value){
    			return value.name;
    		}},
    		{field:'requestDate',title:'申请时间',width:140,sortable:true},
    		{field:'state',title:'状态',width:70,},
    		{field:'approver',title:'审批人',width:70,},
    		{field:'agent',title:'经办人',width:70,}, 
    		{field:'overDate',title:'盖章时间',width:140,},
    		{field:'text',title:'盖章内容',width:140,},  
			{field:'why',title:'盖章事由',width:140,},		
			{field:'pageNumber',title:'页数',width:70,},   
			{field:'copiesNumber',title:'份数',width:70,},  
		
			 	        		
       		
       		
		    ]],
		})
	
		spprove_tanc = $('#spprove-tanc').dialog({
			title : '审批',
			width : 400,
			height : 400,
			closed : true,
			cache : false,
			modal : true
		});	
		
		
		//查看
		function addSpproveTb(){		
			var ziZhiSealRow = $('#approveDg').datagrid('getSelected');
			if(ziZhiSealRow == null){
			   alert("请选择一条数据");
			}else{
				console.log(ziZhiSealRow.projectName);
				$("input[name = sealId]").val(ziZhiSealRow.id);
				$("input[name = id2]").val(ziZhiSealRow.number);
				$("input[name = projectName2]").val(ziZhiSealRow.projectName);
				$("input[name = pageNumber2]").val(ziZhiSealRow.pageNumber);
				$("input[name = copiesNumber2]").val(ziZhiSealRow.copiesNumber);
				$("textarea[name = text2]").val(ziZhiSealRow.text);
				$("textarea[name = why2]").val(ziZhiSealRow.why);
				spprove_tanc.dialog('open') // 打开dialog
			}
			
			
		};
		
		//
		function deleteSpprove(){	
			var row = $("#approveDg").datagrid('getSelected');
			if(row){
				$.post('ziZhiSeal/delete.action',{'id':row.id},function(data){
					if(data!=null&&data>0){						
						 $.messager.alert("提示", "删除成功", "info"); 
						 $("#approveDg").datagrid('reload');
					}
				})
			}else{
				 $.messager.alert("提示", "请选中一行信息", "info");  
			}
		
		}
		

  		 function applySubmit(){	 		
  			 var id=$("#dis_none").val();
			$.ajax({
				   url:"ziZhiSeal/approver.action",
				   type:"post",
				   data:$("#approve-form").serialize(),	
				   dataType:"",			   
				   success:function(data){
					   if(data == 1){
					   		$('#approve-tanc').dialog({
								closed : true,
							});
					   	alert("审批完成");
					   	spprove_tanc.dialog('close');
					   	$('#approveDg').datagrid('reload');
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
