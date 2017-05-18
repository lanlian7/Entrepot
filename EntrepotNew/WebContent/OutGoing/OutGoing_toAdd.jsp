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
			<td>id</td><td><input class="easyui-textbox"  type="text" id="add_id" name="id" value=""></td>
		</tr>
			<tr>
			<td>出库单号</td><td><input class="easyui-textbox"  type="text" id="add_OutGoingID" name="OutGoingID" value=""></td>
		</tr>
		<tr>
			<td>出库日期</td><td><input class="easyui-datebox" type="text" id="add_OutDate" name="OutDate" value=""></td>
		</tr>
		<tr>
			<td>料号</td><td><input class="easyui-textbox" type="text" id="add_Material_Number" name="Material_Number" value=""></td>
		</tr>
		<tr>
			<td>名字</td><td><input class="easyui-textbox" type="text" id="add_Name" name="Name" value=""></td>
		</tr>
				<tr>
			<td>规格</td><td><input class="easyui-textbox" type="text" id="add_Specification" name="Specification" value=""></td>
		</tr>
				<tr>
			<td>数量</td><td><input class="easyui-textbox" type="text" id="add_Number" name="Number" value=""></td>
		</tr>
				<tr>
			<td>单位</td><td><input class="easyui-textbox" type="text" id="add_Unit" name="Unit" value=""></td>
		</tr>
				<tr>
			<td>用途</td><td><input class="easyui-textbox" type="text" id="add_Purpose" name="Purpose" value=""></td>
		</tr>
				<tr>
			<td>领料部门</td><td><input class="easyui-textbox" type="text" id="add_Material_Department" name="Material_Department" value=""></td>
		</tr>
				<tr>
			<td>领料人</td><td><input class="easyui-textbox" type="text" id="add_Material_Person" name="Material_Person" value=""></td>
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
				   url: "OutGoing_addJson.action",
				   data: {
				       "id":$("#add_id").val(),
					   "OutGoingID":$("#add_OutGoingID").val(),
					   "OutDate":$("#add_OutDate").val(),
					   "Supplier":$("#add_Supplier").val(),
					   "Material_Number":$("#add_Material_Number").val(),
					   "Name":$("#add_Name").val(),
					   "Specification":$("#add_Specification").val(),
					   "Number":$("#add_Number").val(),
					   "Unit":$("#add_Unit").val(),
					   "Purpose":$("#add_Purpose").val(),
					   "Material_Department":$("#add_Material_Department").val(),
					   "Material_Person":$("#add_Material_Person").val(),
				   },
				   dataType: "json",
				   success: function(data){
				     if(data.code==1){
				    	 $.messager.alert('提示信息','添加出库单失败!','info');
				     }else if(data.code==2){
				    	 $.messager.alert('提示信息','添加出库单失败!库存不足或者无此料号','info');
				     }
				     else{
				    	 $.messager.alert('提示信息','添加出库单成功!','info');
				    	 $('#winoutgoing').window("close");
				    	 $("#searchBtn").click();
				     }
				   }
				});
			});
		});
	</script>
</body>
</html>