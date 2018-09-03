package com.a4tech.shipping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a4tech.dao.entity.ShippingEntity;
import com.a4tech.shipping.iservice.IShippingOrder;
import com.a4tech.shipping.ishippingDao.IshippingOrderDao;
import com.a4tech.shipping.model.ShippingDetails1;

@Service
public class ShippingOrderImpl implements IShippingOrder{
    
	@Autowired
	private IshippingOrderDao shippingOrderDao;
	@Override
	public List<ShippingDetails1> getAllShippingOrders() {
		List<ShippingEntity> shippingOrdersList = shippingOrderDao.getAllShippingOrders();
		List<ShippingDetails1> shippingOrderList = new ArrayList<>();
		ShippingDetails1 shippingDetails = null;
		for (ShippingEntity shippingEntity : shippingOrdersList) {
			shippingDetails = new ShippingDetails1();
			shippingDetails.setDelivery(shippingEntity.getDelivery());
			shippingDetails.setActual_delivery_qty(shippingEntity.getActual_delivery_qty());
			shippingDetails.setDeference_document(shippingEntity.getDeference_document());
			shippingDetails.setSold_to_party(shippingEntity.getSold_to_party());
			shippingDetails.setName_of_sold_to_party(shippingEntity.getName_of_sold_to_party());
			shippingDetails.setName_of_the_ship_to_party(shippingEntity.getName_of_the_ship_to_party());
			shippingDetails.setMaterial(shippingEntity.getMaterial());
			shippingDetails.setActual_delivery_qty(shippingEntity.getActual_delivery_qty());
			shippingDetails.setRoute_description(shippingEntity.getRoute_description());
			shippingDetails.setDistrict_name(shippingEntity.getDistrict_name());
			shippingDetails.setPlant(shippingEntity.getPlant());
			shippingDetails.setRoute(shippingEntity.getRoute());
			shippingDetails.setForwarding_agent_name(shippingEntity.getForwarding_agent_name());
			shippingEntity.setDistribution_channel(shippingEntity.getDistribution_channel());
			shippingDetails.setDeliv_date(shippingEntity.getDeliv_date());
			shippingDetails.setDelivery_type(shippingEntity.getDelivery_type());
			shippingDetails.setShipping_Point(shippingEntity.getShipping_Point());
			shippingDetails.setDistrict_code(shippingEntity.getDistrict_code());
			shippingDetails.setShip_to_party(shippingEntity.getShip_to_party());
			shippingDetails.setShip_to_long(shippingEntity.getShip_to_long());
			shippingDetails.setShip_to_latt(shippingEntity.getShip_to_latt());
			shippingOrderList.add(shippingDetails);
		}
		
		return shippingOrderList;
	}

}
