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
			<td>id</td><td><input class="easyui-textbox"  type="text" id="update_id" name="id" value="${outgoing.id }" readonly="readonly"></td>
		</tr>
			<tr>
			<td>出库单号</td><td><input class="easyui-textbox"  type="text" id="update_OutGoingID" name="OutGoingID" value="${outgoing.outGoingID }" readonly="readonly"></td>
		</tr>
		<tr>
			<td>出库日期</td><td><input class="easyui-datebox" type="text" id="update_OutDate" name="OutDate" value="${outgoing.outDate }"></td>
		</tr>
		<tr>
			<td>料号</td><td><input class="easyui-textbox" type="text" id="update_Material_Number" name="Material_Number" value="${outgoing.material_Number }"></td>
		</tr>
		<tr>
			<td>名字</td><td><input class="easyui-textbox" type="text" id="update_Name" name="Name" value="${outgoing.name }"></td>
		</tr>
				<tr>
			<td>规格</td><td><input class="easyui-textbox" type="text" id="update_Specification" name="Specification" value="${outgoing.specification }"></td>
		</tr>
				<tr>
			<td>数量</td><td><input class="easyui-textbox" type="text" id="update_Number" name="Number" value="${outgoing.number }"></td>
		</tr>
				<tr>
			<td>单位</td><td><input class="easyui-textbox" type="text" id="update_Unit" name="Unit" value="${outgoing.unit }"></td>
		</tr>
				<tr>
			<td>用途</td><td><input class="easyui-textbox" type="text" id="update_Purpose" name="Purpose" value="${outgoing.purpose }"></td>
		</tr>
				<tr>
			<td>领料部门</td><td><input class="easyui-textbox" type="text" id="update_Material_Department" name="Material_Department" value="${outgoing.material_Department }"></td>
		</tr>
				<tr>
			<td>领料人</td><td><input class="easyui-textbox" type="text" id="update_Material_Person" name="Material_Person" value="${outgoing.material_Person }"></td>
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
				   url: "OutGoing_updateJson.action",
				   data: {
				       "id":$("#update_id").val(),
					   "OutGoingID":$("#update_OutGoingID").val(),
					   "OutDate":$("#update_OutDate").val(),
					   "Supplier":$("#update_Supplier").val(),
					   "Material_Number":$("#update_Material_Number").val(),
					   "Name":$("#update_Name").val(),
					   "Specification":$("#update_Specification").val(),
					   "Number":$("#update_Number").val(),
					   "Unit":$("#update_Unit").val(),
					   "Purpose":$("#update_Purpose").val(),
					   "Material_Department":$("#update_Material_Department").val(),
					   "Material_Person":$("#update_Material_Person").val(),
				   },
				   dataType: "json",
				   success: function(data){
				     if(data.code==1){
				    	 $.messager.alert('提示信息','修改出库单失败!','info');
				     }else if(data.code==2){
				    	 $.messager.alert('提示信息','修改出库单失败!库存不足','info');
				     }
				     else{
				    	 $.messager.alert('提示信息','修改出库单成功!','info');
				    	 $('#winoutgoing').window("close");
				    	 $("#searchBtnOutGoing").click();
				     }
				   }
				});
			});
		});
	</script>
</body>
</html>