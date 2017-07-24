<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>发布公告</title>
</head>
  <body>
  		<div>
			<form>
				<table>
					<tr>
						<td colspan="2" align="center"><h3>发布公告</h3></td>
					</tr>
					<tr>
						<td>主题:</td>
						<td><input type="text" name="theme" style="width: 300px;margin-left:8px" /></td>
					</tr>
					<tr>
						<td>内容:</td>
						<td>
							<iframe src="writeNotice.html" frameborder="0" id="editor" style="width:800px; height:450px;"></iframe>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<script type="text/javascript">	
			function saveNotice(text){
				 var theme =$("input[name='theme']").val();
 				if(theme!=""&&text!=""){
					$.post('notice/save.action',{'text':text,'theme':theme},function(data){
						if(data>0){
							$.messager.alert("提示", "提交成功", "info"); 
							noticeQuery();
						}
					});
				}else{
					$.messager.alert("提示", "请填写完整信息", "info"); 
				}  
			} 
		</script>
  </body>
</html>