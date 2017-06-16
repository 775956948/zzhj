<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>

    <base href="<%=basePath%>">

    <title>中兆恒基Oa登陆</title>
	<link rel="stylesheet" href="css/basic.css" />
	<link rel="stylesheet" href="css/login.css" />
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript">
		function registered(){
			$("#form").attr("action", "department/queryAll.action");
			$("#form").submit();
		}
		function login(){
			$("#form").attr("action", "users/login.action");
			$("#form").submit();
		}
		
		$(document).keydown(function(event){
    		var  code = event.keyCode;
    		if(code==13){
    			login();
    		}
		});
	</script>
  </head>
 <script type="text/javascript">
        function registered() {
            $("#form").attr("action", "department/queryAll.action");
            $("#form").submit();
        }
        function login() {
            $("#form").attr("action", "users/login.action");
            $("#form").submit();
        }

        $(document).keydown(function (event) {
            var code = event.keyCode;
            if (code == 13) {
                login();
            }
        });
    </script>
</head>
<body>
<div class="login_header">
    <div class="header_container">
        <a href="#" class="logo_btn"><img src="image/logo_02.png"/></a>
        <!--<span>Oa办公系统登陆</span>-->
    </div>
</div>
<div class="login_main">
    <div id="max" class="login_table">
        <p style="font-size: 10px; margin: 7px;color: red;text-align: center;cursor: default">${loginMessage }</p>
        <c:remove var="loginMessage"/>
        <form action="" method="post" id="form">
            <ul id="table">
                <li title="登录个人中心">
                    <h5>登录</h5>
                </li>
                <li  class="td_name"  title="请输入用户名">
                        <input type="text" name="name"  class="login_input login_input-icon1" placeholder="请输入用户名"/>
                </li>
                <li  class="td_password"  title="请输入密码">
                        <input type="password" name="password" class="login_input login_input-icon2"
                               placeholder="请输入密码"/>
                </li>
                <li title="立 即 登 录">
                    <input type="button" value="立 即 登 录" onclick="login()" class="button"/>
                </li>
                <li>
                        <a href="#" class="forget_btn" title="找回密码">忘记密码？</a><a href="javascript:;" class="register_btn"
                                                                          onclick="registered()">没账号？点击注册</a>
                </li>
            </ul>
        </form>
    </div>
</div>
</body>
</html>
