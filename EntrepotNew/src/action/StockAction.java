package action;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.OutGoing;
import entity.Stock;
import service.OutGoingDAO;
import service.StockDAO;
import service.impl.OutGoingDAOImpl;
import service.impl.StockDAOImpl;

public class StockAction extends SuperAction{
	private static final long serialVersionUID = 1L;

	
	
	
	public StockAction() {
		super();
	}
	private Map<String, Object> alertJsonMap = new HashMap<String, Object>();
	private Map<String, Object> queryJsonMap = new HashMap<String, Object>();
	private Map<String,Object> addJsonMap=new HashMap<String,Object>();
	private Map<String,Object> updateJsonMap=new HashMap<String,Object>();
	private Map<String,Object> deleteJsonMap=new HashMap<String,Object>();
	
	private String rows = "10";
	private String page = "1";
	
	
	  private Map<String,Object> checkStoreJsonMap=new HashMap<String,Object>();
		
	   public String checkStore() throws IOException{
		    StockDAO dao=new StockDAOImpl();
		    List<Stock> list=dao.queryStockByXX(10);
		    //库存充足返回0
		    if(list==null){
		    	checkStoreJsonMap.put("code", 0);
		    }
		    //库存不足返回1
		    else{
		    	checkStoreJsonMap.put("code", 1);
		    }
			  return SUCCESS;
	   }
	
	public String alert() throws ParseException  {
		Integer page = Integer.valueOf(this.page);
		// 每页显示条数
		Integer rows = Integer.valueOf(this.rows);
		// 每页的开始记录 第一页为1 第二页为number +1
	    
	    int start = (page - 1) * rows;
	    StockDAO dao=new StockDAOImpl();
	    List<Stock> list=dao.queryStockByXX(10);
	    ArrayList list1=new ArrayList();
	    for(int i=0;i<list.size();i++){
	    	Map<String,Object> m=new HashMap<String,Object>();
            m.put("id", list.get(i).getId());
            m.put("Material_Number", list.get(i).getMaterial_Number());
            m.put("Name", list.get(i).getName());
            m.put("Specification", list.get(i).getSpecification());
            m.put("Number", list.get(i).getNumber());
            m.put("Unit", list.get(i).getUnit());
            m.put("UnitPrice", list.get(i).getUnitPrice());
            m.put("AmountMoney", list.get(i).getAmountMoney());
            list1.add(m);
	    }
	    alertJsonMap.put("total", dao.queryCount());
	    alertJsonMap.put("rows", list1);
		return SUCCESS;
	}
	
	
	public String query() throws ParseException  {
		Integer page = Integer.valueOf(this.page);
		// 每页显示条数
		Integer rows = Integer.valueOf(this.rows);
		// 每页的开始记录 第一页为1 第二页为number +1
	    Stock stock=new Stock();
	    stock.setMaterial_Number(request.getParameter("Material_Number"));
	    stock.setName(request.getParameter("Name"));
	    stock.setSpecification(request.getParameter("Specification"));
	    int start = (page - 1) * rows;
	    StockDAO dao=new StockDAOImpl();
	    List<Stock> list=dao.querySomeStock(start,rows,stock);
	    ArrayList list1=new ArrayList();
	    for(int i=0;i<list.size();i++){
	    	Map<String,Object> m=new HashMap<String,Object>();
            m.put("id", list.get(i).getId());
            m.put("Material_Number", list.get(i).getMaterial_Number());
            m.put("Name", list.get(i).getName());
            m.put("Specification", list.get(i).getSpecification());
            m.put("Number", list.get(i).getNumber());
            m.put("Unit", list.get(i).getUnit());
            m.put("UnitPrice", list.get(i).getUnitPrice());
            m.put("AmountMoney", list.get(i).getAmountMoney());
            list1.add(m);
	    }
		queryJsonMap.put("total", dao.queryCount());
		queryJsonMap.put("rows", list1);
		return SUCCESS;
	}


	
	public String delete() {
		StockDAO dao=new StockDAOImpl();
		long id =Long.parseLong(request.getParameter("id"));
		if(dao.deleteStock(id)){
			deleteJsonMap.put("code", 0);
		}
		else{
			deleteJsonMap.put("code", 1);
		}
		return SUCCESS;
	}

	public String add() throws ParseException {
	    Stock stock=new Stock();
	    stock.setAmountMoney(Double.parseDouble(request.getParameter("AmountMoney")));
	    stock.setId(Long.parseLong(request.getParameter("id")));
	    stock.setMaterial_Number(request.getParameter("Material_Number"));
	    stock.setName(request.getParameter("Name"));
	    stock.setNumber(Long.parseLong(request.getParameter("Number")));
	    stock.setSpecification(request.getParameter("Specification"));
	    stock.setUnit(request.getParameter("Unit"));
	    stock.setUnitPrice(Double.parseDouble(request.getParameter("UnitPrice")));
	    StockDAO dao=new StockDAOImpl();
		if (dao.insertStock(stock)){
			addJsonMap.put("code", 0);
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
		StockDAO dao=new StockDAOImpl();
		Stock stock=dao.queryStockById(id);
		session.setAttribute("stock", stock);
		return "success";
	}
	
	public String update() {
	    Stock stock=new Stock();
	    stock.setAmountMoney(Double.parseDouble(request.getParameter("AmountMoney")));
	    stock.setId(Long.parseLong(request.getParameter("id")));
	    stock.setMaterial_Number(request.getParameter("Material_Number"));
	    stock.setName(request.getParameter("Name"));
	    stock.setNumber(Long.parseLong(request.getParameter("Number")));
	    stock.setSpecification(request.getParameter("Specification"));
	    stock.setUnit(request.getParameter("Unit"));
	    stock.setUnitPrice(Double.parseDouble(request.getParameter("UnitPrice")));
	    StockDAO dao=new StockDAOImpl();
			if (dao.updateStock(stock)){
				updateJsonMap.put("code", 0);
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


	public Map<String, Object> getAlertJsonMap() {
		return alertJsonMap;
	}


	public void setAlertJsonMap(Map<String, Object> alertJsonMap) {
		this.alertJsonMap = alertJsonMap;
	}
	public Map<String, Object> getCheckStoreJsonMap() {
		return checkStoreJsonMap;
	}


	public void setCheckStoreJsonMap(Map<String, Object> checkStoreJsonMap) {
		this.checkStoreJsonMap = checkStoreJsonMap;
	}


}
