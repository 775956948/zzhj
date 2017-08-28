<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>完善用户信息</title>
</head>
<body>										 
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
			<td><input type="file" name="files"   /><img id="userImage" src="image/${users.imageName }" width="50px;" style="border-radius:25px;"><input id="userInfoimg" type="button" value="更换头像" onclick="userInfoImg()"/></td>
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

	<div class="easyui-dialog" id="CJPD" title="头像修改" closed=true>
		<input type="button" value="裁剪头像"  onclick="imgDIG()">
		<input type="button" value="已裁剪完毕准备上传" style="width: 200px" onclick="UploadTX()" >
	</div>

	<div class="easyui-dialog" id="TXdownload" title="头像下载" closed=true >
		<a href="" download="${users.name}" id="DownloadTX" target="_blank">
			<img src=""  name="" id="imgT"  style="width:180px;border-radius:180px;box-shadow:0 0 12px #7E7E7E;display: block;margin: 0 auto;margin-top:4px ">
		</a>
		<p>请点击该图片下载到本地或者鼠标右键另存，后上传！</p>
	</div>

	<div class="easyui-dialog" id="imgDig" closed=true title="裁剪头像">
		<div class="container">
			<div class="imageBox">
				<div class="thumbBox"></div>
				<div class="spinner" style="display: none">Loading...</div>
			</div>
			<div class="action">
			<!-- <input type="file" id="file" style=" width: 200px">-->
				<div class="new-contentarea tc">
				<a href="javascript:void(0)" class="upload-img">
					<label for="upload-file">上传图像</label>
				</a>
				<input type="file" class="" name="upload-file" id="upload-file" />
			</div>
				<input type="button" id="btnCrop"  class="Btnsty_peyton" value="裁切" onclick="TXdownload()">
				<input type="button" id="btnZoomIn" class="Btnsty_peyton" value="+"  >
				<input type="button" id="btnZoomOut" class="Btnsty_peyton" value="-" >
			</div>
			<div class="cropped"></div>
		</div>
	</div>
	<script type="text/javascript">
	 	$(function(){
	 		$("#userInfo input[type='file']").hide();
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
					$("#userInfo input[type='file']").hide();
					$("#userImage").show();
					$("#userInfoimg").show();
				}else{
					$("#userInfo input[type='file']").show();
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
		


	var optionsT =
		{
			thumbBox: '.thumbBox',
			spinner: '.spinner',
			imgSrc: 'image/avatar.png'
		};
	var cropper = $('.imageBox').cropbox(optionsT);
		$('#upload-file').on('change', function(){
			var reader = new FileReader();
			reader.onload = function(e) {
			optionsT.imgSrc = e.target.result;
			cropper = $('.imageBox').cropbox(optionsT);
		};
		reader.readAsDataURL(this.files[0]);
		this.files = [];
	});
	var imgT;
		$('#btnCrop').on('click', function(){
			imgT = cropper.getDataURL();
			$('.cropped').html('');
			$('.cropped').append('<img src="'+imgT+'" align="absmiddle" style="width:64px;margin-top:4px;border-radius:64px;box-shadow:0px 0px 12px #7E7E7E;" ><p>64px*64px</p>');
			$('.cropped').append('<img src="'+imgT+'" align="absmiddle" style="width:128px;margin-top:4px;border-radius:128px;box-shadow:0px 0px 12px #7E7E7E;"><p>128px*128px</p>');
			$('.cropped').append('<img src="'+imgT+'" align="absmiddle" style="width:180px;margin-top:4px;border-radius:180px;box-shadow:0px 0px 12px #7E7E7E;"><p>180px*180px</p>');
			$("#imgT").attr('src',imgT);
			$("#DownloadTX").attr("href",imgT);

		});
		$('#btnZoomIn').on('click', function(){
			cropper.zoomIn();
		});
		$('#btnZoomOut').on('click', function(){
			cropper.zoomOut();
		});
	// 弹出裁剪框
	function imgDIG(){
		$("#imgDig").dialog({
			closed:false,
			modal:true
		})
	}
	//弹出选项 修改框
	function imgCJ(){
		$("#CJPD").dialog({
			closed:false,
			width:340,
			height:70,
			modal:true
		});
		$("#imgDig").dialog({
			closed:true,
			modal:true
		});
	}
	//弹出头像下载框
	function TXdownload(){
		$("#TXdownload").dialog({
			closed:false,
			modal:true
		});
		$("#CJPD").dialog({
			closed:true,
			modal:true
		});
		$("#imgDig").dialog({
			closed:true,
			modal:true
		})
	}
	function UploadTX(){
		$("#userInfo input[type='file']").click();
		$("#CJPD").dialog({
			closed:true,
			modal:true
		})
	}

	function userInfoImg(){
	 		$("#userInfo input[type='file']").show();
			$("#userImage").hide();
			$("#userInfoimg").show();
			imgCJ();
	 	}

	</script>	
</body>
</html>