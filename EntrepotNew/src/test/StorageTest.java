package test;

import java.util.List;

import org.junit.Test;

import entity.Storage;
import service.StorageDAO;
import service.impl.StorageDAOImpl;

public class StorageTest {
//   @Test
//   public void ReadAllStorageTest(){
//		StorageDAO storageDao=new StorageDAOImpl();
//		List<Storage> list=storageDao.queryAllStorage();
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).toString());
//		}
//   }
   
//   @Test
//   public void insertStorageTeset(){
//		StorageDAO storageDao=new StorageDAOImpl();
//		Storage storage=new Storage();
//		storage.setAmount_money(342);
//		storage.setId(1);
//		storage.setMaterial_Number("34234");
//		storage.setName("苏州");
//		storage.setNumber(343);
//		storage.setPosition_selection("1");
//		storage.setWarehousePerson("芳姐");
//	    storageDao.insertStorage(storage);
//   }
	
	@Test
	public void querySomeTest(){
		StorageDAO storageDao=new StorageDAOImpl();
		Storage storage=new Storage();
		storage.setStorageID("3");
		
		List<Storage> list=storageDao.querySomeStorage(1,5,storage);
		for(int i=0;i<list.size();i++){
		System.out.println("some"+list.get(i).toString());
	}
	}
}
