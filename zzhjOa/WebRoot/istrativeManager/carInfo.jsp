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
    
    <title>用车信息</title>
    
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
  		<div style="width: 100%; height: 300px; position: relative; background-color: white; overflow: hidden;">
	   <iframe src="http://cha.weiche.me/limit.php?channel=sm&city_name=北京" style="width: 1150px; height: 1000px; position: absolute; top:-440px; left: 50%;  margin-left: -575px;"  frameborder="0"   scrolling="no" >
	   </iframe>
	   </div>
  	<div id="carInfoTb">
		<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addCarInfo()">添加用车信息</a>
			<c:if test="${users.roleId.name=='行政' || users.roleId.name=='管理员'}">
				<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addCar()">添加车辆</a>
				 <a  class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="deleteCarInfo()">刪除</a> 
			</c:if>
		<a  class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateCarInfo('${users.name}')">还车</a>
	</div>
	
	<div id="carInfoDd"  class="easyui-dialog" closed=true  style="width: 600px">
		<form>
			<table name="form">
				<tr>
					<td colspan="2" align="center"><h5>用车信息</h5></td>
				</tr>
				<tr>
					<td>申请人</td>
					<td><input type="text" name="requestName" /></td>
				</tr>
				<tr>
					<td>所属部门</td>
					<td><input type="text" name="departmentName" /></td>
				</tr>
				<tr>
					<td>司机</td>
					<td><input type="text" name="driver"/></td>
				</tr>
				<tr>
					<td>车牌号</td>
					<td>
						<select name="carId.carNo">
							<option> 请选择</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>用途</td>
					<td><textarea name="requestText" rows="10" cols="30"></textarea></td>
				</tr>
				<tr>
					<td>用车日期</td>
					<td><input type="text" name="startDate"  id="CarstartDate"/> </td>
				</tr>
				<tr>
					<td>用车里程数</td>
					<td><input type="number" name="startNumber"  min="1"   onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"/></td>
				</tr>
	            <tr name='overDate'>
					<td>还车日期</td>
					<td><input  type="text" name="overDate"   id="overReturnDate" /></td>
				</tr>
	            <tr name='overNumber'>
					<td>还车里程数</td>
					<td><input type="number" name="overNumber" min="1"   onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
	                    <input type="button" onclick="checkSubmit()" value="提交" ></td>
				</tr>
			</table>
		</form>
	</div> 
	
	<div id="carDd"  class="easyui-dialog" closed=true >
		<form action="" method="post">
			<table>
				<tr>
					<td colspan="2" align="center"><h5>新增车辆</h5></td>
				</tr>
				<tr>
					<td>车辆名称：</td>
					<td><input type="text" name="carName" /></td>
				</tr>
				<tr>
					<td>车牌号：</td>
					<td><input type="text" id="carNo"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button" value="提 交" onclick="submitAddCar()"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<table id="carInfoDg"></table> 
	
	<script type="text/javascript">
		$("#overReturnDate").datetimebox({
			required: true,
			showSeconds: false,
			editable:false
		});
	    $("#CarstartDate").datetimebox({
		    required: true,
		    showSeconds: false,
		    editable:false
	    });
		$(function(){
			$('#carInfoDg').datagrid({    
   			 url:'carInfo/getCarInfo.action',
   			 fitColumns:true,
   			 toolbar: '#carInfoTb', 
   			 pagination:true,
   			 singleSelect:true,
   			 columns:[[
   			    {field:'id',title:'编号',checkbox:true,width:200},    
        		{field:'requestName',title:'申请人'}, 
        		{field:'departmentName',title:'所属部门'}, 
        		{field:'driver',title:'司机'},     
        		{field:'carId',title:'车牌号',formatter: function(value){
					return value.carNo;
				}
        		},    
        		{field:'requestText',title:'用途',width:300},
        		{field:'startDate',title:'用车日期',sortable:true},
        		{field:'startNumber',title:'用车公里数'}, 
        		{field:'overDate',title:'还车日期'}, 
        		{field:'overNumber',title:'还车公里数'}
    		]]    
		}); 
		
		});
		///
		function addCarInfo(){
			$('#carInfoDd').dialog({
					title : '添加用车信息',
					height : 500,
					closed : false,
					cache : false,
					modal : true,
					top:50
				});
	        $("input[type=text]").val('');
			$("textarea").val('');
			$("tr[name='overDate']").hide();
			$("tr[name='overNumber']").hide();
			$.post('car/getAll.action',function(data){
				$("select[name='carId.carNo']").empty();
				for(var i=0;i<data.length;i++){
					$("select[name='carId.carNo']").append("<option value="+data[i].carNo+" >"+data[i].carName+"--"+data[i].carNo+"</option>");
				}
				
			});
		}
		///
		function deleteCarInfo(){
			var row = $('#carInfoDg').datagrid('getSelected');
			 if (row){
				$.post('carInfo/delCarInfo.action',{'id':row.id,'carId.carNo':row.carId.carNo},function(data){
					$('#carInfoDg').datagrid('reload');
					$.messager.alert("提示","删除成功","info");
				}); 
			}else{
				 $.messager.alert("提示", "请选中一行记录", "info");  
			} 
		}
		function checkSubmit(){
			var overNumber=$("input[name='overNumber']").val();
			var carNo =$("select[name='carId.carNo']").val();
			var requestName=$("input[name='requestName']").val();
			var departmentName=$("input[name='departmentName']").val();
			var requestText=$("textarea[name='requestText']").val();
			var startDate=$("input[name='startDate']").val();
			var driver =$("input[name='driver']").val();
			var startNumber=$("input[name='startNumber']").val();
			var row = $('#carInfoDg').datagrid('getSelected');
			if(overNumber!=''&&overNumber!=null){
				var overDate=$("input[name='overDate']").val();
				if(carNo==''||requestName==''||requestText==''||departmentName==''||startDate==''||startNumber==''||overDate==''||overNumber==''||driver==''){
				 	$.messager.alert("提示", "请填写完整信息", "info");  
				}else{
				 	$.post('carInfo/updateCarInfo.action',{'id':row.id,'carId.carNo':carNo,'requestName':requestName,'requestText':requestText,'startDate':startDate,'departmentName':departmentName,'startNumber':startNumber,'overDate':overDate,'overNumber':overNumber,'driver':driver},function(data){
				 		$('#carInfoDg').datagrid('reload');
				 		$.messager.alert("提示","还车成功","info");
						$('#carInfoDd').dialog({
							closed : true
						}); 
				 	});
						
					
				} 
				
			}else{
				if(carNo==''||requestName==''||requestText==''||departmentName==''||startDate==''||startNumber==''||driver==''){
					 $.messager.alert("提示", "请填写完整信息", "info");  
				}else{
					 $.post('carInfo/saveCarInfo.action',{'carId.carNo':carNo,'requestName':requestName,'requestText':requestText,'startDate':startDate,'departmentName':departmentName,'startNumber':startNumber,'driver':driver},function(data){
						 if(data>0){
							 $('#carInfoDg').datagrid('reload');
			                  $.messager.alert("提示","添加成功","info");
								$('#carInfoDd').dialog({
									closed : true
								}); 
						 }
					 });	
				} 
			}
			
		}
		//
		function updateCarInfo(user){
	 		var row = $('#carInfoDg').datagrid('getSelected');
			if (row){
				if(row.requestName==user){
					$.post('carInfo/carInfoOne.action',{'id':row.id},function(data){
							$('#carInfoDd').dialog({
							title : '完善用车信息',
							width : 450,
							height : 380,
							closed : false,
							cache : false,
							modal : true, 
							onOpen:function(){
								$("select[name='carId.carNo']").empty();
								$("select[name='carId.carNo']").append("<option value="+data.carId.carNo+" >"+data.carId.carName+"--"+data.carId.carNo+"</option>");
								$("tr[name='overDate']").show();
								$("tr[name='overNumber']").show();
								$("input[name='requestName']").val(data.requestName);
								$("input[name='departmentName']").val(data.departmentName);
								$("textarea[name='requestText']").val(data.requestText);
		                        $("#CarstartDate").datetimebox({
		                        value: data.startDate,
		                        required: true,
		                        showSeconds: false
		                        });
								$("input[name='startNumber']").val(data.startNumber);
		                        $("#overReturnDate").datetimebox({
		                        value: data.overDate,
		                        required: true,
		                        showSeconds: false
		                        });
								$("input[name='driver']").val(data.driver);
								$("input[name='overNumber']").val(data.overNumber); 
							}
						}); 
					});
				}else{
					$.messager.alert("提示", "无权力操作他人信息", "info");  
				}	
			}else{
				 $.messager.alert("提示", "请选中一行记录", "info");  
			}
		}
		function addCar(){
			$('#carDd').dialog({
				title : '添加车辆信息',
				height : 300,
				closed : false,
				cache : false,
				modal : true, 
			}); 
		}
		function submitAddCar(){
			var carNo=$("#carNo").val();
			var carName=$("#carDd input[name='carName']").val();
 			if(carNo!=''&& carName!=''){	
				
				$.post('car/addCar.action',{'carNo':carNo,'carName':carName},function(data){
					if(data>0){
						$.messager.alert("提示", "添加成功", "info"); 
						$('#carDd').dialog({
							closed : true
						}); 
					}
				})
			}else{
				$.messager.alert("提示", "信息不完整", "info");
			} 
		}
	</script>
  </body>

</html>
