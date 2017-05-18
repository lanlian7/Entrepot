<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<OBJECT classid=CLSID:8856F961-340A-11D0-A96B-00C04FD705A2 height=0
	id=WebBrowser width=0></OBJECT>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="../css/default.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>仓库管理系统</title>

<!-- 引入easy UI -->
<script type="text/javascript" src="../easyUI/jquery.min.js"></script>
<script type="text/javascript" src="../easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../easyUI/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="../easyUI/themes/default/easyui.css"
	type="text/css"></link>
<link rel="stylesheet" href="../easyUI/themes/icon.css" type="text/css"></link>

<!-- 引入web打印空间lodop -->
<script language="javascript" src="LodopFuncs.js"></script>
<object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
</object>

<!-- 引入对应的css文件 -->
<link rel="stylesheet" type="text/css"
	href="../css/inWarehouse/query_success.css">

<style media="print" type="text/css">
.Noprint {
	display: none;
}

.PageNext {
	page-break-after: always;
}
</style>

<script type="text/javascript">  
   $(function(){
        $('#storage').datagrid({   
	    	    fitColumns:true,
                title: '入库单列表',     
                url:'Storage_queryJson.action',
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
                	{field:'id',title:"id",width:10,align:'right',checkbox:true},
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
	    		StorageID: $("#StorageID").val(),
	    		Warehouse_Date: $("#Warehouse_Date").val(),
	    		Material_Number: $("#Material_Number").val(),
	    		Name: $("#Name").val(),
	    		Specifications: $("#Specifications").val(),
	    		WarehousePerson: $("#WarehousePerson").val(),
	    	})
	    });
	    	   
	    $("#addBtn").click(function(){
	    	 $('#win').window({
	    		title:"入库单新增",
	 	        width:600,
	 	        height:400,
	 	        modal:true,
	 	        href:"Storage_toAdd.action"
	 	    });
	    });
	    
	    $("#editBtn").click(function(){
	    	var checkeds = $('#storage').datagrid("getChecked");
	    	 $('#win').window({
	    		title:"用户修改",
	 	        width:600,
	 	        height:400,
	 	        modal:true,
	 	        href:"Storage_toUpdate.action?id="+checkeds[0].id
	 	    });
	    }); 
   })
   
       function destoryStorage(){
    	var row = $('#storage').datagrid('getSelected');
    	if (row){
    		$.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
    			if (r){
    				$.post('Storage_deleteJson.action',{id:row.id},function(result){
    					if (result.code==0){
    						$("#searchBtn").click();
    					} else {
    						$.messager.show({	// show error message
    							title: 'Error',
    							msg: result.code,
    						});
    					}
    				},'json');
    			}
    		});
    	}
    }
   
   function prn1_preview() {
       PrintMytable();
       LODOP.PREVIEW();
   };
   function prn1_print() {
       PrintMytable();
       LODOP.PRINT();
   };

   function PrintMytable() {
	   LODOP=getLodop(); 
       LODOP.PRINT_INIT("入库单信息");
       LODOP.SET_PRINT_PAGESIZE(1, 0, 0, "A4");
       LODOP.ADD_PRINT_TEXT(30, 280, 500, 50, "入库单信息")
       LODOP.SET_PRINT_STYLEA(1, "ItemType", 1);
       LODOP.SET_PRINT_STYLEA(1, "FontSize", 14);
       LODOP.SET_PRINT_STYLEA(1, "Bold", 1);
       LODOP.ADD_PRINT_TEXT(1050, 370, 200, 22, "第#页/共&页");
       LODOP.SET_PRINT_STYLEA(2, "ItemType", 2);
       LODOP.SET_PRINT_STYLEA(2, "HOrient", 1);
       LODOP.SET_PRINT_STYLEA(3, "ItemType", 1);
       LODOP.SET_PRINT_STYLEA(4, "ItemType", 1);
       //LODOP.ADD_PRINT_TABLE(110, 33, 750, 900, document.documentElement.innerHTML);
       LODOP.ADD_PRINT_TABLE(110, 33, 750, 900, document.getElementById("PageNext").innerHTML);
   };    
</script>



</head>

<body>
	<div id="head" class="Noprint">
		<img src="../image/head.png"
			style="position: absolute; margin-left: 150px; margin-right: 100px; height: 100px" />
	</div>
	<div id="head-head" class="Noprint">
		<p
			style="position: absolute; margin-left: 1150px; margin-top: 3px; color: #FFF">[${sessionScope.loginUserName}，欢迎您]&nbsp;&nbsp;|</p>
		<a href="loginout.action"
			style="position: absolute; margin-left: 1300px; margin-top: 3px; color: #FFF">&nbsp;注销</a>
	</div>
	<div id="left" class="Noprint">
		<ul id="menu_items">
			<li class="menu_item on" style="border-radius: 8px 0 0 8px"
				onmouseout="this.style.backgroundColor=''"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='8px 0 0 8px'"><a
				href="../Storage/Storage_query.jsp"><img src="../image/+.png" /></a></li>
			<li class="menu_item"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a
				href="../OutGoing/OutGoing_query.jsp"><img
					src="../image/out.png" /></a></li>
			<li class="menu_item"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a
				href="../Store/Store_query.jsp"><img
					src="../image/warehouse.png" /></a></li>
			<li class="menu_item"
				style="border-radius: 8px 0 0 8px; border: 0px;"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='0 8px 8px 0';this.style.fontWeight='bold'">
				<a href="../Stock/Stock_query.jsp"><img src="../image/store.png" /></a>
			</li>
		</ul>
	</div>
	<div id="right">
				<div id="p" class="easyui-panel" title="用户查询"
				style="width: 100%; padding: 10px; background: #fafafa;"
				data-options="iconCls:'icon-save',collapsible:true">
				订单号:<input class="easyui-textbox" name="StorageID"
					id="StorageID" type="text"> 入库时间:<input
					class="easyui-datebox" name="Warehouse_Date" id="Warehouse_Date"
					type="text"> 料号:<input class="easyui-textbox"
					name="Material_Number" id="Material_Number" type="text">
				名称: <input class="easyui-textbox" name="Name" id="Name"
					type="text"> 规格 :<input class="easyui-textbox"
					name="Specifications" id="Specifications" type="text"> 入库人员
				:<input class="easyui-textbox" name="WarehousePerson"
					id="WarehousePerson" type="text"> <a href="#"
					id="searchBtn" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'">查询</a>
			</div>
		<div class="Noprint">
			<a href="#" id="addBtn" class="easyui-linkbutton"
				data-options="iconCls:'icon-add'">新增</a> <a href="#" id="editBtn"
				class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
			<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-remove'" onclick="destoryStorage()">删除</a>
			<a href="Storage_query.jsp" class="easyui-linkbutton"
				data-options="iconCls:'icon-ok'">查看</a> 
			<a href="#" id="printBtn" class="easyui-linkbutton" data-options="iconCls:'icon-print'"
				onclick="prn1_print()">直接打印</a> 
			<a href="#" id="viewPrintBtn" class="easyui-linkbutton"
				data-options="iconCls:'icon-print'"
				onclick="prn1_preview()">打印预览</a>
		   <a href="StorageReportAction_exportExcel.action" id="pageBtn" class="easyui-linkbutton"
				data-options="iconCls:'icon-save'">导出</a>

		</div>
		<div id="PageNext">
			<table id="storage" class=""></table>
		</div>
	</div>
	</div>
	<div id="win"></div>
	</div>
</body>
</html>



