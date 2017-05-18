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
			<td>料号</td><td><input class="easyui-textbox"  type="text" id="add_Material_Number" name="Material_Number" value=""></td>
		</tr>
		<tr>
			<td>名称</td><td><input class="easyui-textbox" type="text" id="add_Name" name="Name" value=""></td>
		</tr>
		<tr>
			<td>规格</td><td><input class="easyui-textbox" type="text" id="add_Specification" name="Specification" value=""></td>
		</tr>
		<tr>
			<td>存量</td><td><input class="easyui-textbox" type="text" id="add_Number" name="Number" value=""></td>
		</tr>
				<tr>
			<td>单位</td><td><input class="easyui-textbox" type="text" id="add_Unit" name="Unit" value=""></td>
		</tr>
				<tr>
			<td>单价</td><td><input class="easyui-textbox" type="text" id="add_UnitPrice" name="UnitPrice" value=""></td>
		</tr>
				<tr>
			<td>金额</td><td><input class="easyui-textbox" type="text" id="add_AmountMoney" name="AmountMoney" value=""></td>
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
				   url: "Stock_addJson.action",
				   data: {
				       "id":$("#add_id").val(),
					   "Material_Number":$("#add_Material_Number").val(),
					   "Name":$("#add_Name").val(),
					   "Specification":$("#add_Specification").val(),
					   "Number":$("#add_Number").val(),
					   "Unit":$("#add_Unit").val(),
					   "UnitPrice":$("#add_UnitPrice").val(),
					   "AmountMoney":$("#add_AmountMoney").val(),
				   },
				   dataType: "json",
				   success: function(data){
				     if(data.code==1){
				    	 $.messager.alert('提示信息','添加用户失败!','info');
				     }else{
				    	 $.messager.alert('提示信息','添加用户成功!','info');
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