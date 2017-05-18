package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;


import action.StorageAction;
import entity.Storage;
import net.sf.json.JSONObject;
import service.StorageDAO;
import service.impl.StorageDAOImpl;

public class StorageActionTest {
//	@Test
//	public void testQueryAll(){
//		JSONObject resultObj;
//		StorageDAO storageDao=new StorageDAOImpl();
//		List<Storage> list=storageDao.queryAllStorage();
//        ArrayList a=new ArrayList();
//        for (Storage storage:list){
//        	Map<String,Object> m=new HashMap<String,Object>();
//        	//JSONObject m = new JSONObject();
//        	m.put("id", storage.getId());
//        	m.put("StorageID", storage.getStorageID());
//        	m.put("Warehouse_Date", storage.getWarehouse_Date());
//        	m.put("Supplier", storage.getSupplier());
//        	m.put("Material_Number", storage.getMaterial_Number());
//        	m.put("Name", storage.getName());
//        	m.put("Specifications", storage.getSpecifications());
//        	m.put("Number", storage.getNumber());
//        	m.put("Unit", storage.getUnit());
//        	m.put("UnitPrice", storage.getUnitPrice());
//        	m.put("Amount_money", storage.getAmount_money());
//        	m.put("WarehousePerson", storage.getWarehousePerson());
//        	m.put("Position_selection", storage.getPosition_selection());
//     //   	ObjectMapper mapper = new ObjectMapper();
//     //   	String s=mapper.writeValueAsString(storage);
//            a.add(m);
////            jsonArray.add(m);
//        }
//        Map<String,Object> json= new HashMap<String,Object>();
//        json.put("total", list.size());
//        json.put("rows", a);
//        resultObj=JSONObject.fromObject(json);
//        System.out.println(resultObj);
//	}
	
//	@Test
//	public void TestExport(){
//	      StorageDAO dao=new StorageDAOImpl();
//	        List<Storage> list = dao.queryAllStorage(); 
//	        String templateFileName = "template/StorageTemplate.xls";  
//	        String resultFileName = "result/Storage.xls";  
//	        new ExcelReport().createExcel(templateFileName,list,resultFileName); 
//	}
}
