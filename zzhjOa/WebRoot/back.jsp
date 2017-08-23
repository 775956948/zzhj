<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta name="renderer" content="webkit">      <!--优先使用谷歌浏览器内核-->
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"><!--默认使用IE最高版本 渲染页面 激活Chrome Frame-->
    <base href="<%=basePath%>">
    <title>用户密码找回</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="shortcut icon" type="image/x-icon" href="image/oa.ico" media="screen" />
    <link rel="stylesheet" href="css/basic.css">
    <link rel="stylesheet" href="easyui/themes/icon.css">
    <link rel="stylesheet" href="easyui/themes/default/easyui.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <style type="text/css">
        #ZT {
            margin: 30px auto;
            width: 762px;
            height: auto;
            border: 1px solid #bfcfdc;
            overflow: hidden;
            font-size: 18px;
        }
        #ZT h3{
            width: 100%;
            margin: 8px auto;
            text-align: center;
        }
        .QH {
            margin: 30px auto;
            width: 610px;
            height: 160px;
            border-bottom: 2px solid #d5d6d8;
            background: rgba(156, 193, 228, 0.8) url("image/logo_02.png") no-repeat left;
            background-size: 100% 100%;
        }
        #ZT ul li{
            list-style: none;
        }
        #ZT ul{
            width: 80%;
            margin: 30px auto;
        }
        #ZT li{
            height:  0;
            overflow: hidden;
            transition: all 1.5s ease;
        }
        #ZT p{
            display: block;
            width: 100%;
            text-align: center;
        }
        #ZT input[type=text], #ZT input[type=password]{
            display: block;
            margin: 5px auto;
            width: 57%;
            height: 40px;
            line-height: 40px;
            font-size: 18px;
        }
        #ZT input[type=button]{
            float: right;
            margin-right: 20%;
            border: none;
            background-color: #c3c8cd;
            width: 71px;
            height: 27px;
            text-align: center;
            line-height: 27px;
            font-weight: 700;
            margin-top: 10px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="ZT" id="ZT">
        <a href="login.jsp">
            <div class="QH"></div>
        </a>
        <h3>用户密码修改</h3>
        <ul>
            <li id="inputNameLi" style="height: 159px;">
                <p>请输入用户名:</p>
                <input type="text" name="userName" style="text-align: center">
                <input type="button" id="nextStepName" value="下一步">
            </li>
            <li id="inputAnswerLi">
                <p>请回答密保问题:</p>
                <input type="text" name="userQuestion" readonly>
                <input type="text" name="userAnswer">
            </li>
            <li id="inputPasswordLi">
                <p>请输入新密码!</p>
                <input type="password" name="userPassword" style="text-align: center">
                <input type="button" id="completeChange" value="完成修改">
            </li>
            <li style="height: auto">
                <a href="login.jsp" style="float: right;margin: 8px  20%;font-size: 13px">返回登录</a>
            </li>
        </ul>
    </div>
<script type="text/javascript">
    $(function(){
        var LiOne= $("#inputNameLi");
        var LiTwo= $("#inputAnswerLi");
        var LiThree= $("#inputPasswordLi");

        var Name=$("input[name='userName']");
        var nextStepName=$("#nextStepName");

        var Question=$("input[name='userQuestion']");
        var Answer=$("input[name='userAnswer']");

        var NewPassword=$("input[name='userPassword']");
        var completeChange=$("#completeChange");

        nextStepName.click(function(){
            if(Name.val()!=""&&Name.val()!=null){
                $.ajax({
                    url:"users/userExist.action",
                    type:'post',
                    data:{
                        userName:Name.val()
                    },
                    success:function(data){
                        if(data){
                            LiOne.css({"height":"0"});
                            LiTwo.css({"height":"150px"});
                            LiThree.css({"height":"160px"});
                            Question.val(data);
                        }else{
                            $.messager.alert("提示","用户名不存在！","info")
                        }
                    }

                })
            }else{
                $.messager.alert("提示","用户名不能为空！","info")
            }
        });

        completeChange.click(function(){
            if(NewPassword.val()!=""&&NewPassword.val()!=null&&Answer.val()!=""){
                $.ajax({
                    url:"users/updateUser.action",
                    type:'post',
                    data:{
                        name:Name.val(),
                        securityAnswer:Answer.val(),
                        password:NewPassword.val()
                    },
                    success:function(data){
                        if(data>0){
                            $.messager.alert("提示","修改成功，请"+'<a href="login.jsp">返回首页</a>'+"！","info")
                        }else{
                            $.messager.alert("提示","密保答案有误，请核对后重试！","info")
                        }
                    }
                })
            }else{
                $.messager.alert("提示","请完整填写！","info")
            }
        });
    })
</script>
</body>
</html>
