package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import entity.OutGoing;
import service.OutGoingDAO;
import service.impl.OutGoingDAOImpl;

public class OutGoingTest {
//   @Test
//   public void addOutGoing(){
//	   
//	   OutGoing outGoing=new OutGoing(2,"14240501A",new Date(),"LH2314A","原材料A","上海A",4000,"万A","原材料A","财务部A","芳妹");
//	   OutGoingDAO ogDAO=new OutGoingDAOImpl();
//	   boolean flag=ogDAO.insertOutGoing(outGoing);
//	   System.out.println(flag);
//	   
//   }
	
//	@Test
//	public void readAllOutGoing(){
//		List<OutGoing> list=null;
//		OutGoingDAO ogDAO=new OutGoingDAOImpl();
//		list=ogDAO.queryAllOutGoing();
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).toString());
//		}
//	}
	
	
	@Test
	public void TestquerySome(){
		OutGoingDAO ogDAO=new OutGoingDAOImpl();
		OutGoing out=new OutGoing();
		out.setMaterial_Number("2");
		List<OutGoing>	list=ogDAO.querySomeOutGoing(1, 3, out);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
	}
	
	
//	@Test
//	public void readOutGoingById(){
//		OutGoingDAO ogDAO=new OutGoingDAOImpl();
//		OutGoing og=ogDAO.queryOutGoingById(1);
//		System.out.println(og.toString());
//	}
	
//	@Test
//	public void readOutGoingByOther(){
//		OutGoingDAO ogDAO=new OutGoingDAOImpl();
//		List<OutGoing> list=ogDAO.queryOutGoingByData(new Date());
//		System.out.println("根据日期查询");
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).toString());
//		}
//		
//		List<OutGoing> list1=ogDAO.queryOutGoingByMaterialDepartment("财务部");
//		System.out.println("根据领料部门查询");
//		for(int i=0;i<list1.size();i++){
//			System.out.println(list1.get(i).toString());
//		}
//		
//		List<OutGoing> list2=ogDAO.queryOutGoingByMaterialPerson("芳妹");
//		System.out.println("根据领料人查询");
//		for(int i=0;i<list2.size();i++){
//			System.out.println(list2.get(i).toString());
//		}
//	}
	
//	@Test
//	public void updateOutGoingTest(){
//		OutGoingDAO ogDAO=new OutGoingDAOImpl();
//		OutGoing outGoing=new OutGoing(2,"14240501B",new Date(),"LH2314B","原材料B","上海B",4000,"万B","原材料B","财务部B","芳妹儿");
//	    boolean flag=ogDAO.updateOutGoing(outGoing);
//	    System.out.println(flag);
//	}
	
//	@Test
//	public void deleteOutGoingById(){
//		OutGoingDAO ogDAO=new OutGoingDAOImpl();
//		boolean flag=ogDAO.deleteOutGoing(1);
//		System.out.println(flag);
//	}
}
