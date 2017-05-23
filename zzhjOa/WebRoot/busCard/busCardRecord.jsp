<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>公交一卡通</title>
</head>
<body>
	  <div id="busCardTb">
		<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addBusCardRecord()">添加</a>
		<a  class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="deleteBusCardRecord()">刪除</a>
			<a  class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateBusCardRecord()">还卡</a>
	</div>
	
	<div id="busCardDd"  class="easyui-dialog" closed=true >
		<form id="busCardRecordForm">
			<table name="form">
				<tr>
					<td colspan="2" align="center"><h5>公交一卡通</h5></td>
				</tr>
				<tr>
					<td>一卡通卡号</td>
					<td>
						<select name="busCardId.id">
						</select>
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
					<td><input type="datetime-local" name="startDate"/></td>
				</tr>
				<tr name="overDate">
					<td>结束时间</td>
					<td><input type="datetime-local" name="overDate"  /> </td>
				</tr>
				<tr name="startMoney">
					<td>起始金额</td>
					<td><input type="number" name="startMoney"/></td>
				</tr>
				<tr name="overMoney">
					<td>结束金额</td>
					<td><input  type="number" name="overMoney"   /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><button type="button"  onclick="submitBusCardRecord()" >提交</button></td>
				</tr>
			</table>
		</form>
	</div> 
	
	<table id="busCardRecordDg"></table> 
	
	<script type="text/javascript">
		$('#busCardRecordDg').datagrid({				
			url:'busCardRecord/queryAll.action',
		    fitColumns:true,
			pagination:true,
	 		singleSelect:true,
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
			   	{field:'startDate',title:'领取时间',},   
			   	{field:'overDate',title:'归还时间',},   
			   	{field:'startMoney',title:'领取金额',}, 
			   	{field:'overMoney',title:'归还金额',},
		   			
		    ]],
		})

		function addBusCardRecord(){
			$("tr[name='overDate']").hide();
			$("tr[name='startMoney']").hide();
			$("tr[name='overMoney']").hide();
			$("#busCardDd").dialog({
				title:'公交一卡通申请',
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
		function submitBusCardRecord(){
			var i=0;
			$("#busCardRecordForm input").each(function(){
				if($(this).val()==""){
					i=i+1;
				}
				
			})
			if(i>3){
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
							 $.messager.alert("提示", "添加成功", "info");  
						}
					}
				}) 
			}
		}
		function updateBusCardRecord(){
			$("tr[name='overDate']").show();
			$("tr[name='startMoney']").show();
			$("tr[name='overMoney']").show();
			var row =$("#busCardRecordDg").datagrid("getSelected");
			$("#busCardDd").dialog({
				title:'公交一卡通还车信息',
				closed : false,
				onOpen:function(){
					$("input[name='start']").val(row.start);
					$("input[name='over']").val(row.over);
					$("input[name='startDate']").val(row.startDate);
					$("select[name='busCardId.id']").val(row.busCardId.id);
				}
			});	
		}
	</script>
</body>
</html>