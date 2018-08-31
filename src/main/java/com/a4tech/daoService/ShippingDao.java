package com.a4tech.daoService;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.a4tech.dao.entity.ShippingEntity;
import com.a4tech.shipping.model.ShippingDetails1;

public class ShippingDao { 

	SessionFactory sessionFactory;

	@SuppressWarnings("null")
	public void saveShippingEntity(ShippingEntity shippingEntityBean){

		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  ShippingDetails1 shippingExcelDetails=null;
		  
		  shippingExcelDetails.setDelivery(shippingEntityBean.getDelivery());
		  shippingExcelDetails.setDeference_document(shippingEntityBean.getDeference_document());

		  session.save(shippingEntityBean);
		  transaction.commit();
	
		  session.close();


}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}