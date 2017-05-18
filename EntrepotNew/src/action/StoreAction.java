package action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.GeneralStore;
import entity.Storage;
import service.GeneralStoreDAO;
import service.StorageDAO;
import service.impl.GeneralStoreDAOImpl;
import service.impl.StorageDAOImpl;

public class StoreAction extends SuperAction {
	private static final long serialVersionUID = 1L;

	public StoreAction() {
		super();
	}

	private Map<String, Object> queryJsonMap = new HashMap<String, Object>();
	private Map<String, Object> addJsonMap = new HashMap<String, Object>();
	private Map<String, Object> updateJsonMap = new HashMap<String, Object>();
	private Map<String, Object> deleteJsonMap = new HashMap<String, Object>();

	private String rows = "10";
	private String page = "1";

	public String query() throws ParseException {
		Integer page = Integer.valueOf(this.page);
		// 每页显示条数
		Integer rows = Integer.valueOf(this.rows);
		// 每页的开始记录 第一页为1 第二页为number +1
		GeneralStore generalStore = new GeneralStore();
		generalStore.setDescription(request.getParameter("Description"));
		generalStore.setName(request.getParameter("Name"));
	//	generalStore.setId(Long.parseLong(request.getParameter("id")));

		GeneralStoreDAO dao = new GeneralStoreDAOImpl();
		List<GeneralStore> list = dao.queryAllGS();
		ArrayList list1=new ArrayList();
		for(int i=0;i<list.size();i++){
			Map<String,Object> m=new HashMap<String,Object>();
			m.put("id", list.get(i).getId());
			m.put("Name", list.get(i).getName());
			m.put("Description", list.get(i).getDescription());
			list1.add(m);
		}
		queryJsonMap.put("total", dao.queryCount());
		queryJsonMap.put("rows", list1);
		return SUCCESS;
	}

	public String delete() {
		GeneralStoreDAO dao = new GeneralStoreDAOImpl();
		long id = Long.parseLong(request.getParameter("id"));
		if (dao.deleteGS(id)) {
			deleteJsonMap.put("code", 0);
		} else {
			deleteJsonMap.put("code", 1);
		}
		return SUCCESS;
	}

	public String add() {
		GeneralStore generalStore = new GeneralStore();
		generalStore.setDescription(request.getParameter("Description"));
		generalStore.setName(request.getParameter("Name"));
		generalStore.setId(Long.parseLong(request.getParameter("id")));
		GeneralStoreDAO dao = new GeneralStoreDAOImpl();
		if (dao.addGS(generalStore)) {
			addJsonMap.put("code", 0);
		} else {
			addJsonMap.put("code", 1);
		}
		return SUCCESS;
	}

	public String toAdd() {
		return "success";
	}

	public String toUpdate() {
		long id = Long.parseLong(request.getParameter("id"));
		GeneralStoreDAO dao = new GeneralStoreDAOImpl();
		GeneralStore store = dao.queryGSById(id);
		session.setAttribute("store", store);
		return "success";
	}

	public String update() {
		GeneralStore generalStore = new GeneralStore();
		generalStore.setDescription(request.getParameter("Description"));
		generalStore.setName(request.getParameter("Name"));
		generalStore.setId(Long.parseLong(request.getParameter("id")));
		GeneralStoreDAO dao = new GeneralStoreDAOImpl();
		if (dao.updateGS(generalStore)) {
			updateJsonMap.put("code", 0);
		} else {
			updateJsonMap.put("code", 1);
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
