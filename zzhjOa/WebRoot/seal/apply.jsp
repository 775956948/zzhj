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
<!-- 			<a  class="easyui-linkbutton" iconCls="icon-Remove" plain="true" onclick="deleteApply()">删除</a> -->
	       <a  class="easyui-linkbutton" iconCls="icon-xg" plain="true" onclick="changeApply()">修改申请</a>
		</div>
		<div id="apply-tanc"  class="easyui-dialog" closed=true  style="width:600px">
  		<form action="" method="post" id="apply-form">
  			   <table   name="form">
  			   		<tr>
					 <td colspan="2" align="center"><h4 style="margin-bottom: 10px;">资质章申请</h4></td>
					</tr>
					<tr>
						<input type="hidden" name="id" readonly  class="apply-val" id="changeID"  style="display: none" >
					</tr>
  			   		<tr>
  			   			<td align="center">编号</td>
  			   			<td><input type="text" name="number"  class="apply-val" id="ZZnumber"  onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" /></td>
  			   		</tr>
  			   		<tr>
  			   			<td align="center">项目名称</td>
  			   			<td><input type="text" name="projectName" class="apply-val" id="ZZprojectName" /></td>
  			   		</tr>
  			   		
  			   		<tr>
  			   			<td align="center">盖章内容</td>
  			   			<td>
  			   				<textarea name="text" rows="" cols="" class="apply-val" id="ZZtext" ></textarea>
  			   			</td>
  			   		</tr>
  			   		<tr>
  			   			<td align="center">盖章事由</td>
  			   			<td>
  			   				<textarea name="why" rows="" cols=""  class="apply-val" id="ZZwhy"></textarea>
  			   			</td>
  			   		</tr>
  			   		 
  			   		<tr>
  			   			<td align="center">页数</td>
  			   			<td><input type="text" name="pageNumber" class="apply-val" id="ZZpageNumber" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/></td>
  			   		</tr>
  			   		<tr>
  			   			<td align="center">份数</td>
  			   			<td><input type="numberbox" name="copiesNumber" class="apply-val" id="ZZcopiesNumber"   onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/></td>
  			   		</tr>
					<tr align="center" id="ApplyButton">
						<td colspan="2"><input type="button" value="申请" onclick="applySubmit()"/></td>
					</tr>
					<tr align="center" id="changeApplyButton" >
						<td colspan="2"><input type="button" value="修改" onclick="changeApplySubmit()"/></td>
					</tr>
  			   </table>
  		</form>

  		</div>
  		
  		 <table id="applyDg"></table> 
  		 <script type="text/javascript">

  		 	function applySubmit(){
	         if($("#ZZnumber").val()!=""&&$("#ZZprojectName").val()!=""&&$("#ZZpageNumber").val()!=""&&$("#ZZcopiesNumber").val()!=""&&$("#ZZtext").val()!=""&&$("#ZZwhy").val()!=""){
	              $.ajax({
	                url:"ziZhiSeal/save.action",
                   	type:"post",
	                data:$("#apply-form").serialize(),
	                dataType:"",
	                success:function(data){
                      	if(data == 1){
	                        $('#apply-tanc').dialog({
	                             closed : true
	                               });
	                            $('#applyDg').datagrid('reload');
	                            $.messager.alert("提示","提交成功","info");
                         	$(".apply-val").val("");
	                               }else{
	                        $.messager.alert("提示","提交失败","info");
	                     }
	                  }
              	});
	          }else{
	              $.messager.alert("提示","请完整填写申请！","info")
	                 }
  		 	}
  		 	
  		 	 		 	
  		 	$('#applyDg').datagrid({    
   			 url:'ziZhiSeal/queryAll.action',
   			 fitColumns:true,
   			 toolbar:'#sealTb', 
   			 pagination:true,
   			 singleSelect:true,
   			 columns:[[
		   		{field:'id',title:'',checkbox:true},
		   		{field:'number',title:'编号',width:50},       
				{field:'projectName',title:'项目名称',width:140},
				{field:'userId',title:'申请人',width:70,formatter:function(value){
									return value.name;
				}},
				{field:'requestDate',title:'申请时间',sortable:true,width:100},
				{field:'state',title:'状态',width:50},
				{field:'approver',title:'审批人',width:100},
				{field:'agent',title:'经办人',width:100},
				{field:'overDate',title:'盖章时间',width:100},
				{field:'text',title:'盖章内容',width:200},
				{field:'why',title:'盖章事由',width:200},
				{field:'pageNumber',title:'页数',width:50},
				{field:'copiesNumber',title:'份数',width:50}
    		]]    
		}); 
		//申请框弹出
		function addApply(){
	        $(".apply-val").val("");
			$('#apply-tanc').dialog({
				title : '资质盖章申请单',
				height : 480,
				closed : false,
				cache : false,
				modal : true
			});
			$("#changeID").css({"display":"none"});
			$("#changeID").attr("disabled",true);
			$("#ApplyButton").show();
			$("#changeApplyButton").hide();
		}
	   //删除框弹出
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
	// 修改弹窗
		function changeApply(){
	        var UserName=$("#user li h3").text();
	        console.log(UserName);
			var reg = /[^:]*:([^:]*)/;
			UserName=UserName.replace(reg,"$1");
			var row = $("#applyDg").datagrid('getSelected');
			if(row){
	          if(row.userId.name==UserName){
	   			if(row.state=="待审批"){
					$("#changeID").css({"display":"inline"});
					$("#changeID").attr("disabled", false);
					$("#ApplyButton").hide();
					$("#changeApplyButton").show();
					$('#apply-tanc').dialog({
							title : '资质盖章申请单修改',
							height : 480,
							closed : false,
							cache : false,
							modal : true,
							onOpen: function () {
								$("#changeID").val(row.id);
								$("#ZZnumber").val(row.number);
								$("#ZZprojectName").val(row.projectName);
								$("#ZZtext").val(row.text);
								$("#ZZwhy").val(row.why);
								$("#ZZpageNumber").val(row.pageNumber);
								$("#ZZcopiesNumber").val(row.copiesNumber);
							}
					});
				}else{
					$.message.alert("提示", "当前状态不可修改，仅可修改“待审批”的申请！", "info")
				}
		      }else{
				$.message.alert("提示", "无权操作他人申请！", "info")
	          }
			}else{
				$.messager.alert("提示", "请选中一条本人申请信息", "info");
			}
		}
	// 确定修改
	function changeApplySubmit(){
	if($("#ZZnumber").val()!=""&&$("#ZZprojectName").val()!=""&&$("#ZZpageNumber").val()!=""&&$("#ZZcopiesNumber").val()!=""&&$("#ZZtext").val()!=""&&$("#ZZwhy").val()!=""){
			$.ajax({
			url:"ziZhiSeal/updateZiZhiSeal.action",
			type:"post",
			data:$("#apply-form").serialize(),
				success:function(data){
					if(data == 1){
						$('#apply-tanc').dialog({
						closed : true
					});
						$('#applyDg').datagrid('reload');
						$.messager.alert("提示","修改成功！","info");
						$(".apply-val").val("");
					}else{
						$.messager.alert("提示","修改失败，请稍候重试。","info");
					}
				}
			});
	}else{
			$.messager.alert("提示","请完整修改信息！","info");
	}
	}
  	</script>
	</body>
</html>
