package test;

import java.util.List;

import org.junit.Test;

import entity.Stock;
import service.StockDAO;
import service.impl.StockDAOImpl;

public class StockTest {
	
//   @Test
//   public void addStockTest(){
//	   StockDAO stockDAO=new StockDAOImpl();
//	   Stock stock = new Stock(1,"RH022323","毛巾","GG0349094",32400,"万",25,34);
//	   boolean flag=stockDAO.insertStock(stock);
//	   System.out.println(flag);
//   }
	
	
   @Test
   public void readAddStock(){
	   StockDAO stockDAO=new StockDAOImpl();
	   List<Stock> list=stockDAO.queryAllStock();
	   for(int i=0;i<list.size();i++){
		   System.out.println(list.get(i).toString());
	   }
   }
//	
//	@Test
//	public void updateStockTest(){
//		StockDAO stockDAO=new StockDAOImpl();
//		Stock stock = new Stock(1,"RH022323A","毛巾A","GG0349094A",32400565,"万A",25888,34);
//	    boolean flag=stockDAO.updateStock(stock);
//	    System.out.println(flag);
//	}
	
//	@Test
//	public void readStockById(){
//		StockDAO stockDAO=new StockDAOImpl();
//		Stock stock=stockDAO.queryStockById(1);
//		System.out.println(stock.toString());
//	}
//	
//	@Test
//	public void readStockByOther(){
//		StockDAO stockDAO=new StockDAOImpl();
////		List<Stock> list=stockDAO.queryStockByMaterialNumber("Rh022323A");
////		for(int i=0;i<list.size();i++){
////			System.out.println(list.get(i).toString());
////		}
//		
//		List<Stock> list1=stockDAO.queryStockByName("毛巾A");
//		for(int i=0;i<list1.size();i++){
//			System.out.println(list1.get(i).toString());
//		}
//	}
   @Test
   public void TestquerySomeInfo(){
	   StockDAO dao=new StockDAOImpl();
	   Stock stock=new Stock();
	   List<Object> list=dao.querySomeInfo(1, 1,stock);
	   if(list==null){
		   System.out.println("null");
	   }
	   for(int i=0;i<list.size();i++){
		   Object[] object=(Object[]) list.get(i);
		   for(int j=0;j<object.length;j++){
				  System.out.println(object[j]);
		   }

	   }
   }
}
