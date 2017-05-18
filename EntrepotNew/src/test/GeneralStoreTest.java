package test;

import java.util.List;

import org.junit.Test;

import entity.GeneralStore;
import service.GeneralStoreDAO;
import service.impl.GeneralStoreDAOImpl;

public class GeneralStoreTest {
	
//  @Test
//  public void TestAddGeneralStore(){
//	  GeneralStore GS=new GeneralStore(6,"毛线","毛线");
//	  GeneralStoreDAO GSDAO = new GeneralStoreDAOImpl();
//	  boolean flag=GSDAO.addGS(GS);
//	  System.out.print(flag);
//	  
//  }
//  
//  @Test
//  public void TestReadGeneralStore(){
//	  GeneralStoreDAO gsDAO=new GeneralStoreDAOImpl();
//	  List<GeneralStore> list=gsDAO.queryAllGS();
//	  for(int i=0;i<list.size();i++){
//		  System.out.println(list.get(i).toString());
//	  }
//  }
//  
//  @Test
//  public void TestDeleteGeneralStore(){
//	  GeneralStoreDAO GSDAO=new GeneralStoreDAOImpl();
//	  boolean flag=GSDAO.deleteGS(6);
//	  System.out.println(flag);
//  }
	
	@Test
	public void TestUpdateGeneralStore(){
		GeneralStoreDAO GSDAO = new GeneralStoreDAOImpl();
		GeneralStore GS=new GeneralStore(7,"围巾","围巾");
	    boolean flag=GSDAO.updateGS(GS);
	    System.out.println(flag);
	}
}
