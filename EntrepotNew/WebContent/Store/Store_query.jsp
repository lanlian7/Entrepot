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
<link rel="stylesheet" type="text/css" href="../css/default.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>仓库管理系统</title>

<script type="text/javascript" src="../easyUI/jquery.min.js"></script>
<script type="text/javascript" src="../easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../easyUI/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="../easyUI/themes/default/easyui.css"
	type="text/css"></link>
<link rel="stylesheet" href="../easyUI/themes/icon.css" type="text/css"></link>


<!-- 引入对应的css文件 -->
<link rel="stylesheet" type="text/css"
	href="../css/inWarehouse/query_success.css">



<script type="text/javascript">  
   $(function(){
	   

        $('#Store').datagrid({   
	    	    fitColumns:true,
                title: '入库单列表',     
                url:'Store_queryJson.action',
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
                	{field:'id',title:"id",width:80,align:'right',checkbox:true},
                    {field:'Name',title:'仓位名称',width:80},  
                    {field:'Description',title:'描述',width:80},  
                ]],  
                pagination:true, //包含分页 
                rownumbers:true,  
                singleSelect:true, 
        });  
        
	    $("#searchBtnStore").click(function(){
	    	$('#Store').datagrid("reload",{
	    		id: $("#id").val(),
	    		GSName: $("#Name").val(),
	    	})
	    	formReset();
	    });
	    	   
	    $("#addBtnStore").click(function(){
	    	 $('#winStore').window({
	    		title:"入库单新增",
	 	        width:600,
	 	        height:400,
	 	        modal:true,
	 	        href:"Store_toAdd.action"
	 	    });
	    });
	    
	    $("#editBtnStore").click(function(){
	    	var checkeds = $('#Store').datagrid("getChecked");
	    	 $('#winStore').window({
	    		title:"用户修改",
	 	        width:600,
	 	        height:400,
	 	        modal:true,
	 	        href:"Store_toUpdate.action?id="+checkeds[0].id
	 	    });
	    }); 
   })
   
       function destoryStorage(){
    	var row = $('#Store').datagrid('getSelected');
    	if (row){
    		$.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
    			if (r){
    				$.post('Store_deleteJson.action',{id:row.id},function(result){
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
   
   function formReset()
   {
   document.getElementById("myForm").reset()
   }
    </script>



</head>

<body>
	<div id="head">
		<img src="../image/head.png"
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
		<div id="navi">
			<div id='naviDiv'>
				<span><img src="../images/arror.gif" width="7" height="11"
					border="0" alt=""></span>&nbsp;
					<a href="../Users_login_success.jsp">总信息查询</a>
					<span>&nbsp; <span><img
						src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
					href="../Users_alert.jsp">库存不足信息</a><span>&nbsp; 
			</div>
		</div>
       <div id="p" class="easyui-panel" title="用户查询"
				style="width: 100%; padding: 10px; background: #fafafa;"
				data-options="iconCls:'icon-save',collapsible:true">
				<form id="myForm">
				仓位编号:<input class="easyui-textbox"  name="id" id="id" type="text"> 
				仓位名称:<input class="easyui-textbox" name="Name" id="GSName" type="text">
				 <a href="#" id="searchBtnStore" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
				 </form>
		       	</div>
			    <a href="#" id="addBtnStore" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
				<a href="#" id="editBtnStore" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
			     <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="destoryStorage()">删除</a>
				 <a href="Store_query.jsp" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查看</a>
                 <a href="#" id="printBtn" class="easyui-linkbutton" data-options="iconCls:'icon-print'" onclick="document.all.WebBrowser.ExecWB(6,6)">直接打印</a> 
			     <a href="#" id="viewPrintBtn" class="easyui-linkbutton"  data-options="iconCls:'icon-print'" onclick="document.all.WebBrowser.ExecWB(7,1)">打印预览</a>
		         <a href="StoreReportAction_exportExcel.action" id="pageBtn" class="easyui-linkbutton"  data-options="iconCls:'icon-save'">导出</a>

		<table id="Store"></table>
	</div>
	<div id="winStore"></div>
	</div>
</body>
</html>



