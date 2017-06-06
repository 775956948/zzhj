<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>完善用户信息</title>
</head>
<body>
	<script type="text/javascript">
	 	$(function(){
			var id =$("input[name='id']").val()
			$.post("users/queryUserInfoOne.action",{'id':id},function(data){
				$("input[name='name']").val(data.name);
				$("input[name='password']").val(data.password);
				$("input[name='file']").val(data.imageName);
				$("input[name='phone']").val(data.phone);
				$("input[name='inductionDate']").val(data.inductionDate);
				$("input[name='positiveDate']").val(data.positiveDate);
				$("input[name='birthday']").val(data.birthday);
				if(data.sex!=null){
					if(data.sex=="男"){
						$("#male").attr("checked","checked")
					}else{
						$("#female").attr("checked","checked")
					}
				}
			})
		}) 
	</script>
	<form action="users/updateUserInfo.action" method="post" enctype="multipart/form-data">
	<input name="id" value="${users.id }" type="hidden" />
	<table id="userInfo">
		<tr>
			<td>用户名</td>
			<td><input type="text" name="name"  disabled="disabled"/></td>
			<td>密码</td>
			<td><input type="text" name="password"/></td>
		</tr>
		<tr>
			<td>头像</td>
			<td><input type="file" name="file" style="border: none;"/></td>
			<td>手机号</td>
			<td><input type="number" name="phone" /></td>
		</tr>
		<tr>
			<td>入职时间</td>
			<td><input type="date" name="inductionDate"/></td>
			<td>转正时间</td>
			<td><input type="date" name="positiveDate"></td>
		</tr>
		<tr>
			<td>出生日期</td>
			<td><input type="date" name="birthday"></td>
			<td>性别</td>
			<td>男 <input id="male" type="radio" name="sex" value="男" style="width: 20px;"/>女 <input id="female" type="radio" name="sex" value="女" style="width: 20px;"/></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><input type="submit" value="提交"/></td>
		</tr>
	</table>
	</form>
</body>
</html>