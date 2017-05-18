package service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import db.MyHibernateSessionFactory;
import entity.Storage;
import service.StorageDAO;

public class StorageDAOImpl implements StorageDAO {

	@Override
	public List<Storage> querySomeStorage(int limit, int offset, Storage storage) {	
		// TODO Auto-generated method stub
		Transaction tx = null;
		String sql = "";
		List<Storage> list = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			sql = "from Storage where 1=1 ";
			if (StringUtils.isNotEmpty(storage.getName())) {
				sql += " and Name='" + storage.getName() + "'";
			}
			if (StringUtils.isNotEmpty(storage.getStorageID())) {
				sql += " and storageID='" + storage.getStorageID() + "'";
			}
			if(storage.getWarehouse_Date()!=null){
				sql += " and Warehouse_Date=" + storage.getWarehouse_Date();
			}
			if (StringUtils.isNotEmpty(storage.getMaterial_Number())) {
				sql += " and Material_Number='" + storage.getMaterial_Number() + "'";
			}
			if (StringUtils.isNotEmpty(storage.getSpecifications())) {
				sql += " and Specifications='" + storage.getSpecifications() + "'";
			}
			if (StringUtils.isNotEmpty(storage.getWarehousePerson())) {
				sql += " and WarehousePerson='" + storage.getWarehousePerson() + "'";
			}
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
	public List<Storage> queryAllStorage() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		List<Storage> list = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			hql = "from Storage";
			Query query = (Query) session.createQuery(hql);
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
	public Storage queryStorageById(long id) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Storage> list = null;
		String hql = "";
		Storage storage = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Storage where id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			list = query.list();
			storage = list.get(0);
			tx.commit();
			session.close();
			return storage;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return storage;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public List<Storage> queryStorageByStorageID(String StorageID) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Storage> list = null;
		String hql = "";
		Storage OG = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Storage where StorageID=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, StorageID);
			list = query.list();
			OG = list.get(0);
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
	public boolean insertStorage(Storage storage) {
		Transaction tx = null;
		storage.setId(getNewId());
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			session.save(storage);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	private long getNewId() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		long CId;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			hql = "select max(id) from Storage";
			Query query = session.createQuery(hql);
			CId = (long) query.uniqueResult() + 1;
			tx.commit();
			session.close();
			return CId;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return 0;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean updateStorage(Storage storage) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			session.update(storage);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean deleteStorage(long id) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			Storage storage = (Storage)session.get(Storage.class, id);
			session.delete(storage);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public long queryCount() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		long CId;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			hql = "select count(*) from Storage";
			Query query = session.createQuery(hql);
			CId = (long) query.uniqueResult();
			tx.commit();
			session.close();
			return CId;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return 0;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

}
