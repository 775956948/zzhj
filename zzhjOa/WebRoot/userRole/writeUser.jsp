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
	 		$("input[type='file']").hide();
			$("#userIamge").hide();
			$("#userInfoimg").hide();
			var id =$("#updateUserInfo").val();
			$.post("users/queryUserInfoOne.action",{'id':id},function(data){
				$("input[name='name']").val(data.name);
				$("input[name='password']").val(data.password);
				$("input[name='file']").val(data.imageName);
				$("input[name='phone']").val(data.phone);
	            $("#joinTime").datebox('setValue',data.inductionDate);
	            $("#becomeTime").datebox('setValue',data.positiveDate);
	            $("#birthTime").datebox('setValue',data.birthday);
				if(data.sex!=null){
					if(data.sex=="男"){
						$("#male").attr("checked","checked")
					}else{
						$("#female").attr("checked","checked")
					}
				}
				if(data.imageName!=""&&data.imageName!=null){
					$("input[type='file']").hide();
					$("#userImage").show();
					$("#userInfoimg").show();
				}else{
					$("input[type='file']").show();
					$("#userImage").hide();
					$("#userInfoimg").hide();
				}
			})
       	$('#joinTime').datebox({ required:true,editable:false});
	    $('#becomeTime').datebox({ required:true,editable:false});
	    $('#birthTime').datebox({ required:true,editable:false});

		}) 
		
		function submitInfo(){
	 		var number=0;
	 		$("#userInfo input").each(function(){
	 			var val =$(this).val();
	 			if(val==""||val==undefined||val==null){
	 				number=number+1;
	 			}
	 		})
	 		if(number>1){
	 			$.messager.alert("提示", "信息填寫不完整", "info");
	 		}else{
	 			$.messager.confirm('确认','修改后需重新登陆',function(r){
	 			    if (r){    
	 			    	$("#userInfoForm").submit();
	 			    }    
	 			});  	
	 		}
	 	}
	 	function userInfoImg(){
	 		$("input[type='file']").show();
			$("#userImage").hide();
			$("#userInfoimg").hide(); 
	 	}
	</script>	
	
												 
	<form action="users/updateUserInfo.action" method="post" enctype="multipart/form-data" id="userInfoForm">
		
	<input type="hidden" value="${users.id }" name="id" id="updateUserInfo"/>
	<table id="userInfo">
		<tr>
			<td>用户名</td>
			<td><input type="text" name="name"  disabled="disabled"/></td>
			<td>密码</td>
			<td><input type="text" name="password"/></td>
		</tr>
		<tr>
			<td>头像</td>
			<td><input type="file" name="files" /><img id="userImage" src="image/${users.imageName }" width="50px;" style="border-radius:25px;"><input id="userInfoimg" type="button" value="更换头像" onclick="userInfoImg()"/></td>
			<td>手机号</td>
			<td><input type="number" name="phone" onkeyup="if(isNaN($(this).val())){$(this).val('')}" /></td>
		</tr>
		<tr>
			<td>入职时间</td>
			<td><input type="text" name="inductionDate" class="easyui-datebox" id="joinTime" /></td>
			<td>转正时间</td>
			<td><input type="text" name="positiveDate"  class="easyui-datebox"  id="becomeTime" /></td>
		</tr>
		<tr>
			<td>出生日期</td>
			<td><input type="text" name="birthday" class="easyui-datebox" id="birthTime" /></td>
			<td>性别</td>
			<td>男 <input id="male" type="radio" name="sex" value="男" style="width: 20px;"/>女 <input id="female" type="radio" name="sex" value="女" style="width: 20px;"/></td>
		</tr>
		<tr>
			<td colspan="4" >	<button type="button" onclick="submitInfo();">提交</button></td>
		</tr>
	</table> 
	</form>
	
</body>
</html>