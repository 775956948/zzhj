	<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>请假休假信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  		<div id="restTb">
			<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addRest()">申请请假/休假</a>
			<c:if test="${users.roleId.name=='副总' || users.roleId.name=='总经理' || users.roleId.name=='管理员'}">
				<a  class="easyui-linkbutton" iconCls="icon-Remove" plain="true" onclick="deleteRest()">删除</a>
			</c:if>
		</div>
		<div id="restDd"  class="easyui-dialog" closed=true  style="width: 750px">
  		<form action="" method="post" >
  				<h2 style="margin: auto; width:150px; margin-top: 20px;">请 假/休 假 信 息 表</h2>
				<ul id="addRest" style="margin-top:10px;" >
					<li>
						<span>请假人</span>
						<input type="text" name="restUserId" disabled="disabled"  value="${users.name}"/>
					</li>
					<li>
						<span>请假类型</span>
						<select name="restTypeId"></select>
	                </li>
	                <li>
	                    <span>请假起始时间</span>
	                    <input type="text" name="currentDate" id="currentDate" data-options="onChange:onSelectT" class="easyui-datebox" style="width: 250px"/>
	                    <select name="" id="starTimeN" style="width: 70px;height: 40px;margin-left: 20px;margin-top: 1px" onchange="onSelectT()">
	                       <option value="1">上午</option>
	                       <option value="0">下午</option>
	                    </select>
	                </li>
	                <li>
	                    <span>请假结束时间</span>
	                    <input type="text"  id="currentOverDate" data-options="onChange:onSelectT" class="easyui-datebox" style="width: 250px"/>
	                    <select name="" id="overTimeN"  style="width: 70px;height: 40px;margin-left: 20px;margin-top: 1px" onchange="onSelectT()">
                        	<option value="1">上午</option>
	                        <option value="0">下午</option>
                     	</select>
	                </li>
					<li>
						<span>请假天数</span>
						<input type="text" name="restDate"  readonly   />
					</li>
					<li>
						<span style="float: left;">请假原由</span>
						<textarea name="restText" rows="3" cols="30"  style="width: 348px"></textarea>
					</li>
	                <li>
	                   <span style="float: left;">附件</span>
	                   <input type="file" id="QJfile" />
	                </li>
					<li>
						<input class="button-task" type="button" value="申 请" onclick="restSubmit()" />
					</li>
				</ul>
  		</form>
  		</div>
  		
  		 <table id="restDg"></table> 
  		 
  		 
  	<script type="text/javascript">
	       $("#currentDate").datebox({
            	required: true
	       });
	       $("#currentOverDate").datebox({
	           required: true
	       });
	       //初始化信息表格
   		 	$('#restDg').datagrid({    
   			 url:'rest/queryAll.action',
   			 fitColumns:true,
   			 toolbar: '#restTb', 
   			 pagination:true,
   			 singleSelect:true,
   			 columns:[[
   			    {field:'id',title:'编号',checkbox:true,width:200},    
        		{field:'userId',title:'请假人',width:200,formatter:function(value){return value.name}},
	        	{field:'restTypeId',title:'请假类型',formatter: function(value){return value.name;},width:100},
        		{field:'restText',title:'请假原由',width:400},
		        {field:'currentDate',title:'请假起始时间'},
	        	{field:'requestDate',title:'开始阶段'},
		        {field:'overDate',title:'请假结束时间'},
		        {field:'overStage',title:'结束阶段'},
        		{field:'restDate',title:'请假天数'},
        		{field:'approver',title:'审批人'},
        		{field:'state',title:'状态'},
		        {field:'appendix',title:'附件',hidden:true}
    		]]    
		});  
		//申请请假信息弹出框
		function addRest(){
			$("#restDd").dialog({
				title : '请假信息',
				height : 400,
	            top:50,
				closed : false,
				cache : false,
				modal : true,
				onOpen:function(){
					$.post('restType/queryAll.action',function(data){
						$("select[name='restTypeId']").empty();
						for(var i=0;i<data.length;i++){
							$("select[name='restTypeId']").append("<option value="+data[i].id+" >"+data[i].name+"</option>")
						}
					});
				}
			});
		};
	    // 动态计算 请假天数
	    function onSelectT() {
	        var StartTime=$("#starTimeN").val();  //开始时间选择上午or下午
	        var OverTime=$("#overTimeN").val();   //结束时间选择上午or下午
	        var sd = $('#currentDate').datebox('getValue').replace(/-/g, '/'), ed = $('#currentOverDate').datebox('getValue').replace(/-/g, '/');
	          if (sd != '' && ed != '') {
	             if (sd > ed) {
	                $.messager.alert('警告','结束时间要 大于 开始时间！','warning');
	             } else {
	                var totalMS = new Date(ed).getTime() - new Date(sd).getTime();//得到相差的毫秒数
	                var day = Math.ceil(totalMS / 1000 / 24 / 60 / 60);//得到相差天数，不满一天不算一天将Math.ceil改为Math.floor
	                if(StartTime==OverTime){
	                   day=day+0.5
	                }else if( StartTime>OverTime){
	                   day=day+1;
	                }
	             $("input[name=restDate]").val(day); //所用天数 */
	             }
	          }
	    }
		//确认提交请假信息
		function restSubmit(){
            var userName=$("input[name=restUserId]").val();
			var currentDate=$("#currentDate").val();
	        var currentOverDate=$("#currentOverDate").val();
	        var starTime=$("#starTimeN").find("option:selected").text();
	        var overTime=$("#overTimeN").find("option:selected").text();
			var restTypeId=$("select[name=restTypeId]").val();
	        var restDate=$("input[name=restDate]").val();
			var restText=$("textarea[name=restText]").val();
	        var QJfile=$("#QJfile").val();
		 	if(restDate!=""&&currentDate!=""&&restTypeId!=""&&restText!=""&&currentOverDate!=""&&starTime!=""&&overTime!=""){
		        var formdata = new FormData();
		           formdata.append("restTypeId.id", restTypeId);
		           formdata.append("restDate", restDate);
		           formdata.append("requestDate", currentDate);
		           formdata.append("requestStage", starTime);
		           formdata.append("overStage", overTime);
		           formdata.append("overDate", currentOverDate);
		           formdata.append("restText", restText);
		           formdata.append("file", $("#QJfile")[0].files[0]);
	                $.ajax({
	                    url:"rest/save.action",
		                type:"POST",
						data:formdata,
		                contentType: false,
		                processData: false,
		                success:function(data){
	                      if(data>0){
		                    $.messager.alert("提示", "申请成功！", "info");
	                     	$('#restDg').datagrid("reload");
	                     	$("#restDd").dialog({closed:true})
	                     	
		                }else{
		                    $.messager.alert("提示", "申请失败，请稍候重试！", "info");
		                   }
	                    }
	                })
			}else{
				 $.messager.alert("提示", "请填写完整信息", "info");  
			}
		}

		//删除申请
		function deleteRest(){	
			var row = $("#restDg").datagrid('getSelected');
			if(row){
				$.post('rest/deleteRest.action',{'id':row.id},function(data){
					if(data!=null&&data>0){
						$("#restDg").datagrid('reload');
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
