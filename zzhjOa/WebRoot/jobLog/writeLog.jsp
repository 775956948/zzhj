<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>工作日志</title>
    
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
  		<div>
			<form>
				<table>
					<tr>
						<td colspan="2" align="center"><h3>工作日志</h3></td>
					</tr>
					<tr>
						<td>主题:</td>
						<td><input type="text" name="theme" style="width: 300px;"/></td>
					</tr>
					<tr>
						<td>类型</td>
						<td>
							<select id="type">
								<option>工作日报</option>
								<option>工作周报</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>内容:</td>
						<td>
							<iframe src="ueditor.html" frameborder="0" id="editor" style="width:800px; height:400px;"></iframe>
						</td>
					</tr>
				</table>
			</form>
		</div>


				
		<script type="text/javascript">	
			function saveJobLog(txt){
				var theme =$("input[name='theme']").val();
				var type=$("#type").find("option:selected").text();
 				if(theme!=""&&txt!=""){
					$.post('jobLog/saveJobLog.action',{'text':txt,'theme':theme,'type':type},function(data){
						if(data>0){
							$.messager.alert("提示", "提交成功", "info"); 
						}
					});
				}else{
					$.messager.alert("提示", "请填写完整信息", "info"); 
				} 
			} 
		</script>
  </body>
</html>
