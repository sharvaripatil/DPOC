package com.a4tech.shipping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a4tech.dao.entity.OrderGroupEntity;
import com.a4tech.dao.entity.ShippingEntity;
import com.a4tech.dao.entity.TruckDetailsEntity;
import com.a4tech.shipping.iservice.IShippingOrder;
import com.a4tech.shipping.ishippingDao.IshippingOrderDao;
import com.a4tech.shipping.model.OrderGroup;
import com.a4tech.shipping.model.ShippingDetails1;
import com.a4tech.shipping.model.TruckDetails;

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
			shippingDetails.setDistribution_channel(shippingEntity.getDistribution_channel());
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
	@Override
	public List<ShippingDetails1> getShippingDetailsByDate(String date) {
		List<ShippingEntity> shippingOrdersList = shippingOrderDao.getShippingDetailsByDate(date);
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
			shippingDetails.setDistribution_channel(shippingEntity.getDistribution_channel());
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
	@Override
	public List<TruckDetails> getAllTruckInfo() {
	List<TruckDetailsEntity> truckDetailsEntity =	shippingOrderDao.getAllTruckInfo();
	 List<TruckDetails> truckDetailsList = new ArrayList<>();
	 TruckDetails truckDetailObj = null;
	 for (TruckDetailsEntity truckDtlsEntity : truckDetailsEntity) {
		 truckDetailObj = new TruckDetails();
		 truckDetailObj.setDelay(truckDtlsEntity.getDelay());
		 truckDetailObj.setDoNo(truckDtlsEntity.getDoNo());
		 truckDetailObj.setEntryType(truckDtlsEntity.getEntryType());
		 //truckDetailObj.setRefTruckVendorId(truckDtlsEntity.getRefTruckVendorId());
		 truckDetailObj.setSlNo(truckDtlsEntity.getSlNo());
		 truckDetailObj.setVehicleType(truckDtlsEntity.getVehicleType());
		 truckDetailObj.setVehiclNo(truckDtlsEntity.getVehiclNo());
		 truckDetailObj.setWheels(truckDtlsEntity.getWheels());
		 truckDetailObj.setTaggedDate(truckDtlsEntity.getTaggedDate());
		 truckDetailObj.setTaggedTime(truckDtlsEntity.getTaggedTime());
		 truckDetailObj.setTaggedTranspoter(truckDtlsEntity.getTaggedTranspoter());
		 truckDetailsList.add(truckDetailObj);
	}
		return truckDetailsList;
	}
	@Override
	public void saveOrderGroup(OrderGroup orderGroup) {
	  OrderGroupEntity ordGrpEntity = new OrderGroupEntity();
	  ordGrpEntity.setDelivaryDate(orderGroup.getDelivaryDate());
	  ordGrpEntity.setDelivaryNo(orderGroup.getDelivaryNo());
	  ordGrpEntity.setOriginalOrderQty(orderGroup.getOriginalOrderQty());
	  ordGrpEntity.setTruckCapacity(orderGroup.getTruckCapacity());
	  ordGrpEntity.setTruckNo(orderGroup.getTruckNo());
	  ordGrpEntity.setTruckOrderQty(String.valueOf(orderGroup.getTruckOrderQty()));
	  ordGrpEntity.setMaterialName(orderGroup.getMaterialType());
	  ordGrpEntity.setDistrictName(orderGroup.getDistrictName());
	  ordGrpEntity.setLatitude(orderGroup.getLatitude());
	  ordGrpEntity.setLongitude(orderGroup.getLongitude());
	  shippingOrderDao.saveOrderGroup(ordGrpEntity);
	}
	@Override
	public List<OrderGroup> getAllGroupOrderList() {
     List<OrderGroupEntity> orderGroupEntityList = shippingOrderDao.getALLGroupOrders();
     List<OrderGroup> orderGroupList = new ArrayList<>();
     OrderGroup orderGroup = null;
     for (OrderGroupEntity ordGrpEntity : orderGroupEntityList) {
    	 orderGroup = new OrderGroup();
    	 orderGroup.setDelivaryNo(ordGrpEntity.getDelivaryNo());
    	 orderGroup.setDelivaryDate(ordGrpEntity.getDelivaryDate());
    	 orderGroup.setOriginalOrderQty(ordGrpEntity.getOriginalOrderQty());
    	 orderGroup.setTruckNo(ordGrpEntity.getTruckNo());
    	 orderGroup.setTruckCapacity(ordGrpEntity.getTruckCapacity());
    	 orderGroup.setTruckOrderQty(Integer.parseInt(ordGrpEntity.getTruckOrderQty()));
    	 orderGroup.setMaterialType(ordGrpEntity.getMaterialName());
    	 orderGroup.setDistrictName(ordGrpEntity.getDistrictName());
    	 orderGroup.setLatitude(ordGrpEntity.getLatitude());
    	 orderGroup.setLongitude(ordGrpEntity.getLongitude());
    	 orderGroupList.add(orderGroup);
	}
		return orderGroupList;
	}
	@Override
	public List<OrderGroup> getOrderGroupByDate(String date) {
		 List<OrderGroupEntity> orderGroupEntityList = shippingOrderDao.getOrderGroupByDate(date);
		 List<OrderGroup> orderGroupList = new ArrayList<>();
	     OrderGroup orderGroup = null;
	     for (OrderGroupEntity ordGrpEntity : orderGroupEntityList) {
	    	 orderGroup = new OrderGroup();
	    	 orderGroup.setDelivaryNo(ordGrpEntity.getDelivaryNo());
	    	 orderGroup.setDelivaryDate(ordGrpEntity.getDelivaryDate());
	    	 orderGroup.setOriginalOrderQty(ordGrpEntity.getOriginalOrderQty());
	    	 orderGroup.setTruckNo(ordGrpEntity.getTruckNo());
	    	 orderGroup.setTruckCapacity(ordGrpEntity.getTruckCapacity());
	    	 orderGroup.setTruckOrderQty(Integer.parseInt(ordGrpEntity.getTruckOrderQty()));
	    	 orderGroupList.add(orderGroup);
		}
			return orderGroupList;
	}

	@Override
	public ShippingDetails1 getShippingDetails(String orderNo) {
		ShippingEntity shippingEntity = shippingOrderDao.getShippingDetails(orderNo);
		ShippingDetails1 shippingDetails = new ShippingDetails1();
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
		shippingDetails.setDistribution_channel(shippingEntity.getDistribution_channel());
		shippingDetails.setDeliv_date(shippingEntity.getDeliv_date());
		shippingDetails.setDelivery_type(shippingEntity.getDelivery_type());
		shippingDetails.setShipping_Point(shippingEntity.getShipping_Point());
		shippingDetails.setDistrict_code(shippingEntity.getDistrict_code());
		shippingDetails.setShip_to_party(shippingEntity.getShip_to_party());
		shippingDetails.setShip_to_long(shippingEntity.getShip_to_long());
		shippingDetails.setShip_to_latt(shippingEntity.getShip_to_latt());
		return shippingDetails;
	}
	@Override
	public List<String> getOrderNoByTruck(String truckNo) {
		return shippingOrderDao.getOrderNoByTruck(truckNo);
 	}

}
