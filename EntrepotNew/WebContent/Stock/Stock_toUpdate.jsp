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
			<td>id</td><td><input class="easyui-textbox"  type="text" id="update_id" name="id" value="${stock.id }" readonly="readonly"></td>
		</tr>
			<tr>
			<td>料号</td><td><input class="easyui-textbox"  type="text" id="update_Material_Number" name="Material_Number" value="${stock.material_Number }"></td>
		</tr>
		<tr>
			<td>名称</td><td><input class="easyui-textbox" type="text" id="update_Name" name="Name" value="${stock.name }"></td>
		</tr>
		<tr>
			<td>规格</td><td><input class="easyui-textbox" type="text" id="update_Specification" name="Specification" value="${stock.specification }"></td>
		</tr>
		<tr>
			<td>存量</td><td><input class="easyui-textbox" type="text" id="update_Number" name="Number" value="${stock.number }"></td>
		</tr>
				<tr>
			<td>单位</td><td><input class="easyui-textbox" type="text" id="update_Unit" name="Unit" value="${stock.unit }"></td>
		</tr>
				<tr>
			<td>单价</td><td><input class="easyui-textbox" type="text" id="update_UnitPrice" name="UnitPrice" value="${stock.unitPrice }"></td>
		</tr>
				<tr>
			<td>金额</td><td><input class="easyui-textbox" type="text" id="update_AmountMoney" name="AmountMoney" value="${stock.amountMoney }"></td>
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
				   url: "Stock_updateJson.action",
				   data: {
				       "id":$("#update_id").val(),
					   "Material_Number":$("#update_Material_Number").val(),
					   "Name":$("#update_Name").val(),
					   "Specification":$("#update_Specification").val(),
					   "Number":$("#update_Number").val(),
					   "Unit":$("#update_Unit").val(),
					   "UnitPrice":$("#update_UnitPrice").val(),
					   "AmountMoney":$("#update_AmountMoney").val(),
				   },
				   dataType: "json",
				   success: function(data){
				     if(data.code==1){
				    	 $.messager.alert('提示信息','修改库存失败!','info');
				     }else{
				    	 $.messager.alert('提示信息','修改库存成功!','info');
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