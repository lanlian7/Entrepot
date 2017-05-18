<html>
<head>
<script type="text/javascript">  
   $(function(){
        $('#StockAlert').datagrid({   
	    	    fitColumns:true,
                title: '库存警告',    
                url:'Stock_alertJson.action',
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
                    {field:'Material_Number',title:'料号',width:80},  
                    {field:'Name',title:'名称',width:80},  
                    {field:'Specification',title:'规格',width:80,align:'right'},  
                    {field:'Number',title:'存量',width:80,align:'right'},  
                    {field:'Unit',title:'单位',width:70,align:'right'},
                    {field:'UnitPrice',title:'单价',width:70,align:'right'},
                    {field:'AmountMoney',title:'金额',width:80,align:'right'},

                ]],  
                pagination:true, //包含分页 
                rownumbers:true,  
                singleSelect:true, 
        });  
   })
</script>
</head>
<body><div>
		<table id="StockAlert"></table>
		</div>
</body>
</html>