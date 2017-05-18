package service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.OutGoing;
import entity.Storage;
import service.OutGoingDAO;

public class OutGoingDAOImpl implements OutGoingDAO{

	@Override
	public List<OutGoing> queryAllOutGoing() {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List<OutGoing> list=null;
		String hql="";
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from OutGoing";
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
	public OutGoing queryOutGoingById(long id) {
		Transaction tx=null;
		List<OutGoing> list=null;
		String hql="";
		OutGoing OG=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from OutGoing where id=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, id);
			list=query.list();
			OG=list.get(0);
			tx.commit();
			session.close();
			return OG;
		}
		catch (Exception e){
			e.printStackTrace();
			tx.rollback();
			return OG;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public List<OutGoing> queryOutGoingByOGID(String OGID) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List<OutGoing> list=null;
		String hql="";
		//OutGoing OG=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from OutGoing where OutGoingID=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, OGID);
			list=query.list();
			//OG=list.get(0);
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
	public boolean insertOutGoing(OutGoing outGoing) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		outGoing.setId(getNewId());
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.getTransaction();
			session.beginTransaction();
			session.save(outGoing);
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
		// TODO Auto-generated method stub
		Transaction tx=null;
		String hql="";
		long CId;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.getTransaction();
			session.beginTransaction();
			hql="select max(id) from OutGoing";
			Query query=session.createQuery(hql);
			if(query==null){
				CId=1;
			}
			else{
			CId=(long)query.uniqueResult()+1;
			}
			tx.commit();
			session.close();
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
	public boolean updateOutGoing(OutGoing outGoing) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.getTransaction();
			session.beginTransaction();
			session.update(outGoing);
			tx.commit();
			session.close();
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		finally{
			if(tx!=null)
			{
				tx=null;
			}
		}
	}

	@Override
	public boolean deleteOutGoing(long id) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.getTransaction();
			session.beginTransaction();
			OutGoing og=(OutGoing)session.get(OutGoing.class, id);
			session.delete(og);
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
	public List<OutGoing> querySomeOutGoing(int limit, int offset, OutGoing outgoing) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String sql = "";
		List<OutGoing> list = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			sql = "from OutGoing where 1=1 ";
            if(StringUtils.isNotEmpty(outgoing.getMaterial_Number())){
            	sql+=" and Material_Number='"+outgoing.getMaterial_Number()+"'";
            }
            if(outgoing.getOutDate()!=null){
            	sql+=" and OutDate= "+outgoing.getOutDate();
            }
            if(StringUtils.isNotEmpty(outgoing.getName())){
            	sql+=" and Name='"+outgoing.getName()+"'";
            }
            if(StringUtils.isNotEmpty(outgoing.getSpecification())){
            	sql+=" and Specification='"+outgoing.getSpecification()+"'";
            }
            if(StringUtils.isNotEmpty(outgoing.getPurpose())){
            	sql+=" and Putpose='"+outgoing.getPurpose()+"'";
            }
            if(StringUtils.isNotEmpty(outgoing.getMaterial_Department())){
            	sql+=" and Material_Department='"+outgoing.getMaterial_Department()+"'";
            }
            if(StringUtils.isNotEmpty(outgoing.getMaterial_Person())){
            	sql+=" and Material_Person='"+outgoing.getMaterial_Person()+"'";
            }
            System.out.println(sql);
			Query query = (Query) session.createQuery(sql);
			query.setFirstResult(limit);
			query.setMaxResults(offset);
			list = query.list();
			tx.commit();
			session.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return list;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public long queryCount() {
		// TODO Auto-generated method stub
		Transaction tx=null;
		String hql="";
		long CId;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.getTransaction();
			session.beginTransaction();
			hql="select count(*) from OutGoing";
			Query query=session.createQuery(hql);
			CId=(long)query.uniqueResult();
			tx.commit();
			session.close();
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
