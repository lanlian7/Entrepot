package service;

import java.util.Date;
import java.util.List;

import entity.Storage;

public interface StorageDAO {
    
    //查询所有入库信息
    public List<Storage> queryAllStorage();
    
    //根据limit+offset查询数据
    public List<Storage> querySomeStorage(int limit,int offset,Storage storage);
    
    //根据id查询
    public Storage queryStorageById(long id);
    
    //根据订单号查询
    public List<Storage> queryStorageByStorageID(String StorageID);
    
    //添加
    public boolean insertStorage(Storage storage);
    
    //修改
    public boolean updateStorage(Storage storage);
    
    //删除
    public boolean deleteStorage(long id);
    
    public long queryCount();
}
