<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>公交一卡通</title>
</head>
<body>
	  <div id="busCardTb">
		<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addBusCardRecord()">添加</a>
		<c:if test="${users.roleId.name=='行政'|| users.roleId.name=='管理员'}">
			<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addBusCard()">添加公交卡</a>
	 		<a  class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="deleteBusCard()">刪除</a>
 		</c:if>
		<a  class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateBusCardRecord('${users.name}')">还卡</a>
	</div>
	
		<div id="card"  class="easyui-dialog" closed=true >
		<form action="" method="post">
			<table>
				<tr>
					<td colspan="2" align="center"><h5>新增一卡通</h5></td>
				</tr>
				<tr>
					<td>卡号：</td>
					<td><input type="text" name="cardNumber" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button" value="提 交" onclick="AddCard()"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="busCardDd"  class="easyui-dialog" closed=true >
		<form id="busCardRecordForm">
			<input type="text" name="id" style="visibility:hidden" />
			<table name="form">
				<tr>
					<td colspan="2" align="center"><h5>公交一卡通</h5></td>
				</tr>
				<tr>
					<td>一卡通卡号</td>
					<td>
						<select name="busCardId.id"></select>
					</td> 
				</tr>
				<tr>
					<td>起始路线</td>
					<td><input type="text" name="start"/></td>
				</tr>
				<tr>
					<td>结束路线</td>
					<td>
						<input type="text" name="over">
					</td>
				</tr>
				<tr>
					<td>起始时间</td>
					<td><input type="text" name="startDate" id="startDate"/></td>
				</tr>
				<tr name="overDate">
					<td>结束时间</td>
					<td><input type="text" name="overDate"  id="overDate" /> </td>
				</tr>
				<tr name="startMoney">
					<td>起始金额</td>
					<td><input type="number" name="startMoney"    onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"/></td>
				</tr>
				<tr name="overMoney">
					<td>结束金额</td>
					<td><input  type="number" name="overMoney"     onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"/></td>
				</tr>
				<tr name="saveCard">
					<td colspan="2" align="center" ><button type="button"  onclick="submitBusCardRecord()" >提交</button></td>
				</tr>
				<tr name="updateCard">
					<td colspan="2" align="center"><button type="button"  onclick="updateBusCardRecordSubmit()" >还卡</button></td>
				</tr>
			</table>
		</form>
	</div> 
	
	<table id="busCardRecordDg"></table> 
	
	<script type="text/javascript">

	$("#startDate").datetimebox({
	required: true,
	showSeconds: false,
	editable:false
	});

	$("#overDate").datetimebox({
	required: true,
	showSeconds: false,
	editable:false
	});
		$('#busCardRecordDg').datagrid({				
			url:'busCardRecord/queryAll.action',
		    fitColumns:true,
			pagination:true,
	 		singleSelect:true,
		    fit:true, 
	 		toolbar:'#busCardTb',
		   	columns:[[    
			   	{field:'id',title:'编号',checkbox:true},
  			   	{field:'busCardId',title:'一卡通卡号',formatter:function(value){
        			if(typeof(value) == "undefined"||value==null){
						return null;
        			}else{
        				return value.cardNumber;
        			}
  			   		
  			   	}},    
 			   	{field:'userId',title:'用户',formatter:function(value){
	 			   	if(typeof(value) == "undefined"||value==null){
						return null;
	    			}else{
	    				return value.name;
	    			}
				   		
 			   	},},    
			   	{field:'start',title:'启始站点',},
			   	{field:'over',title:'结束站点',},
			   	{field:'startDate',title:'领取时间',sortable:true},   
			   	{field:'overDate',title:'归还时间',},
			   	{field:'startMoney',title:'领取金额',},
			   	{field:'overMoney',title:'归还金额',},
		   			
		    ]],
		})

		function addBusCardRecord(){
			$("tr[name='saveCard']").show();
			$("tr[name='updateCard']").hide();
			$("tr[name='overDate']").hide();
			$("tr[name='startMoney']").hide();
			$("tr[name='overMoney']").hide();
			$("#busCardDd").dialog({
				title:'公交一卡通申请',
				width : 400,
				closed : false,
				onOpen:function(){
					$.post('busCard/queryAll.action',function(data){
						$("select[name='busCardId.id']").empty();
						for (var i = 0; i < data.length; i++) {
							$("select[name='busCardId.id']").append("<option value='"+data[i].id+"'>"+data[i].cardNumber+"</option>")
						}
						
					})
				}
			})
		}
		
		
		//
		function submitBusCardRecord(){
			var i=0;
	       if(  $("input[name = start]").val()==''||$("input[name = startDate]").val()==''||$("input[name = over]").val()==''){
	           i=i+1;
	        }
			if(i>0){
				 $.messager.alert("提示", "请填写完整信息", "info");  
			}else{
				var start =$("input[name='start']").val();
				var over =$("input[name='over']").val();
				var startDate=$("input[name='startDate']").val();
				var busCardId =$("select[name='busCardId.id']").val();
 				$.ajax({
					url:'busCardRecord/save.action',
					type:'post',
					data:{'start':start,'over':over,'startDate':startDate,'busCardId.id':busCardId},	
					success:function(data){
						if(data>0){
							$("#busCardDd").dialog({
								closed:true
							})
							$('#busCardRecordDg').datagrid('reload');
							 $.messager.alert("提示", "添加成功！", "info");
						}
					}
				}) 
			}
		}
		
		///
		function updateBusCardRecordSubmit(){
			var i=0;
	        if($("input[name = start]").val()==''||$("input[name = startDate]").val()==''||$("input[name = overDate]").val()==''||$("input[name = over]").val()==''||$("input[name = startMoney]").val()==''||$("input[name = overMoney]").val()==''){
	        i=i+1;
	        }
			if(i>0){
				 $.messager.alert("提示", "请填写完整信息", "info");  
			}else{
				var overDate = $("input[name='overDate']").val();
				var startMoney = $("input[name='startMoney']").val();
				var overMoney = $("input[name='overMoney']").val();
				var id=$("input[name='id']").val();
				var busCardId =$("select[name='busCardId.id']").val();
			 	$.post('busCardRecord/update.action',{'id':id,'overDate':overDate,'startMoney':startMoney,'overMoney':overMoney,'busCardId.id':busCardId},function(data){
					if(data>0){
						$("#busCardDd").dialog({
							closed:true
						})
						$('#busCardRecordDg').datagrid('reload');
						 $.messager.alert("提示", "还卡成功", "info"); 
					}
				}) 
				
			}
		}
		
		//
		function updateBusCardRecord(userName){
			$("tr[name='saveCard']").hide();
			$("tr[name='updateCard']").show();
			$("tr[name='overDate']").show();
			$("tr[name='startMoney']").show();
			$("tr[name='overMoney']").show();
			var row =$("#busCardRecordDg").datagrid("getSelected");
			if(row){
				if(row.userId.name==userName){
					$("#busCardDd").dialog({
						title:'公交一卡通还车信息',
						width : 400,
						closed : false,
						onOpen:function(){
							$("input[name='id']").val(row.id);
							$("select[name='busCardId.id']").empty();
							$("select[name='busCardId.id']").append("<option value='"+row.busCardId.id+"'>"+row.busCardId.cardNumber+"</option>");
							$("input[name='start']").val(row.start);
							$("input[name='over']").val(row.over);
		                    $("select[name='busCardId.id']").val(row.busCardId.id);
							<%--$("input[name='startDate']").val(row.startDate);--%>
		                    $("#startDate").datetimebox({
		                    value: row.startDate,
		                    required: true,
		                    showSeconds: false
		                    });
		                    $("#overDate").datetimebox({
		                    value: row.overDate,
		                    required: true,
		                    showSeconds: false
		                    });
						}
					});	
					$("select[name='busCardId.id'] option:first").prop("selected", 'selected'); 
				}else{
					$.messager.alert("提示", "无权操作他人信息", "info");  
				}
			}else{
				 $.messager.alert("提示", "请选中一行信息", "info");  
			}
		}
		//删除一条信息
		function deleteBusCard(){
			var row = $("#busCardRecordDg").datagrid("getSelected");
			if(row){
				$.post('busCardRecord/delete.action',{'id':row.id},function(data){
					if(data>0){
						 $.messager.alert("提示", "删除成功", "info");  
						 $('#busCardRecordDg').datagrid('reload');
					}
				})
			}else{
				 $.messager.alert("提示", "请选中一行信息", "info");  
			}
		}
		//打开添加窗口
		function addBusCard(){
			$("#card").dialog({
				title:'添加一卡通',
				width : 230,
				closed:false
			})
		}
		//添加一卡通
		function AddCard(){
		 	var cardNumber = $("input[name='cardNumber']").val();
	        if(cardNumber!=""&&cardNumber>0){
	           $.post('busCard/save.action',{'cardNumber':cardNumber},function(data){
	            if(data>0){
	               $.messager.alert("提示", "添加成功！", "info");
	                 $("#card").dialog({
	                  closed:true
	                 })
	            }
	        })
	         }else{
         	$.messager.alert("提示", "请填写卡号！", "info");
	      }
		}
	</script>
</body>
</html>