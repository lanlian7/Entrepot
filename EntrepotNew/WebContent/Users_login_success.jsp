<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.io.*,java.util.*" %>
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
        $('#inwarahouse').datagrid({   
	    	    fitColumns:true,
                title: '入库单列表',     
                url:'InWarehouse_queryJson.action',
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
                	{field:'Material_Number',title:"料号",width:50,align:'right'},
                    {field:'Name',title:'名称',width:80},  
                    {field:'Specification',title:'规格',width:80},  
                    {field:'Number',title:'库存量',width:80,align:'right'},  
                    {field:'Unit',title:'单位',width:80,align:'right'},  
                    {field:'UnitPrice',title:'单价',width:70,align:'right'},
                    {field:'Warehouse_Date',title:'入库日期',width:70,align:'right'},
                    {field:'Number1',title:'入库数量',width:80,align:'right'},
                    {field:'WarehousePerson',title:'入库人员',width:80,align:'right'},
                    {field:'OutDate',title:'出库日期',width:80,align:'right'},
                    {field:'Number2',title:'出库数量',width:80,align:'right'},
                    {field:'Purpose',title:'用途',width:80,align:'right'},
                    {field:'Material_Department',title:'领料部门',width:80,align:'right'},
                    {field:'Material_Person',title:'领料人',width:80,align:'right'},
                    {field:'Position_select',title:'仓位',width:80,align:'right'},

                ]],  
                pagination:true, //包含分页 
                rownumbers:true,  
                singleSelect:true, 
        });  
        
	    $("#searchBtn").click(function(){
	    	$('#inwarahouse').datagrid("reload",{
	    		Material_Number: $("#Material_Number").val(),
	    		Name: $("#Name").val(),
	    		Specification: $("#Specification").val(),
	    	})
	    	formReset();
	    });
    });

   function myAlert(){
	   $.ajax({
		   type: "POST",
		   url: "Stock_checkStoreJson.action",
		   dataType: "json",
		   success: function(data){
		     if(data.code==1){
		    	// $.messager.alert('警告，有货物库存不足，详情请查看库存不足表');
		    	 alert('警告，有货物库存不足，详情请查看库存不足表');
		     }
		   }
		});
   }
   
   
   function formReset()
   {
   document.getElementById("myForm").reset()
   }
 </script>

</head>

<body onload="myAlert()">
  <div id="head" > 
  <img src="image/head.png" style="position:absolute;margin-left:150px;margin-right:100px;height:100px" />
</div>
<div id="head-head">
    <p style="position:absolute;margin-left:1050px;margin-top:3px;color:#FFF">[${sessionScope.loginUserName}，欢迎您]&nbsp;&nbsp;|</p>
    <a href="loginout.action" style="position:absolute;margin-left:1200px;margin-top:3px;color:#FFF">&nbsp;注销</a>
 </div>
  <div id="left">
       				<ul id="menu_items">
					<li class="menu_item on" style="border-radius:8px 0 0 8px" onmouseout="this.style.backgroundColor=''"        onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='8px 0 0 8px'"><a href="Storage/Storage_query.jsp"><img src="image/+.png" /></a></li>
					<li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a href="OutGoing/OutGoing_query.jsp"><img src="image/out.png"/></a></li>
					<li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a href="Store/Store_query.jsp"><img src="image/warehouse.png"/></a></li>
					<li class="menu_item" style="border-radius:8px 0 0 8px;border:0px;" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='0 8px 8px 0';this.style.fontWeight='bold'">
					                                                                                                                                                                               <a href="Stock/Stock_query.jsp"><img src="image/store.png"/></a></li>
				</ul>
    </div>
<div id="right">
             <div id="p" class="easyui-panel" title="库存查询"
				style="width: 100%; padding: 10px; background: #fafafa;"
				data-options="iconCls:'icon-save',collapsible:true">
				<form id="myForm">
				料号:<input class="easyui-textbox"  name="Material_Number" id="Material_Number" type="text"> 
				名称:<input class="easyui-textbox" name="Name" id="Name" type="text">
				 规格:<input class="easyui-textbox" name="Specification" id="Specification" type="text">
				 <a href="#" id="searchBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
				 </form>
		       	</div>
		       	
		       	  <a href="#" id="printBtn" class="easyui-linkbutton" data-options="iconCls:'icon-print'" onclick="document.all.WebBrowser.ExecWB(6,6)">直接打印</a> 
			     <a href="#" id="viewPrintBtn" class="easyui-linkbutton"  data-options="iconCls:'icon-print'" onclick="document.all.WebBrowser.ExecWB(7,1)">打印预览</a>
		         <a href="inWarehouseReportAction_exportExcel.action" id="pageBtn" class="easyui-linkbutton"  data-options="iconCls:'icon-save'">导出</a>
		       	
		       	<table id="inwarahouse"></table>
   </div>
   <div id="win"></div>
</body>
</html>