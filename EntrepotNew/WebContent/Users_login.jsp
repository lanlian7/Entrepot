<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 这是一个html5 doctype声明 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="css/Users.css">
</head>

<body>
<div id="wrapper">
	<div id="header">
		<div id="logo"></div>
		<div id="heading">
			<div id="title">仓库管理系统</div>
			<div id="subTitle">Ver 1.0</div>
		</div>
	</div>
	<div id="main">
		<div id="mainBg">
			<div id="mainPanel">
				<div id="left">
					<div id="image"></div>
				</div>
				<div id="right">
					
					<form name="loginForm" action="login.action" method="post">
					<!-- start of login form -->
					<div id="welcome">
						<span id="welcome-text">管&nbsp;理&nbsp;登&nbsp;录</span>
					</div>
					<div id="user-name">
						<span class="item">用户名:</span>
						<span><input type="text" name="username" class="form-input"></span>
					</div>
					<div id="user-password">
						<span class="item">密&nbsp;&nbsp;&nbsp;码:</span>
						<span class="input"><input type="password" name="password" class="form-input"></span>
					</div>
					<div id="button-group">
						<input type="submit" class="btn" value="登录"/>
						<input type="reset" class="btn" value="重置"/>
					</div>
					<div>
					  <s:fielderror/> <!-- 显示表单验证的出错信息 -->
					</div>
					<!-- end of form -->
					</form>
					
				</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="text">Copyright © 2009-2015 All Rights Reserved Powered By Simoniu</div>
	</div>
</div>
</body>
</html>