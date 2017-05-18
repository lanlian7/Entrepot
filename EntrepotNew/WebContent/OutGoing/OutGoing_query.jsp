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
        $('#OutGoing').datagrid({   
	    	    fitColumns:true,
                title: '出库列表',     
                url:'OutGoing_queryJson.action',
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
                    {field:'OutGoingID',title:'出库单号',width:80},  
                    {field:'OutDate',title:'出库日期',width:80},  
                    {field:'Material_Number',title:'料号',width:80,align:'right'},  
                    {field:'Name',title:'名字',width:70,align:'right'},
                    {field:'Specification',title:'规格',width:70,align:'right'},
                    {field:'Number',title:'数量',width:80,align:'right'},
                    {field:'Unit',title:'单位',width:70,align:'right'},
                    {field:'Purpose',title:'用途',width:80,align:'right'},
                    {field:'Material_Department',title:'领料部门',width:80,align:'right'},
                    {field:'Material_Person',title:'领料人',width:80,align:'right'},

                ]],  
                pagination:true, //包含分页 
                rownumbers:true,  
                singleSelect:true, 
        });  
        
	    $("#searchBtnOutGoing").click(function(){
	    	$('#OutGoing').datagrid("reload",{
	    		OutGoingID: $("#OutGoingID").val(),
	    		OutDate: $("#OutDate").val(),
	    		Material_Number: $("#Material_Number").val(),
	    		Name: $("#Name").val(),
	    		Specifications: $("#Specifications").val(),
	    		Purpose: $("#Purpose").val(),
	    		Material_Department: $("#Material_Department").val(),
	    		Material_Person: $("#Material_Person").val(),
	    	})
	    	doReset();
	    	
	    });
	    	   
	    $("#addBtnOutGoing").click(function(){
	    	 $('#winoutgoing').window({
	    		title:"出库单新增",
	 	        width:600,
	 	        height:400,
	 	        modal:true,
	 	        href:"OutGoing_toAdd.action"
	 	    });
	    	 formReset();
	    });
	    
	    $("#editBtnOutGoing").click(function(){
	    	var checkeds = $('#OutGoing').datagrid("getChecked");
	    	 $('#winoutgoing').window({
	    		title:"出库单修改",
	 	        width:600,
	 	        height:400,
	 	        modal:true,
	 	        href:"OutGoing_toUpdate.action?id="+checkeds[0].id
	 	    });
	    }); 
   })
   
       function destoryStorage(){
    	var row = $('#OutGoing').datagrid('getSelected');
    	if (row){
    		$.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
    			if (r){
    				$.post('OutGoing_deleteJson.action',{id:row.id},function(result){
    					if (result.code==0){
    						$("#searchBtnOutGoing").click();
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
					<span>&nbsp; <span>
					<img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
					href="../Users_alert.jsp">库存不足信息查询</a><span>&nbsp; 
			</div>
		</div>
       <div id="p" class="easyui-panel" title="用户查询"
				style="width: 100%; padding: 10px; background: #fafafa;"
				data-options="iconCls:'icon-save',collapsible:true">
				<form id="myForm">
				  出库单号:<input class="easyui-textbox"  name="OutGoingID" id="OutGoingID" type="text"> 
				  出库日期:<input class="easyui-datebox" name="OutDate" id="OutDate" type="text">
				  料号:<input class="easyui-textbox" name="Material_Number" id="Material_Number" type="text">
				  名称: <input class="easyui-textbox" name="Name" id="Name" type="text"> </br>
				  规格 :<input class="easyui-textbox" name="Specification" id="Specification" type="text"> 
				  用途 :<input class="easyui-textbox" name="Purpose" id="Purpose" type="text"> 
				   领料部门 :<input class="easyui-textbox" name="Material_Department" id="Material_Department" type="text"> 
				   领料人 :<input class="easyui-textbox" name="Material_Person" id="Material_Person" type="text"> 
				 <a href="#" id="searchBtnOutGoing" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
				 </form>
		       	</div>
			     <a href="#" id="addBtnOutGoing" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
				 <a href="#" id="editBtnOutGoing" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
			     <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="destoryStorage()">删除</a>
				 <a href="OutGoing_query.jsp" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查看</a>
                 <a href="#" id="printBtn" class="easyui-linkbutton" data-options="iconCls:'icon-print'" onclick="document.all.WebBrowser.ExecWB(6,6)">直接打印</a> 
			     <a href="#" id="viewPrintBtn" class="easyui-linkbutton"  data-options="iconCls:'icon-print'" onclick="document.all.WebBrowser.ExecWB(7,1)">打印预览</a>
		         <a href="OutGoingReportAction_exportExcel.action" id="pageBtn" class="easyui-linkbutton"  data-options="iconCls:'icon-save'">导出</a>
               
		<table id="OutGoing"></table>
	</div>
	<div id="winoutgoing"></div>
	</div>
</body>
</html>



