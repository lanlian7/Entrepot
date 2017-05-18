package action;

import java.text.SimpleDateFormat;
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

public class InWarehouseAction extends SuperAction{
	private static final long serialVersionUID = 1L;

	public InWarehouseAction() {
		super();
	}

	private Map<String, Object> queryJsonMap = new HashMap<String, Object>();	
	private String rows = "10";
	private String page = "1";

	public String query(){
		Integer page = Integer.valueOf(this.page);
		// 每页显示条数
		Integer rows = Integer.valueOf(this.rows);
		// 每页的开始记录 第一页为1 第二页为number +1
	    Stock stock=new Stock();
	    stock.setMaterial_Number(request.getParameter("Material_Number"));
	    stock.setName(request.getParameter("Name"));
	    stock.setSpecification(request.getParameter("Specification"));
	    StockDAO dao=new StockDAOImpl();
	    int start = (page - 1) * rows;
	    List<Object> list=dao.querySomeInfo(start,rows,stock);
	    ArrayList list1=new ArrayList();
	    for(int i=0;i<list.size();i++){
	    	Object[] object=(Object[]) list.get(i);
	    	Map<String,Object> m=new HashMap<String,Object>();
            m.put("Material_Number", object[0]);
            m.put("Name", object[1]);
            m.put("Specification", object[2]);
            m.put("Number", object[3]);
            m.put("Unit", object[4]);
            m.put("UnitPrice", object[5]);
            m.put("Warehouse_Date", object[6]);
            m.put("Number1", object[7]);
            m.put("WarehousePerson", object[8]);
            m.put("OutDate", object[9]);
            m.put("Number2", object[10]);
            m.put("Purpose", object[11]);
            m.put("Material_Department", object[12]);
            m.put("Material_Person", object[13]);
            m.put("Position_select", object[14]);
            list1.add(m);
	    }
		queryJsonMap.put("total",dao.queryInfoCount());
		queryJsonMap.put("rows", list1);
		return SUCCESS;
	}
	public Map<String, Object> getQueryJsonMap() {
		return queryJsonMap;
	}
	public void setQueryJsonMap(Map<String, Object> queryJsonMap) {
		this.queryJsonMap = queryJsonMap;
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
	
}
