<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/default.css" />

</head>
<body>
	<form id="form1" method="post" action="">
	<table>
 		<tr>
			<td width="30%">id:</td><td><input class="easyui-textbox" data-options="fit:true" type="text" id="add_id" name="id" value=""/></td>
		</tr>
			<tr>
			<td width="30%">入库单号:</td><td><input class="easyui-textbox" data-options="fit:true" type="text" id="add_StorageID" name="StorageID" value=""/></td>
		</tr>
		<tr>
			<td>入库日期:</td><td><input class="easyui-datebox" type="text" id="add_Warehouse_Date" name="Warehouse_Date" value=""/></td>
		</tr>
		<tr>
			<td>供应商:</td><td><input class="easyui-textbox" type="text" id="add_Supplier" name="Supplier" value=""/></td>
		</tr>
		<tr>
			<td>料号:</td><td><input class="easyui-textbox" type="text" id="add_Material_Number" name="Material_Number" value=""/></td>
		</tr>
		<tr>
			<td>名字:</td><td><input class="easyui-textbox" type="text" id="add_Name" name="Name" value=""/></td>
		</tr>
				<tr>
			<td>规格:</td><td><input class="easyui-textbox" type="text" id="add_Specifications" name="Specifications" value=""/></td>
		</tr>
				<tr>
			<td>数量:</td><td><input class="easyui-textbox" type="text" id="add_Number" name="Number" value=""/></td>
		</tr>
				<tr>
			<td>单位:</td><td><input class="easyui-textbox" type="text" id="add_Unit" name="Unit" value=""/></td>
		</tr>
				<tr>
			<td>单价:</td><td><input class="easyui-textbox" type="text" id="add_UnitPrice" name="UnitPrice" value=""/></td>
		</tr>
				<tr>
			<td>金额:</td><td><input class="easyui-textbox" type="text" id="add_Amount_money" name="Amount_money" value=""/></td>
		</tr>
				<tr>
			<td>入库人员:</td><td><input class="easyui-textbox" type="text" id="add_WarehousePerson" name="WarehousePerson" value=""/></td>
		</tr>
				<tr>
			<td>仓位选择:</td><td><input class="easyui-textbox" type="text" id="add_Position_selection" name="Position_selection" value=""/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="easyui-linkbutton" data-options="iconCls:'icon-ok'" type="button" id="submitBtn" value="确认">
				<input class="easyui-linkbutton" data-options="iconCls:'icon-mini-refresh'" type="reset" value="重置">
			</td>
		</tr>
	</table>
	</form>
	<script type="text/javascript">
		$(function(){
			$("#submitBtn").click(function(){
				$.ajax({
				   type: "POST",
				   url: "Storage_addJson.action",
				   data: {
				       "id":$("#add_id").val(),
					   "StorageID":$("#add_StorageID").val(),
					   "Warehouse_Date":$("#add_Warehouse_Date").val(),
					   "Supplier":$("#add_Supplier").val(),
					   "Material_Number":$("#add_Material_Number").val(),
					   "Name":$("#add_Name").val(),
					   "Specifications":$("#add_Specifications").val(),
					   "Number":$("#add_Number").val(),
					   "Unit":$("#add_Unit").val(),
					   "UnitPrice":$("#add_UnitPrice").val(),
					   "Amount_money":$("#add_Amount_money").val(),
					   "WarehousePerson":$("#add_WarehousePerson").val(),
					   "Position_selection":$("#add_Position_selection").val(),
				   },
				   dataType: "json",
				   success: function(data){
				     if(data.code==1){
				    	 $.messager.alert('提示信息','添加信息失败!','info');
				     }else{
				    	 $.messager.alert('提示信息','添加信息成功!','info');
				    	 $('#win').window("close");
				    	 $("#searchBtn").click();
				     }
				   }
				});
			});
		});
	</script>
</body>
</html>
