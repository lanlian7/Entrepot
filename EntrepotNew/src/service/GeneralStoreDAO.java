package service;

import java.util.List;

import entity.GeneralStore;

public interface GeneralStoreDAO {
	
	//查询
	public List<GeneralStore> queryAllGS();
	
	//根据id查询
	public GeneralStore queryGSById(long id);
	
	//添加
	public boolean addGS(GeneralStore GS);
	
	//修改
	public boolean updateGS(GeneralStore GS);
	
	//删除
	public boolean deleteGS(long id);
	
	//查询记录条数
	public long queryCount();
}
