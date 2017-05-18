<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/default.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>仓库管理系统</title>

<script type="text/javascript" src="easyUI/jquery.min.js"></script>
<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="easyUI/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="easyUI/themes/default/easyui.css"
	type="text/css"></link>
<link rel="stylesheet" href="easyUI/themes/icon.css" type="text/css"></link>


<!-- 引入对应的css文件 -->
<link rel="stylesheet" type="text/css"
	href="css/inWarehouse/query_success.css">


	
<script type="text/javascript">  
   $(function(){
        $('#StockAlert').datagrid({   
	    	    fitColumns:true,
                title: '库存警告',    
                url:'Stock_alertJson.action',
                iconCls : 'icon-save',  
                width : 'auto',  
                height : 'auto',  
                pageSize:10,  
                pageList : [ 5, 10, 15 ],  
                nowrap : true,   
                striped : true,  
                collapsible : true,  
                loadMsg : '数据装载中......',  
                onLoadError : function() {  
                    alert('数据加载失败!');  
                },  
                columns:[[  
                	{field:'id',title:"id",width:10,align:'right',checkbox:true},
                    {field:'Material_Number',title:'料号',width:80},  
                    {field:'Name',title:'名称',width:80},  
                    {field:'Specification',title:'规格',width:80,align:'right'},  
                    {field:'Number',title:'存量',width:80,align:'right'},  
                    {field:'Unit',title:'单位',width:70,align:'right'},
                    {field:'UnitPrice',title:'单价',width:70,align:'right'},
                    {field:'AmountMoney',title:'金额',width:80,align:'right'},

                ]],  
                pagination:true, //包含分页 
                rownumbers:true,  
                singleSelect:true, 
        });  
   })
</script>
</head>
<body>
	<div id="head">
		<img src="image/head.png"
			style="position: absolute; margin-left: 150px; margin-right: 100px; height: 100px" />
	</div>
	<div id="head-head">
		<p
			style="position: absolute; margin-left: 1050px; margin-top: 3px; color: #FFF">[${sessionScope.loginUserName}，欢迎您]&nbsp;&nbsp;|</p>
		<a href="loginout.action"
			style="position: absolute; margin-left: 1200px; margin-top: 3px; color: #FFF">&nbsp;注销</a>
	</div>
	<div id="left">
		<ul id="menu_items">
			<li class="menu_item on" style="border-radius: 8px 0 0 8px"
				onmouseout="this.style.backgroundColor=''"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='8px 0 0 8px'"><a
				href="Storage/Storage_query.jsp"><img src="image/+.png" /></a></li>
			<li class="menu_item"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a
				href="OutGoing/OutGoing_query.jsp"><img
					src="image/out.png" /></a></li>
			<li class="menu_item"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a
				href="Store/Store_query.jsp"><img
					src="image/warehouse.png" /></a></li>
			<li class="menu_item"
				style="border-radius: 8px 0 0 8px; border: 0px;"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='0 8px 8px 0';this.style.fontWeight='bold'">
				<a href="Stock/Stock_query.jsp"><img src="image/store.png" /></a>
			</li>
		</ul>
	</div>
	<div id="right">
		<div id="navi">
			<div id='naviDiv'>
				<span><img src="images/arror.gif" width="7" height="11"
					border="0" alt=""></span>&nbsp;
					<a href="Users_login_success.jsp">总信息查询</a>
					<span>&nbsp; <span><img
						src="images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
					href="Users_alert.jsp">库存不足信息</a><span>&nbsp; 
			</div>
		</div>
		<table id="StockAlert"></table>
	</div>
</body>
</html>