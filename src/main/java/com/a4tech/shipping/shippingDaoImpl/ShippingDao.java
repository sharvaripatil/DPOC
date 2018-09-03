package com.a4tech.shipping.shippingDaoImpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.a4tech.dao.entity.ShippingEntity;
import com.a4tech.shipping.ishippingDao.IshippingOrderDao;

@Transactional
public class ShippingDao implements IshippingOrderDao{ 

	SessionFactory sessionFactory;

	public void saveShippingEntity(ShippingEntity shippingEntityBean) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(shippingEntityBean);
			transaction.commit();
		} catch (Exception ex) {
			System.out.println("unable to save data into DB: "+ex.getCause());
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
			System.out.println("unable to get shipping ordet data from DB: "+ex.getCause());
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