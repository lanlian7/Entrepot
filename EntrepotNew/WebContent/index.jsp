<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="../css/default.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>仓库管理系统</title>

<script type="text/javascript" src="../easyUI/jquery.min.js"></script>
<script type="text/javascript" src="../easyUI/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="../easyUI/themes/default/easyui.css"
	type="text/css"></link>
<link rel="stylesheet" href="../easyUI/themes/icon.css" type="text/css"></link>


<!-- 引入对应的css文件 -->
<link rel="stylesheet" type="text/css"
	href="../css/inWarehouse/query_success.css">



<script type="text/javascript">  
   $(function(){
        $('#storage').datagrid({    
                title: '入库单列表',     
                url:'Storage_query.action',
                iconCls : 'icon-save',  
                width : 'auto',  
                height : 'auto',  
                pageSize:15,  
                pageList : [ 5, 10, 15 ],  
                nowrap : true,   
                striped : true,  
                collapsible : true,  
                loadMsg : '数据装载中......',  
                onLoadError : function() {  
                    alert('数据加载失败!');  
                },  
                columns:[[  
                	{field:'id',title:"id",width:10,align:'right'},
                    {field:'StorageID',title:'入库单号',width:80},  
                    {field:'Warehouse_Date',title:'入库日期',width:80},  
                    {field:'Supplier',title:'供应商',width:80,align:'right'},  
                    {field:'Material_Number',title:'料号',width:80,align:'right'},  
                    {field:'Name',title:'名字',width:70,align:'right'},
                    {field:'Specifications',title:'规格',width:70,align:'right'},
                    {field:'Number',title:'数量',width:80,align:'right'},
                    {field:'Unit',title:'单位',width:70,align:'right'},
                    {field:'UnitPrice',title:'单价',width:80,align:'right'},
                    {field:'Amount_money',title:'金额',width:80,align:'right'},
                    {field:'WarehousePerson',title:'入库人员',width:80,align:'right'},
                    {field:'Position_selection',title:'仓位选择',width:80,align:'right'}

                ]],  
                pagination:true, //包含分页 
                rownumbers:true,  
                singleSelect:true, 
        });  

	    $("#searchBtn").click(function(){
	    	$('#storage').datagrid("reload",{
	    		StorageID:$("#StorageID").val(),
	    		Warehouse_Date:$("#Warehouse_Date").val(),
	    		Material_Number:$("#Material_Number").val(),
	    		Name:$("#Name").val(),
	    		Specifications:$("#Specifications").val(),
	    		WarehousePerson:$("#WarehousePerson").val(),
	    	})
	    });
	    
	    $("#addBtn").click(function(){
	    	 $('#win').window({
	    		title:"用户新增",
	 	        width:600,
	 	        height:400,
	 	        modal:true,
	 	        href:"#"
	 	    });
	    });
	    
	    $("#editBtn").click(function(){
	    	var checkeds = $('#dg').datagrid("getChecked");
	    	 $('#win').window({
	    		title:"用户修改",
	 	        width:600,
	 	        height:400,
	 	        modal:true,
	 	        href:"#,"
	 	    });
	    });
        
   })
    </script>



</head>

<body>
	<div id="head">
		<img src="../image/head.png"
			style="position: absolute; margin-left: 150px; margin-right: 100px; height: 100px" />
	</div>
	<div id="head-head">
		<p
			style="position: absolute; margin-left: 1150px; margin-top: 3px; color: #FFF">[${sessionScope.loginUserName}，欢迎您]&nbsp;&nbsp;|</p>
		<a href="loginout.action"
			style="position: absolute; margin-left: 1300px; margin-top: 3px; color: #FFF">&nbsp;注销</a>
	</div>
	<div id="left">
		<ul id="menu_items">
			<li class="menu_item on" style="border-radius: 8px 0 0 8px"
				onmouseout="this.style.backgroundColor=''"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='8px 0 0 8px'"><a
				href="inWarehouseQuery.action"><img src="../image/+.png" /></a></li>
			<li class="menu_item"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a
				href="#"><img src="../image/out.png" /></a></li>
			<li class="menu_item"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a
				href="#"><img src="../image/warehouse.png" /></a></li>
			<li class="menu_item"
				style="border-radius: 8px 0 0 8px; border: 0px;"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='0 8px 8px 0';this.style.fontWeight='bold'">
				<a href="#"><img src="../image/store.png" /></a>
			</li>
		</ul>
	</div>
	<div id="right">
		<div id="navi">
			<div id='naviDiv'>
				<span><img src="../images/arror.gif" width="7" height="11"
					border="0" alt=""></span>&nbsp;入库信息管理<span>&nbsp; <span><img
						src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
					href="storage_query.action">入库单列表</a><span>&nbsp; 
			</div>
		</div>
		<div id="mainContainer">
			<div id="p" class="easyui-panel" title="入库查询" style="width: 100%; padding: 10px; background: #fafafa;"
				data-options="iconCls:'icon-save',collapsible:true">

				订单号：<input name="StorageID" id="StorageID" type="text">
				入库日期:<input name="Warehouse_Date" id="Warehouse_Date" type="date">
				料号：<input name="Material_Number" id="Material_Number" type="text">
				名称：<input name="Name" id="Name" type="text">
				</br>
				规格：<input name="Specifications" id="Specifications" type="text">
				入库人员：<input name="WarehousePerson" id="WarehousePerson" type="text">
				<a href="#" id="searchBtn" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'">查询</a>
			</div>
			<a href="#" id="addBtn" class="easyui-linkbutton"
				data-options="iconCls:'icon-add'">新增</a> <a href="#" id="editBtn"
				class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
			<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-remove'">删除</a> <a href="#"
				class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查看</a>


			<table id="storage"></table>


		</div>
	</div>
</body>
</html>



