package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.OutGoing;
import entity.Stock;
import service.OutGoingDAO;
import service.StockDAO;
import service.impl.OutGoingDAOImpl;
import service.impl.StockDAOImpl;

public class OutGoingAction extends SuperAction{
	private static final long serialVersionUID = 1L;

	public OutGoingAction() {
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
		OutGoing outGoing=new OutGoing();
		outGoing.setMaterial_Department(request.getParameter("Material_Department"));
		outGoing.setMaterial_Number(request.getParameter("Material_Number"));
		outGoing.setMaterial_Person(request.getParameter("Material_Person"));
		outGoing.setName(request.getParameter("Name"));
	    outGoing.setOutGoingID(request.getParameter("OutGoingID"));
	    outGoing.setPurpose(request.getParameter("Purpose"));
	    outGoing.setSpecification(request.getParameter("Specification"));
	    outGoing.setUnit(request.getParameter("Unit"));
	    String date=request.getParameter("OutDate");
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
	    java.util.Date realDate=null;
	    if(date!=""&&date!=null){
	    	try{
	    		realDate=sdf.parse(date);
	    	}
	    	catch (Exception e){
	    		e.printStackTrace();
	    	}
	    }
	    outGoing.setOutDate(realDate);
	    OutGoingDAO dao=new OutGoingDAOImpl();
	    int start = (page - 1) * rows;
	    List<OutGoing> list=dao.querySomeOutGoing(start,rows,outGoing);
	    ArrayList list1=new ArrayList();
	    for(int i=0;i<list.size();i++){
	    	Map<String,Object> m=new HashMap<String,Object>();
	    	m.put("id", list.get(i).getId());
	    	m.put("OutDate", list.get(i).getOutDate());
            m.put("OutGoingID", list.get(i).getOutGoingID());
            m.put("Material_Number", list.get(i).getMaterial_Number());
            m.put("Name", list.get(i).getName());
            m.put("Specification", list.get(i).getSpecification());
            m.put("Number", list.get(i).getNumber());
            m.put("Unit", list.get(i).getUnit());
            m.put("Purpose", list.get(i).getPurpose());
            m.put("Material_Department", list.get(i).getMaterial_Department());
            m.put("Material_Person", list.get(i).getMaterial_Person());
            list1.add(m);
	    }
		queryJsonMap.put("total", dao.queryCount());
		queryJsonMap.put("rows", list1);
		return SUCCESS;
	}

	public String delete() {
		OutGoingDAO dao=new OutGoingDAOImpl();
		long id =Long.parseLong(request.getParameter("id"));
		if(dao.deleteOutGoing(id)){
			deleteJsonMap.put("code", 0);
		}
		else{
			deleteJsonMap.put("code", 1);
		}
		OutGoing outGoing=dao.queryOutGoingById(id);
		StockDAO dao1=new StockDAOImpl();
		Stock stock=dao1.queryStockByMaterialNumber(outGoing.getMaterial_Number());
		stock.setNumber(outGoing.getNumber()+stock.getNumber());
		dao1.updateStock(stock);
		return SUCCESS;
	}

	public String add() throws ParseException {
		OutGoing outGoing=new OutGoing();
		outGoing.setId(Long.parseLong(request.getParameter("id")));
		outGoing.setMaterial_Department(request.getParameter("Material_Department"));
		outGoing.setMaterial_Number(request.getParameter("Material_Number"));
		outGoing.setMaterial_Person(request.getParameter("Material_Person"));
		outGoing.setName(request.getParameter("Name"));
		outGoing.setNumber(Long.parseLong(request.getParameter("Number")));
	    outGoing.setOutGoingID(request.getParameter("OutGoingID"));
	    outGoing.setPurpose(request.getParameter("Purpose"));
	    outGoing.setSpecification(request.getParameter("Specification"));
	    outGoing.setUnit(request.getParameter("Unit"));
	    String date=request.getParameter("OutDate");
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
	    java.util.Date realDate=null;
	    if(date!=""&&date!=null){
	    	try{
	    		realDate=sdf.parse(date);
	    	}
	    	catch (Exception e){
	    		e.printStackTrace();
	    	}
	    }
	    outGoing.setOutDate(realDate);
	    OutGoingDAO dao=new OutGoingDAOImpl();
		StockDAO dao1=new StockDAOImpl();
		Stock stock=dao1.queryStockByMaterialNumber(outGoing.getMaterial_Number());
		if(stock.getNumber()<outGoing.getNumber()||stock==null){
			addJsonMap.put("code", 2);
		}
		else{
	     	if (dao.insertOutGoing(outGoing)){
			addJsonMap.put("code", 0);
			stock.setNumber(stock.getNumber()-outGoing.getNumber());
			dao1.updateStock(stock);
	       	}
	      	else{
			 addJsonMap.put("code",1);
	    	}
		

		}
		return SUCCESS;
	}

	public String toAdd(){
		return "success";
	}
	
	public String toUpdate(){
		long id=Long.parseLong(request.getParameter("id"));
		OutGoingDAO dao=new OutGoingDAOImpl();
		OutGoing outgoing=dao.queryOutGoingById(id);
		session.setAttribute("outgoing", outgoing);
		return "success";
	}
	
	public String update() {
		OutGoing outGoing=new OutGoing();
		outGoing.setId(Long.parseLong(request.getParameter("id")));
		outGoing.setMaterial_Department(request.getParameter("Material_Department"));
		outGoing.setMaterial_Number(request.getParameter("Material_Number"));
		outGoing.setMaterial_Person(request.getParameter("Material_Person"));
		outGoing.setName(request.getParameter("Name"));
		outGoing.setNumber(Long.parseLong(request.getParameter("Number")));
	    outGoing.setOutGoingID(request.getParameter("OutGoingID"));
	    outGoing.setPurpose(request.getParameter("Purpose"));
	    outGoing.setSpecification(request.getParameter("Specification"));
	    outGoing.setUnit(request.getParameter("Unit"));
	    String date=request.getParameter("OutDate");
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
	    java.util.Date realDate=null;
	    if(date!=""&&date!=null){
	    	try{
	    		realDate=sdf.parse(date);
	    	}
	    	catch (Exception e){
	    		e.printStackTrace();
	    	}
	    }
	    outGoing.setOutDate(realDate);
	    OutGoingDAO dao=new OutGoingDAOImpl();
		StockDAO dao1=new StockDAOImpl();
		Stock stock=dao1.queryStockByMaterialNumber(outGoing.getMaterial_Number());
		OutGoing oldOutGoing=(OutGoing)session.getAttribute("outgoing");
		if(stock.getNumber()<outGoing.getNumber()||stock==null){
			updateJsonMap.put("code", 2);
		}
		else{
			if (dao.updateOutGoing(outGoing)){
				updateJsonMap.put("code", 0);
				if(oldOutGoing.getNumber()>outGoing.getNumber()){
					stock.setNumber(stock.getNumber()+(oldOutGoing.getNumber()-outGoing.getNumber()));
				}
				else{
					stock.setNumber(stock.getNumber()-outGoing.getNumber()+oldOutGoing.getNumber());
				}
				dao1.updateStock(stock);
			}
			else{
				updateJsonMap.put("code",1);
			}
			
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
