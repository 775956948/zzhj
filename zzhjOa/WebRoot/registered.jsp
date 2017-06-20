<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>中兆恒基Oa注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link rel="stylesheet" href="easyui/themes/icon.css">
    <link rel="stylesheet" href="easyui/themes/default/easyui.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <style type="text/css">
       	::-webkit-inner-spin-button{
	       visibility: hidden;
     	}
        * {
            margin: 0;
            padding: 0;
        }
        input {
            border: 0;
            list-style: none;
            outline: none;
        }

        a {
            text-decoration: none;
        }

        #ZT {
            margin: 30px auto;
            width: 762px;
            height: 740px;
            border: 1px solid #bfcfdc;
        }

        .QH {
            margin: 30px auto;
            width: 610px;
            height: 160px;
            border-bottom: 2px solid #d5d6d8;
            background: rgba(156, 193, 228, 0.8) url("image/logo_02.png") no-repeat left;
            background-size: 100% 100%;
        }

        #Zc {
            margin: 0 auto;
            width: 604px;
            height: 25px;
            line-height: 25px;
            font-family: "微软雅黑";
            font-size: 18px;
            text-indent: 6px;
            border-left: 3px solid #59AfE4;
            margin-top: 50px;
            color: #616161;
        }

        #Xhx {
            width: 605px;
            height: 1px;
            margin: 5px auto;
            background-color: #dddddd;
        }

        .SX {
            width: 605px;
            margin: 11px auto;
            height: 36px;

        }

        .wz {
            width: 125px;
            height: 36px;
            text-align: right;
            display: inline-block;
            float: left;
            line-height: 36px;
            font-size: 14px;
            color: #333;
        }

        .Sr {
            float: left;
            width: 302px;
            height: 35px;
            background: url("image/ipt.png");
            background-position: -0px 0px;
            display: inline-block;
            line-height: 32px;
        }

        .Sr2 {
            margin-left: 5px;
            width: 280px;
            height: 100%;
            background-color: rgba(0, 0, 0, 0);
            line-height: 100%;
        }

        .cc {
            background-image: none;
        }

        select {
            border-color: #0c8ed9
        }
        .textbox{
        background-color: transparent;
        border: none;
        }
        .validatebox-text{
        background-color: transparent;
        }
        .textbox-icon{
        height:33px !important;
        margin-top: 1px;
        }

    </style>

</head>

<body>
<form action="users/save.action" method="post" id="form">
    <div id="ZT">
        <a href="login.jsp">
            <div class="QH"></div>
        </a>
        <div id="Zc">注册用户</div>
        <div id="Xhx"></div>
        <div class="nc SX">
            <div class="wz"><span style="margin-right: 10px">昵称</span></div>
            <div class="Sr">
                <input type="text"  class="Sr2" name="name">
            </div>
        </div>
        <div class="nc SX">
            <div class="wz"><span style="margin-right: 10px">密码</span></div>
            <div class="Sr">
                <input type="password"  name="password" class="Sr2">
            </div>
        </div>
        <div class="nc SX">
            <div class="wz"><span style="margin-right: 10px">性别</span></div>
            <div class="Sr cc">
                &nbsp 男 &nbsp<input type="radio" name="sex" checked="checked" value="男"/> &nbsp; 女 &nbsp<input
                    type="radio" name="sex" value="女"/>
            </div>
        </div>
        <div class="nc SX">
            <div class="wz"><span style="margin-right: 10px">生日</span></div>
            <div class="Sr">
                <input id="birthdayChange"  class="easyui-datebox Sr2" type="text" style="width: 100%;height: 100%;background-color: transparent" name="birthday" />
            </div>
        </div>
        <div class="nc SX">
            <div class="wz"><span style="margin-right: 10px">部门</span></div>
            <div class="Sr">
                <select name="departmentId.id"
                        style="width: 100%;height: 100%;border: none;background-color: transparent">
                    <c:forEach items="${department }" var="dpm">
                        <option value="${dpm.id }">${dpm.name }</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="nc SX">
            <div class="wz"><span style="margin-right: 10px">手机号码</span></div>
            <div class="Sr ">
                <input type="text" name="phone" class="Sr2">
            </div>
        </div>
        <div class="nc SX" style="margin-top: 38px">
            <div class="wz"></div>
            <div class="Sr cc">
                <input style="background-color: #69b946;color: white;height: 52px; width: 306px;text-align: center;font-family: 微软雅黑;font-size: 22px;border: none;"  value="立即注册" onclick="submits()"/>
	<sub><a href="login.jsp">返回首页</a></sub>
            </div>
        </div>
        <div class="nc SX" style="margin-top: 38px">
            <div class="wz"></div>
            <div class="Sr cc">
                ${message }
            </div>
        </div>
    </div>
</form>
<script type="text/javascript">
    $('#birthdayChange').datebox({ required:true});
    function submits() {
        var cout = 0;
    if($("input[name = name]").val()==''||$("input[name = password]").val()==""||$("input[name = phone]").val()==""){
         cout=cout+1;
       }
        if (cout<1) {
            $("#form").submit();
        } else {
            $.message.alert("信息填写不完整");
        }
    }
</script>
</body>
</html>
