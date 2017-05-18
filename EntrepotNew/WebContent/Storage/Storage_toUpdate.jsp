<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>
	<form id="form1" method="post" action="">
	<table>
 		<tr>
			<td>id</td><td><input class="easyui-textbox"  type="text" id="update_id" name="id" value="${storage.id }" readonly="readonly"></td>
		</tr>
			<tr>
			<td>入库单号</td><td><input class="easyui-textbox"  type="text" id="update_StorageID" name="StorageID" value="${storage.storageID }" readonly="readonly"></td>
		</tr>
		<tr>
			<td>入库日期</td><td><input class="easyui-datebox" type="text" id="update_Warehouse_Date" name="Warehouse_Date" value="${storage.warehouse_Date }"></td>
		</tr>
		<tr>
			<td>供应商</td><td><input class="easyui-textbox" type="text" id="update_Supplier" name="Supplier" value="${storage.supplier }"></td>
		</tr>
		<tr>
			<td>料号</td><td><input class="easyui-textbox" type="text" id="update_Material_Number" name="Material_Number" value="${storage.material_Number }"></td>
		</tr>
		<tr>
			<td>名字</td><td><input class="easyui-textbox" type="text" id="update_Name" name="Name" value="${storage.name }"></td>
		</tr>
				<tr>
			<td>规格</td><td><input class="easyui-textbox" type="text" id="update_Specifications" name="Specifications" value="${storage.specifications }"></td>
		</tr>
				<tr>
			<td>数量</td><td><input class="easyui-textbox" type="text" id="update_Number" name="Number" value="${storage.number }"></td>
		</tr>
				<tr>
			<td>单位</td><td><input class="easyui-textbox" type="text" id="update_Unit" name="Unit" value="${storage.unit }"></td>
		</tr>
				<tr>
			<td>单价</td><td><input class="easyui-textbox" type="text" id="update_UnitPrice" name="UnitPrice" value="${storage.unitPrice }"></td>
		</tr>
				<tr>
			<td>金额</td><td><input class="easyui-textbox" type="text" id="update_Amount_money" name="Amount_money" value="${storage.amount_money }"></td>
		</tr>
				<tr>
			<td>入库人员</td><td><input class="easyui-textbox" type="text" id="update_WarehousePerson" name="WarehousePerson" value="${storage.warehousePerson }"></td>
		</tr>
				<tr>
			<td>仓位选择</td><td><input class="easyui-textbox" type="text" id="update_Position_selection" name="Position_selection" value="${storage.position_selection }"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="easyui-linkbutton" data-options="iconCls:'icon-ok'" type="button" id="submitBtnn" value="确认">
				<input class="easyui-linkbutton" data-options="iconCls:'icon-mini-refresh'" type="reset" value="重置">
			</td>
		</tr>
	</table>
	</form>
	<script type="text/javascript">
		$(function(){
			$("#submitBtnn").click(function(){
				$.ajax({
				   type: "POST",
				   url: "Storage_updateJson.action",
				   data: {
				       "id":$("#update_id").val(),
					   "StorageID":$("#update_StorageID").val(),
					   "Warehouse_Date":$("#update_Warehouse_Date").val(),
					   "Supplier":$("#update_Supplier").val(),
					   "Material_Number":$("#update_Material_Number").val(),
					   "Name":$("#update_Name").val(),
					   "Specifications":$("#update_Specifications").val(),
					   "Number":$("#update_Number").val(),
					   "Unit":$("#update_Unit").val(),
					   "UnitPrice":$("#update_UnitPrice").val(),
					   "Amount_money":$("#update_Amount_money").val(),
					   "WarehousePerson":$("#update_WarehousePerson").val(),
					   "Position_selection":$("#update_Position_selection").val(),
				   },
				   dataType: "json",
				   success: function(data){
				     if(data.code==1){
				    	 $.messager.alert('提示信息','修改信息失败!','info');
				     }else{
				    	 $.messager.alert('提示信息','修改信息成功!','info');
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
