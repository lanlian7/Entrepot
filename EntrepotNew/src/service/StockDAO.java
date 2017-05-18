package service;

import java.math.BigInteger;
import java.util.List;

import entity.Stock;

public interface StockDAO {
	  
	  //查询全部库存
	  public List<Stock> queryAllStock();
	  
	  //根据ID查询
	  public Stock queryStockById(long id);
	  
	  //查询部分库存
	  public List<Stock> querySomeStock(int limit,int offset,Stock stock);
	  
	  //查询所有资料
	  public List<Object> querySomeInfo(int limit,int offset,Stock stock);
	  
	  //查询所有资料
	  public List<Object> querySomeInfo();
	  
	  //查询库存小于X的库存信息
	  public List<Stock> queryStockByXX(long number);
	  
	  //根据料号查询
	  public Stock queryStockByMaterialNumber(String MaterialNumber);
	  //添加
	  public boolean insertStock(Stock stock);
	  
	  //修改
	  public boolean updateStock(Stock stock);
	  
	  
	  //删除
	  public boolean deleteStock(long id);
	  
	  public long queryCount();
	  
	  //连接查询数量
	  public BigInteger queryInfoCount();
}
