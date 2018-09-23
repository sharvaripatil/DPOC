package com.a4tech.shipping.shippingDaoImpl;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.a4tech.dao.entity.OrderGroupEntity;
import com.a4tech.dao.entity.ShippingEntity;
import com.a4tech.dao.entity.TruckDetailsEntity;
import com.a4tech.shipping.ishippingDao.IshippingOrderDao;


@Transactional
public class ShippingDao implements IshippingOrderDao{ 

	SessionFactory sessionFactory;
     private Logger _LOGGER = Logger.getLogger(ShippingDao.class);
	public void saveShippingEntity(ShippingEntity shippingEntityBean) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(shippingEntityBean);
			transaction.commit();
			_LOGGER.info("Order Details data has been saved successfully in db");
		} catch (Exception ex) {
			_LOGGER.error("unable to save data into DB: "+ex.getCause());
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
				}
			}
		}
	}
	@Override
	public List<ShippingEntity> getAllShippingOrders() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<ShippingEntity> shippingData = session.createCriteria(ShippingEntity.class).list();
			transaction.commit();
			return shippingData;
		} catch (Exception ex) {
			_LOGGER.error("unable to get shipping ordet data from DB: "+ex.getCause());
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
				}
			}
		}
		return new ArrayList<>();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ShippingEntity> getShippingDetailsByDate(String date) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(ShippingEntity.class);
			criteria.add(Restrictions.eq("deliv_date", date));
			List<ShippingEntity> shippingData = criteria.list();
			transaction.commit();
			return shippingData;
		} catch (Exception ex) {
			_LOGGER.error("unable to get shipping order data from DB based on date: "+ex.getCause());
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
				}
			}
		}
		return new ArrayList<>();
	}
	@Override
	public List<TruckDetailsEntity> getAllTruckInfo() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<TruckDetailsEntity> truckDetailsList = session.createCriteria(TruckDetailsEntity.class).list();
			transaction.commit();
			return truckDetailsList;
		} catch (Exception ex) {
			_LOGGER.error("unable to get Truck Details data from DB: "+ex.getCause());
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
				}
			}
		}
       return new ArrayList<>();
	}
	@Override
	public void saveOrderGroup(OrderGroupEntity orderGroupEntity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(orderGroupEntity);
			transaction.commit();
			_LOGGER.info("Order Details data has been saved successfully in db");
		} catch (Exception ex) {
			_LOGGER.error("unable to save orderGroup details into DB: "+ex.getCause());
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
				}
			}
		}		
	}
	@Override
	public List<OrderGroupEntity> getALLGroupOrders() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<OrderGroupEntity> orderGroupList = session.createCriteria(OrderGroupEntity.class).list();
			transaction.commit();
			return orderGroupList;
		} catch (Exception ex) {
			_LOGGER.error("unable to get orderGroupList Details data from DB: "+ex.getCause());
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
				}
			}
		}
       return new ArrayList<>();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderGroupEntity> getOrderGroupByDate(String date) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(OrderGroupEntity.class);
			criteria.add(Restrictions.eq("delivaryDate", date));
			List<OrderGroupEntity> ordGroupEntity = criteria.list();
			transaction.commit();
			return ordGroupEntity;
		} catch (Exception ex) {
			_LOGGER.error("unable to get shipping order data from DB based on date: "+ex.getCause());
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
				}
			}
		}
		return new ArrayList<>();
	}
	@Override
	public ShippingEntity getShippingDetails(String orderNo) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(ShippingEntity.class);
			criteria.add(Restrictions.eq("delivery", orderNo));
			ShippingEntity shippingDetails = (ShippingEntity) criteria.uniqueResult();
			transaction.commit();
			return shippingDetails;
		} catch (Exception ex) {
			_LOGGER.error("unable to get shipping order data from DB based on date: "+ex.getCause());
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
				}
			}
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getOrderNoByTruck(String truckNo) {
		
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(OrderGroupEntity.class);
			criteria.add(Restrictions.eq("truckNo", truckNo));
			Projection prop = Projections.property("delivaryNo");
			List<String> delivaryOrderNoList = criteria.setProjection(prop).list();
			transaction.commit();
			return delivaryOrderNoList;
		} catch (Exception ex) {
			_LOGGER.error("unable to get shipping order data from DB based on date: "+ex.getCause());
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception ex) {
				}
			}
		}
		return null;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}