<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>
	<form id="formStore" method="post" action="">
	<table>
 		<tr>
			<td>仓库编号</td><td><input class="easyui-textbox"  type="text" id="storeAdd_id" name="id" value=""></td>
		</tr>
			<tr>
			<td>仓库名称</td><td><input class="easyui-textbox"  type="text" id="storeAdd_Name" name="Name" value=""></td>
		</tr>
		<tr>
			<td>仓库描述</td><td><input class="easyui-textbox" type="text" id="storeAdd_Description" name="Description" value=""></td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="easyui-linkbutton" data-options="iconCls:'icon-ok'" type="button" id="storeSubmitBtn" value="确认">
				<input class="easyui-linkbutton" data-options="iconCls:'icon-mini-refresh'" type="reset" value="重置">
			</td>
		</tr>
	</table>
	</form>
	<script type="text/javascript">
		$(function(){
			$("#storeSubmitBtn").click(function(){
				$.ajax({
				   type: "POST",
				   url: "Store_addJson.action",
				   data: {
				       "id":$("#storeAdd_id").val(),
					   "Name":$("#storeAdd_Name").val(),
					   "Warehouse_Date":$("#storeAdd_Warehouse_Date").val(),
					   "Description":$("#storeAdd_Description").val(),
				   },
				   dataType: "json",
				   success: function(data){
				     if(data.code==1){
				    	 $.messager.alert('提示信息','添加用户失败!','info');
				     }else{
				    	 $.messager.alert('提示信息','添加用户成功!','info');
				    	 $('#winStore').window("close");
				    	 $("#searchBtnStore").click();
				     }
				   }
				});
			});
		});
	</script>
</body>
</html>