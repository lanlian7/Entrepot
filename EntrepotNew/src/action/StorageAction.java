package action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Stock;
import entity.Storage;
import service.StockDAO;
import service.StorageDAO;
import service.impl.StockDAOImpl;
import service.impl.StorageDAOImpl;

public class StorageAction extends SuperAction {
	private static final long serialVersionUID = 1L;

	public StorageAction() {
		super();
	}

	private Map<String, Object> queryJsonMap = new HashMap<String, Object>();
	private Map<String,Object> addJsonMap=new HashMap<String,Object>();
	private Map<String,Object> updateJsonMap=new HashMap<String,Object>();
	private Map<String,Object> deleteJsonMap=new HashMap<String,Object>();
	
	private String rows = "10";
	private String page = "1";

	public String query() throws ParseException  {
		Integer page = Integer.valueOf(this.page);
		// 每页显示条数
		Integer rows = Integer.valueOf(this.rows);
		// 每页的开始记录 第一页为1 第二页为number +1
		Storage storage1=new Storage();
		String storageID=request.getParameter("StorageID");
		String material_Number=request.getParameter("Material_Number");
		String name=request.getParameter("Name");
		String specifications=request.getParameter("Specifications");
		String warehousePerson = request.getParameter("WarehousePerson");
		String date=request.getParameter("Warehouse_Date");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date realDate=null;
		if(date!=""&&date!=null){
			try{
				realDate=sdf.parse(date);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		storage1.setWarehouse_Date(realDate);
		storage1.setStorageID(storageID);
		storage1.setMaterial_Number(material_Number);
		storage1.setName(name);
		storage1.setSpecifications(specifications);
		storage1.setWarehousePerson(warehousePerson);
		
		
		StorageDAO dao = new StorageDAOImpl();
		int start = (page - 1) * rows;
		List<Storage> list = dao.querySomeStorage(start, rows,storage1);
		ArrayList list1 = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Storage storage = list.get(i);
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("id", storage.getId());
			m.put("StorageID", storage.getStorageID());
			m.put("Warehouse_Date", storage.getWarehouse_Date());
			m.put("Supplier", storage.getSupplier());
			m.put("Material_Number", storage.getMaterial_Number());
			m.put("Name", storage.getName());
			m.put("Specifications", storage.getSpecifications());
			m.put("Number", storage.getNumber());
			m.put("Unit", storage.getUnit());
			m.put("UnitPrice", storage.getUnitPrice());
			m.put("Amount_money", storage.getAmount_money());
			m.put("WarehousePerson", storage.getWarehousePerson());
			m.put("Position_selection", storage.getPosition_selection());
			list1.add(m);

		}
		queryJsonMap.put("total",dao.queryCount());
		queryJsonMap.put("rows", list1);
		return SUCCESS;
	}

	public String delete() {
		StorageDAO storageDao = new StorageDAOImpl();
		long id =Long.parseLong(request.getParameter("id"));
		if(storageDao.deleteStorage(id)){
			deleteJsonMap.put("code", 0);
		}
		else{
			deleteJsonMap.put("code", 1);
		}
		return SUCCESS;
	}

	@SuppressWarnings("null")
	public String add() throws ParseException {
        String StorageID=request.getParameter("StorageID");
        String Supplier=request.getParameter("Supplier");
        String Material_Number=request.getParameter("Material_Number");
        String Name=request.getParameter("Name");
        String Specifications=request.getParameter("Specifications");
        String Number=request.getParameter("Number");
        String Unit=request.getParameter("Unit");
        String UnitPrice=request.getParameter("UnitPrice");
        String Amount_money=request.getParameter("Amount_money");
        String WarehousePerson=request.getParameter("WarehousePerson");
        String Position_selection=request.getParameter("Position_selection");
		StorageDAO storageDao = new StorageDAOImpl();
		Storage storage = new Storage();
		String date=request.getParameter("Warehouse_Date");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date realDate=null;
		if(date!=""){
			try{
				realDate=sdf.parse(date);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		realDate=java.sql.Date.valueOf(date);
		storage.setWarehouse_Date(realDate);
		storage.setAmount_money(Double.parseDouble(Amount_money));
		storage.setMaterial_Number(Material_Number);
		storage.setName(Name);
		storage.setNumber(Long.parseLong(Number));
		storage.setPosition_selection(Position_selection);
		storage.setSpecifications(Specifications);
		storage.setStorageID(StorageID);
		storage.setSupplier(Supplier);
		storage.setUnit(Unit);
		storage.setUnitPrice(Double.parseDouble(UnitPrice));
		storage.setWarehousePerson(WarehousePerson);
		StockDAO dao=new StockDAOImpl();
		Stock stock1=new Stock();
		Stock stock=dao.queryStockByMaterialNumber(storage.getMaterial_Number());
		Double b=storage.getAmount_money();
		System.out.println(b);
		if (storageDao.insertStorage(storage)){
			addJsonMap.put("code", 0);
			if(stock==null){
				stock1.setMaterial_Number(storage.getMaterial_Number());
				//stock1.setAmountMoney(storage.getAmount_money());
				stock1.setName(storage.getName());
				stock1.setNumber(storage.getNumber());
				stock1.setSpecification(storage.getSpecifications());
				stock1.setUnit(storage.getUnit());
				stock1.setUnitPrice(storage.getUnitPrice());
			   System.out.println(dao.insertStock(stock1));
			}
			else{
			stock.setNumber(storage.getNumber()+stock.getNumber());
			dao.updateStock(stock);
			}
		}
		else{
			addJsonMap.put("code",1);
		}
		return SUCCESS;
	}

	public String toAdd(){
		return "success";
	}
	
	public String toUpdate(){
		long id=Long.parseLong(request.getParameter("id"));
		StorageDAO storageDao=new StorageDAOImpl();
		Storage storage=storageDao.queryStorageById(id);
		session.setAttribute("storage", storage);
		return "success";
	}
	
	public String update() {
		    long id=Long.parseLong(request.getParameter("id"));
	        String StorageID=request.getParameter("StorageID");
	        String Warehouse_Date=request.getParameter("Warehouse_Date");
	        String Supplier=request.getParameter("Supplier");
	        String Material_Number=request.getParameter("Material_Number");
	        String Name=request.getParameter("Name");
	        String Specifications=request.getParameter("Specifications");
	        String Number=request.getParameter("Number");
	        String Unit=request.getParameter("Unit");
	        String UnitPrice=request.getParameter("UnitPrice");
	        String Amount_money=request.getParameter("Amount_money");
	        String WarehousePerson=request.getParameter("WarehousePerson");
	        String Position_selection=request.getParameter("Position_selection");
			StorageDAO storageDao = new StorageDAOImpl();
			Storage storage = new Storage();
			String date=request.getParameter("Warehouse_Date");
			
			SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
			java.util.Date realDate=null;
			if(date!=""){
				try{
					realDate=sdf.parse(date);
				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
			storage.setWarehouse_Date(realDate);
			storage.setId(id);
			storage.setAmount_money(Double.parseDouble(Amount_money));
			storage.setMaterial_Number(Material_Number);
			storage.setName(Name);
			storage.setNumber(Long.parseLong(Number));
			storage.setPosition_selection(Position_selection);
			storage.setSpecifications(Specifications);
			storage.setStorageID(StorageID);
			storage.setSupplier(Supplier);
			storage.setUnit(Unit);
			storage.setUnitPrice(Double.parseDouble(UnitPrice));
			storage.setWarehousePerson(WarehousePerson);
            Storage oldStorage=(Storage)session.getAttribute("storage");
            StockDAO dao=new StockDAOImpl();
            Stock stock=dao.queryStockByMaterialNumber(storage.getMaterial_Number());
			if (storageDao.updateStorage(storage)){
				updateJsonMap.put("code", 0);
				if(oldStorage.getNumber()<storage.getNumber()){
					long number=stock.getNumber()+storage.getNumber()-oldStorage.getNumber();
					System.out.println(number);
					stock.setNumber(stock.getNumber()+storage.getNumber()-oldStorage.getNumber());
					dao.updateStock(stock);
				}
				else{
					long number=stock.getNumber()-oldStorage.getNumber()+storage.getNumber();
					System.out.println(number);
					stock.setNumber(stock.getNumber()-oldStorage.getNumber()+storage.getNumber());
					dao.updateStock(stock);
				}
			}
			else{
				updateJsonMap.put("code",1);
			}
			return SUCCESS;
	}
	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Map<String, Object> getAddJsonMap() {
		return addJsonMap;
	}

	public void setAddJsonMap(Map<String, Object> addJsonMap) {
		this.addJsonMap = addJsonMap;
	}

	public Map<String, Object> getQueryJsonMap() {
		return queryJsonMap;
	}

	public void setQueryJsonMap(Map<String, Object> queryJsonMap) {
		this.queryJsonMap = queryJsonMap;
	}

	public Map<String, Object> getUpdateJsonMap() {
		return updateJsonMap;
	}

	public void setUpdateJsonMap(Map<String, Object> updateJsonMap) {
		this.updateJsonMap = updateJsonMap;
	}

	public Map<String, Object> getDeleteJsonMap() {
		return deleteJsonMap;
	}

	public void setDeleteJsonMap(Map<String, Object> deleteJsonMap) {
		this.deleteJsonMap = deleteJsonMap;
	}
	
}
