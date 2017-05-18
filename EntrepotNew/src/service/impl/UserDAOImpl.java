package service.impl;

import java.util.List;

import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import db.MyHibernateSessionFactory;
import entity.Users;
import service.UserDAO;

public class UserDAOImpl implements UserDAO{

	@Override
	public boolean usersLogin(Users u) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		String hql=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.getTransaction();
			session.beginTransaction();
			hql=" from Users where username=? and password=? ";
			Query query=(Query) session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list=query.list();
	        tx.commit();
			if(list.size()>0){
				return true;
				//return true;
			}
			else{
				//return false;
				return false;
		
			}
		}
		catch (Exception e)
		{
		e.printStackTrace();
		tx.rollback();
		return false;
		//return false;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public boolean usersAdd(Users u) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.getTransaction();
			session.beginTransaction();
			session.save(u);
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
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public boolean usersDelete(Users u) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.getTransaction();
			session.beginTransaction();
			//session.get(User.class, u.getId());
			session.delete(u);
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

}
