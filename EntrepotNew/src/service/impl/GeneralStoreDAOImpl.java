package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.GeneralStore;
import service.GeneralStoreDAO;

public class GeneralStoreDAOImpl  implements GeneralStoreDAO{

	@Override
	public List<GeneralStore> queryAllGS() {
		// TODO Auto-generated method stub
		Transaction tx=null;
		String hql="";
		List<GeneralStore> list=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
		    hql="from GeneralStore";
		    Query query=session.createQuery(hql);
		    list=query.list();
		    tx.commit();
		    session.close();
		    return list;
		}
		catch (Exception e){
			e.printStackTrace();
			tx.rollback();
			return list;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public GeneralStore queryGSById(long id) {
		Transaction tx=null;
		String hql="";
		GeneralStore gs=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
		    hql="from GeneralStore where id=?";
		    Query query=session.createQuery(hql);
		    query.setParameter(0, id);
		    List<GeneralStore> list=query.list();
		    gs=list.get(0);
		    tx.commit();
		    session.close();
		    return gs;
		}
		catch (Exception e){
			e.printStackTrace();
			tx.rollback();
			return gs;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public boolean addGS(GeneralStore GS) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Transaction tx=null;
		GS.setId(getNewId());
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.getTransaction();
			session.beginTransaction();
			session.save(GS);
			tx.commit();
			session.close();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	private long getNewId() {
		Transaction tx=null;
		String hql="";
		long CId;
		try{
            //先查到对象再删除
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx=session.getTransaction();
            session.beginTransaction();
            hql="select max(id) from GeneralStore";
            Query query=session.createQuery(hql);
            CId=(long)query.uniqueResult()+1;
			tx.commit();
			return CId;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return 0;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public boolean updateGS(GeneralStore GS) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.getTransaction();
			session.beginTransaction();
			session.update(GS);
			tx.commit();
			session.close();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public boolean deleteGS(long id) {
		Transaction tx=null;
		try{
            //先查到对象再删除
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx=session.getTransaction();
            session.beginTransaction();
            GeneralStore C=(GeneralStore)session.get(GeneralStore.class,id);
            session.delete(C);
			tx.commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public long queryCount() {
		Transaction tx=null;
		String hql="";
		long CId;
		try{
            //先查到对象再删除
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx=session.getTransaction();
            session.beginTransaction();
            hql="select count(*) from GeneralStore";
            Query query=session.createQuery(hql);
            CId=(long)query.uniqueResult();
			tx.commit();
			return CId;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return 0;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	
}
