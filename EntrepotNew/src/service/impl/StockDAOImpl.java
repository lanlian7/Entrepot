package service.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.OutGoing;
import entity.Stock;
import service.StockDAO;

public class StockDAOImpl implements StockDAO {

	@Override
	public List<Stock> queryAllStock() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		List<Stock> list = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			hql = "from Stock";
			Query query = session.createQuery(hql);
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
	public Stock queryStockById(long id) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		Stock Stock = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			hql = "from Stock where id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			List<Stock> list = query.list();
			Stock = list.get(0);
			tx.commit();
			session.close();
			return Stock;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return Stock;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean insertStock(Stock Stock) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Stock.setId(getNewId());
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			session.save(Stock);
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
			// 先查到对象再删除
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			hql = "select max(id) from Stock";
			Query query = session.createQuery(hql);
			CId = (long) query.uniqueResult() + 1;
			tx.commit();
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
	public boolean updateStock(Stock Stock) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			session.update(Stock);
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
	public boolean deleteStock(long id) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			Stock Stock = (Stock) session.get(Stock.class, id);
			session.delete(Stock);
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
	public List<Stock> querySomeStock(int limit, int offset, Stock Stock) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String sql = "";
		List<Stock> list = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			sql = "from Stock where 1=1 ";
			if (StringUtils.isNotEmpty(Stock.getMaterial_Number())) {
				sql += " and Material_Number='" + Stock.getMaterial_Number() + "'";
			}
			if (StringUtils.isNotEmpty(Stock.getName())) {
				sql += " and Name='" + Stock.getName() + "'";
			}
			if (StringUtils.isNotEmpty(Stock.getSpecification())) {
				sql += " and Specification='" + Stock.getSpecification() + "'";
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
	public long queryCount() {
		Transaction tx = null;
		String hql = "";
		long CId;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			hql = "select count(*) from Stock";
			Query query = session.createQuery(hql);
			CId = (long) query.uniqueResult();
			tx.commit();
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
	public Stock queryStockByMaterialNumber(String MaterialNumber) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		Stock Stock = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			hql = "from Stock where Material_Number=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, MaterialNumber);
			List<Stock> list = query.list();
			
			if(list.size()>0){
			Stock = list.get(0);
			}
			tx.commit();
			session.close();
			return Stock;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return Stock;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
}

	@Override
	public List<Object> querySomeInfo(int limit, int offset, Stock Stock) {
		Transaction tx = null;
		String sql = "";
		List<Object> list = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			sql = "select Stock.Material_Number,Stock.Name,Stock.Specification,Stock.number as number,"
					+ "Stock.Unit,Stock.UnitPrice,Storage.Warehouse_Date,Storage.Number as StorageNumber,Storage.WarehousePerson,"
					+ "OutGoing.OutDate,OutGoing.Number as OutGoingNumber,OutGoing.Purpose,OutGoing.Material_Department,"
					+ "OutGoing.Material_Person,Storage.Position_selection from Storage,Stock,OutGoing "
					+ "where Stock.Material_Number=Storage.Material_Number and Stock.Material_Number=OutGoing.Material_Number and 1=1 ";
			if (Stock!= null) {
				if (StringUtils.isNotEmpty(Stock.getMaterial_Number())) {
					sql += " and Stock.Material_Number='" + Stock.getMaterial_Number() + "'";
				}
				if (StringUtils.isNotEmpty(Stock.getName())) {
					sql += " and Stock.Name='" + Stock.getName() + "'";
				}
				if (StringUtils.isNotEmpty(Stock.getSpecification())) {
					sql += " and Stock.Specification='" + Stock.getSpecification() + "'";
				}
			}
			System.out.println(sql);
			Query query = (Query) session.createSQLQuery(sql);
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
	public BigInteger queryInfoCount() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		BigInteger CId;
		try {
			// 先查到对象再删除
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			hql = "select count(*) from Storage,Stock,OutGoing "
					+ "where Stock.Material_Number=Storage.Material_Number and Stock.Material_Number=OutGoing.Material_Number and 1=1 ";
			Query query = session.createSQLQuery(hql);
			CId = (BigInteger) query.uniqueResult();
			tx.commit();
			return CId;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public List<Object> querySomeInfo() {
		Transaction tx = null;
		String sql = "";
		List<Object> list = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			sql = "select Stock.Material_Number,Stock.Name,Stock.Specification,Stock.number as number,"
					+ "Stock.Unit,Stock.UnitPrice,Storage.Warehouse_Date,Storage.Number as StorageNumber,Storage.WarehousePerson,"
					+ "OutGoing.OutDate,OutGoing.Number as OutGoingNumber,OutGoing.Purpose,OutGoing.Material_Department,"
					+ "OutGoing.Material_Person,Storage.Position_selection from Storage,Stock,OutGoing "
					+ "where Stock.Material_Number=Storage.Material_Number and Stock.Material_Number=OutGoing.Material_Number and 1=1 ";
			Query query = (Query) session.createSQLQuery(sql);
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
	public List<Stock> queryStockByXX(long number) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		List<Stock> list = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.getTransaction();
			session.beginTransaction();
			hql = "from Stock where number<? ";
			Query query = session.createQuery(hql);
			query.setParameter(0, number);
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

}
