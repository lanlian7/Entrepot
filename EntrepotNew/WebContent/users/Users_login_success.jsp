<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>仓库管理系统</title>
<link rel="stylesheet" type="text/css" href="../css/Users_login_success.css">
</head>

<body>
  <div id="head" > 
  <img src="../image/head.png" style="position:absolute;margin-left:150px;margin-right:100px;height:100px" />
</div>
<div id="head-head">
    <p style="position:absolute;margin-left:1150px;margin-top:3px;color:#FFF">[${sessionScope.loginUserName}，欢迎您]&nbsp;&nbsp;|</p>
    <a href="loginout.action" style="position:absolute;margin-left:1300px;margin-top:3px;color:#FFF">&nbsp;注销</a>
 </div>
  <div id="left">
       				<ul id="menu_items">
					<li class="menu_item on" style="border-radius:8px 0 0 8px" onmouseout="this.style.backgroundColor=''"        onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='8px 0 0 8px'"><a href="../Storage/Storage_query.jsp"><img src="../image/+.png" /></a></li>
					<li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a href="../OutGoing/OutGoing_query.jsp"><img src="../image/out.png"/></a></li>
					<li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a href="../GeneralStorage/GeneralStorage.jsp"><img src="../image/warehouse.png"/></a></li>
					<li class="menu_item" style="border-radius:8px 0 0 8px;border:0px;" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='0 8px 8px 0';this.style.fontWeight='bold'">
					                                                                                                                                                                               <a href="../Stock/Stock_query.jsp"><img src="../image/store.png"/></a></li>
				</ul>
    </div>
<div id="right">
      
   </div>
</body>
</html>