package test;

import java.util.EnumSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

public class testEntrepot {
	   @Test
	   public void testSchemaExport(){
		   //创建内置对象
		   Configuration config=new Configuration().configure();
		  //创建服务器注册对象
		   ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();  
		   Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();  

	       //创建sessionFactory
		   SessionFactory sessionfactory=config.buildSessionFactory(serviceRegistry);
		   
		   //创建session对象
		   Session session = sessionfactory.getCurrentSession();
		   //创建SchemaExport对象
		   SchemaExport export=new SchemaExport();
		   export.create(EnumSet.of(TargetType.DATABASE), metadata); 
		   //export.create(true, true);
}
}