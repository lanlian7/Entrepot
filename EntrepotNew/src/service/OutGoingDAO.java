package service;

import java.util.Date;
import java.util.List;

import entity.OutGoing;

public interface OutGoingDAO {
    //查询
	public List<OutGoing> queryAllOutGoing();
    
	//根据id查询
    public OutGoing queryOutGoingById(long id);
    
    //查询部分出库单
    public List<OutGoing> querySomeOutGoing(int limit,int offset,OutGoing outgoing);
    
    //根据单号查询
    public List<OutGoing> queryOutGoingByOGID(String OGID);
   
    
    //添加
    public boolean insertOutGoing(OutGoing outGoing);
    
    //修改
    public boolean updateOutGoing(OutGoing outGoing);
    
    //删除
    public boolean deleteOutGoing(long id);
    
    //查询记录条数
    public long queryCount();
}
